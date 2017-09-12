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
	private List<WebElement> SearchResults;
	
	@FindBy(css = "a[href='/title/tt0079501/fullcredits?ref_=tt_ql_1']")
	private WebElement FullCastLink;
	
	@FindBy(id = "nblogin")
	private WebElement SigninOptions;
	
	@FindBy(className = "list-group-item")
	private List<WebElement> SignInOptions;
	
	@FindBy(id = "ap_email")
	private WebElement UserID;
	
	@FindBy(id = "ap_password")
	private WebElement PasswordField;
	
	@FindBy(id = "signInSubmit")
	private WebElement SubmitSignIn;
	
	@FindBy(css = "a[href='/user/ur52276441/?ref_=nb_usr_prof_0']")
	private WebElement SignedInUserName;
	
	@FindBy(css = "li[id='navUserMenu']")
	private WebElement AccountDropDown;
	
	@FindBy(css = "a[href='/user/ur52276441/ratings?ref_=nv_usr_rt_4']")
	private WebElement YourRatings;


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
		SearchResults.get(0).click();
	}	
	
	public void showFullCast(){
		FullCastLink.click();
	}
	
	public void click_On_Sign_In_Options(){
		SigninOptions.click();
	}
	
	public void click_On_SignIn_With_IMDB(){
		SignInOptions.get(3).click();
	}
	
	public void user_SignIn_To_IMDB(String UserName, String Password){
		UserID.sendKeys(UserName);
		PasswordField.sendKeys(Password);
		SubmitSignIn.click();
	}
	
	public String get_Signed_In_User_Name(){
		return SignedInUserName.getText();
	}
	
	@SuppressWarnings("deprecation")
	public void open_Your_Ratings() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(AccountDropDown).pause(10000).moveToElement(YourRatings).build().perform();
		YourRatings.click();
		actions.pause(10000).perform();
	}
	
	
				
}
