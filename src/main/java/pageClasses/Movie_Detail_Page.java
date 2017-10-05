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
	private WebElement movieRatingBar;
	
	@FindBy(css = "span[class='star-rating-text']")
	private WebElement noRating;
	
	@FindBy(css = ".star-rating-value")
	private List<WebElement> ratingGivenByUser;
	
	public String get_Movie_Name() {
		actions.applyExplicitWaitForElementToBeClickable(movieName);
		return movieName.getText();
	}
	
	public void play_Movie_Trailer() throws InterruptedException {
		try {
			if(movieTrailerImage.isDisplayed() == true){
				movieTrailerImage.click();
				waitTimer(driver, 30000);
			}
			else{
				System.out.println("Movie Trailer is not present!!");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("No Trailer Was Found For This Movie!!");
		}
	}
	
	public double get_Movie_Rating(){
		
		double MovieRating = 0.0;
		try {
			String RatingInText = movieRatingBar.getText();
			MovieRating =  Double.parseDouble(RatingInText);
			return MovieRating;
		} catch (NoSuchElementException e) {
			System.out.println("Ratings are not available for this movie");
			return MovieRating;
		}
		
	}
	
	public boolean isMovieNotRated() {
		boolean Result = false;
		if(noRating.isDisplayed() == false || noRating.isEnabled() == false) {
			Result = true;
		}
		return Result;
	}
	
	public boolean isMovieRated() {
		return ratingGivenByUser.get(0).isDisplayed();
	}
	
	public double getRatingGivenByUser() {
		return Double.parseDouble(ratingGivenByUser.get(0).getText());
	}
}
