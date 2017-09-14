package pageClasses;

import java.util.List;

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
	
	@FindBy(css = "div[class='pswp__zoom-wrap']")
	private List<WebElement> FirstImage;
	
	public void browseCelebrityPhotos() throws InterruptedException {
		for(int i=0; i<25; i++) {
			ForwardButton.click();
			waitTimer(driver, 2000);;
		}
	}
	
	public void clickOnFirstImage() {
		FirstImage.get(1).click();
	}

}
