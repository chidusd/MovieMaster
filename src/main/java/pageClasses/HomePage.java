package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BasePage;
import common.BrowserActions;

public class HomePage extends BasePage {
	
	WebDriver driver;
	BrowserActions actions;
	
	@FindBy(id = "navbar-query")
	private WebElement searchBar;
	
	@FindBy(css = "div[class='magnifyingglass navbarSprite']")
	private WebElement searchSubmitButton;
	
	public HomePage(WebDriver driver){
		super(driver);
		this.driver = driver;
	}

	public void inputTextToSearchBar(String searchQuery){
		actions.clearAndSendKeysToElement(searchBar, searchQuery);
	}

	public void submitSearchQuery(){
		searchSubmitButton.click();
	}

	public void navigateToHomePage(){
		actions.getUrl("http://www.imdb.com/");
	}
				
}
