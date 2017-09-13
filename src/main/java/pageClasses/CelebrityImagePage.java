package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class CelebrityImagePage extends BasePage{

	public CelebrityImagePage(WebDriver driver) {
		super(driver);
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "button[class='pswp__button pswp__button--arrow--right']")
	private WebElement ForwardButton;
	
	public void browseCelebrityPhotos() throws InterruptedException {
		for(int i=0; i<25; i++) {
			ForwardButton.click();
			Thread.sleep(2000);
		}
	}

}
