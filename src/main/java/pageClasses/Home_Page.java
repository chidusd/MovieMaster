package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;
import common.BrowserActions;

public class Home_Page extends BasePage {
	
	WebDriver driver;
	BrowserActions actions;
	
	public Home_Page(WebDriver driver){
		super(driver);
		this.driver = driver;	
		this.actions = new BrowserActions(driver);
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(id = "navbar-query")
	private WebElement searchBar;
	
	@FindBy(css = "div[class='magnifyingglass navbarSprite']")
	private WebElement searchSubmitButton;	
	
	@FindBy(className = "primary_photo") 
	private List<WebElement> searchResults;
	
	@FindBy(id = "nblogin")
	private WebElement signinOptions;
	
	@FindBy(className = "list-group-item")
	private List<WebElement> signInOptions;
	
	@FindBy(id = "ap_email")
	private WebElement userID;
	
	@FindBy(id = "ap_password")
	private WebElement passwordField;
	
	@FindBy(id = "signInSubmit")
	private WebElement submitSignIn;
	
	@FindBy(css = "a[href='/user/ur52276441/?ref_=nb_usr_prof_0']")
	private WebElement signedInUserName;
	
	@FindBy(css = "li[id='navUserMenu']")
	private WebElement accountDropDown;
	
	@FindBy(css = "a[href='/user/ur52276441/ratings?ref_=nv_usr_rt_4']")
	private WebElement yourRatings;
	
	@FindBy(css = "li[id='navTitleMenu']")
	private WebElement navigationBar;
	
	@FindBy(css = "a[href='/movies-in-theaters/?ref_=nv_mv_inth_1']")
	private WebElement moviesInTheatre;
	
	@FindBy(css = "img[src='https://images-na.ssl-images-amazon.com/images/M/MV5BMjA5MTMwMDQyN15BMl5BanBnXkFtZTgwNzU4MzgyNDM@._V1_SX307_CR0,0,307,230_AL_.jpg']")
	private List<WebElement> widgetImage;

	public void inputTextToSearchBar(String searchQuery){
		actions.clearAndSendKeysToElement(searchBar, searchQuery);
	}

	public void submitSearchQuery(){
		searchSubmitButton.click();
	}

	public void navigateToHomePage(){
		actions.getUrl("http://www.imdb.com/");
	}
	
	public void clickSearchResult(){
		searchResults.get(0).click();
	}	
	
	public void click_On_Sign_In_Options(){
		signinOptions.click();
	}
	
	public void click_On_SignIn_With_IMDB(){
		signInOptions.get(3).click();
	}
	
	public void user_SignIn_To_IMDB(String UserName, String Password){
		userID.sendKeys(UserName);
		passwordField.sendKeys(Password);
		submitSignIn.click();
	}
	
	public String get_Signed_In_User_Name(){
		return signedInUserName.getText();
	}
	
	@SuppressWarnings("deprecation")
	public void open_Your_Ratings() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(accountDropDown).pause(4000).moveToElement(yourRatings).build().perform();
		yourRatings.click();
		waitTimer(driver, 5000);
	}
	
	public void hoverOnNavigationBar() {
		Actions action = new Actions(driver);
		action.moveToElement(navigationBar).perform();
		waitTimer(driver, 2000);
		action.moveToElement(moviesInTheatre).perform();
		moviesInTheatre.click();
	}
	
	public void clickOnWidgetImage() {
		try {
			widgetImage.get(0).click();
			waitTimer(driver, 2000);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("\n\nNo Celebrity images vailable at this moment!!");
		}
	}
	
	
				
}
