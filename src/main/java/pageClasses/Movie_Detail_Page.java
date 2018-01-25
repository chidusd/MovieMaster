package pageClasses;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
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
	private WebElement movieName;
	
	@FindBy(css = "a[itemprop='trailer']")
	private WebElement movieTrailerImage;
	
	@FindBy(css = "span[itemprop='ratingValue']")
	private WebElement overAllMovieRatingBar;
	
	@FindBy(css = ".star-rating-value")
	private List<WebElement> ratingGivenByUser;
	
	@FindBy(css = "span[class='star-rating-star no-rating']")
	private WebElement ratingWidget;
	
	public String get_Movie_Name() {
		actions.applyExplicitWaitForElementToBeClickable(movieName);
		return movieName.getText();
	}
	
	public void play_Movie_Trailer() throws InterruptedException {
		try {
			if(movieTrailerImage.isDisplayed() == true){
				movieTrailerImage.click();
				waitTimer(driver, 35000);
			}
			else{
				System.out.println("Movie Trailer is not present!!");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("No Trailer Was Found For This Movie!!");
		}
	}
	
	public double get_Overall_Movie_Rating(){
		
		double MovieRating = 0.0;
		try {
			String RatingInText = overAllMovieRatingBar.getText();
			MovieRating =  Double.parseDouble(RatingInText);
			return MovieRating;
		} catch (NoSuchElementException e) {
			System.out.println("Ratings are not available for this movie"+"\n"+ratingGivenByUser.get(1).getText());
			return MovieRating;
		}
		
	}
	
	public double getRatingGivenByUser() {
		return Double.parseDouble(ratingGivenByUser.get(1).getText());
	}
	
	public String isMovieRatedByUser() {
	
		String message = null;
		try {
			if(ratingWidget.isDisplayed()) {
				message = "\nThis movie is not been rated by the user yet!!";
			}
		}
		catch(NoSuchElementException e) {
			message = "\nThis movie is already been rated by the user!!";
		}
		return message;
	}
}
