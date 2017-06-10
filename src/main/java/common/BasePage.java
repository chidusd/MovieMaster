package common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
		
	public WebDriver driver;
	protected BrowserActions actions;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions = new BrowserActions(driver);
	}
	
	public enum Identifier {
	    ID, CSS, LINKTEXT, CLASSNAME,
	    NAME, PARTIAL, TAGNAME, XPATH 
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
