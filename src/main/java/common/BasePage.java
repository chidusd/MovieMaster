package common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
		
	public WebDriver driver;
	public BrowserActions actions;
	
	public BasePage(WebDriver driver){
		driver = this.driver;
		PageFactory.initElements(driver, this);
		actions = new BrowserActions(driver);
	}
	
	public WebElement getWebElement(WebDriver driver, By object){
	
		driver = this.driver;
		return driver.findElement(object);
	
	}
	
	
	public List<WebElement> getWebElements(WebDriver driver, By object){
		
		driver = this.driver;
		return driver.findElements(object);
					
	}

}
