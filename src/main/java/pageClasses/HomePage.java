package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;

public class HomePage extends BasePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
		private WebElement SearchBar = getWebElement(driver, By.id("navbar-query"));
		private WebElement SearchSubmitButton = getWebElement(driver, By.cssSelector("div[class='magnifyingglass navbarSprite']"));
		
		public void inputTextToSearchBar(String SearchQuery){
			
			SearchBar.clear();
			SearchBar.sendKeys(SearchQuery);
		}
		
		public void submitSearchQuery(){
			SearchSubmitButton.click();
		}
	
		public void navigateToHomePage(){
			driver.get("http://www.imdb.com/");
		}
				
}
