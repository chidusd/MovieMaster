package pageClasses;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;
import common.BrowserActions;

public class Movie_Detail_Page extends BasePage{

	WebDriver driver;
	BrowserActions actions;
	
	public Movie_Detail_Page(WebDriver driver){
		super(driver);
		this.driver = driver;	
		this.actions = new BrowserActions(driver);
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(css = "h1[itemprop='name']")
	private WebElement MovieName;
	
	@FindBy(css = "a[itemprop='trailer']")
	private WebElement MovieTrailerImage;
	
	public String display_Movie_Name() {
		return MovieName.getText();
	}
	
	public void play_Movie_Trailer() throws InterruptedException {
		try {
			if(MovieTrailerImage.isDisplayed() == true){
				MovieTrailerImage.click();
				Thread.sleep(60000);
			}
			else{
				System.out.println("Movie Trailer is not present!!");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("No Trailer Was Found For This Movie!!");
		}
	}
}
