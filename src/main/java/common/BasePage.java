package common;

import org.openqa.selenium.WebDriver;

public class BasePage {
		
	public WebDriver driver;
	public BrowserActions actions;
	
	public BasePage(WebDriver driver){
		driver = this.driver;
		actions = new BrowserActions(driver);
	}
	
}
