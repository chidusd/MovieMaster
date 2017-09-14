package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
		
	public WebDriver driver;
	public BrowserActions actions;
	
	public BasePage(WebDriver driver){
		driver = this.driver;
		actions = new BrowserActions(driver);
	}
	
	@SuppressWarnings("deprecation")
	public void waitTimer(WebDriver driver,  long TimeInSeconds) {
		Actions act = new Actions(driver);
		act.pause(TimeInSeconds).perform();
	}
	
}
