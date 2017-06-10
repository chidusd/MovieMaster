package common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BasePage {
		
	public WebDriver driver;
	
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
