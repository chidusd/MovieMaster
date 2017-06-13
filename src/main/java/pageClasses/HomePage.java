package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import common.BasePage;
import common.BrowserActions;

public class HomePage extends BasePage {
	
	WebDriver driver;
	BrowserActions actions;
	
	public HomePage(WebDriver driver){
		super(driver);
		this.driver = driver;	
		this.actions = new BrowserActions(driver);
		}
	
	@FindBy(css = "input[id='navbar-query']")
	private WebElement searchBar;
	
	@FindBy(css = "div[class='magnifyingglass navbarSprite']")
	private WebElement searchSubmitButton;	
	
	@FindBys( {
		   @FindBy(className = "result_text")
		} )
	private List<WebElement> SearchResults;
	
	
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
				
}
