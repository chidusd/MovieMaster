package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserActions {
	
	WebDriver driver;
	public BrowserActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getUrl(String url){
		driver.get(url);
	}
	
	public void clearAndSendKeysToElement(WebElement element, String text){
		element.clear();
		element.sendKeys(text);
	}
	
	public boolean isElementDisplayed(WebElement element){
		applyImplicitWait();
		Actions actions = new Actions(driver);
		WebElement moveonmenu = driver.findElement(By.xpath("//div[@id='menu1']/div"));
		actions.moveToElement(moveonmenu).build().perform();;
		actions.click();
		actions.perform();
		return element.isDisplayed();
	}
	
	public void applyImplicitWait(){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void applyExplicitWaitForElementToBeClickable(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void clickOnElement(WebElement element){
		element.click();
	}
	
	public String getText(WebElement element){
		return element.getText();
	}
	
	public void navigateBack(){
		driver.navigate().back();
	}
	
	public void navigateForword(){
		driver.navigate().forward();
	}
}
