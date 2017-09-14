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
	private WebElement MovieName;
	
	@FindBy(css = "a[itemprop='trailer']")
	private WebElement MovieTrailerImage;
	
	@FindBy(css = "span[itemprop='ratingValue']")
	private WebElement MovieRatingBar;
	
	@FindBy(css = "span[class='star-rating-text']")
	private WebElement NoRating;
	
	@FindBy(css = ".star-rating-value")
	private List<WebElement> RatingGivenByUser;
	
	public String get_Movie_Name() {
		actions.applyExplicitWaitForElementToBeClickable(MovieName);
		return MovieName.getText();
	}
	
	public void play_Movie_Trailer() throws InterruptedException {
		try {
			if(MovieTrailerImage.isDisplayed() == true){
				MovieTrailerImage.click();
				waitTimer(driver, 25000);
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
			String RatingInText = MovieRatingBar.getText();
			MovieRating =  Double.parseDouble(RatingInText);
			return MovieRating;
		} catch (NoSuchElementException e) {
			System.out.println("Ratings are not available for this movie");
			return MovieRating;
		}
		
	}
	
	public boolean isMovieNotRated() {
		return NoRating.isDisplayed();
	}
	
	public boolean isMovieRated() {
		return RatingGivenByUser.get(0).isDisplayed();
	}
	
	public double getRatingGivenByUser() {
		return Double.parseDouble(RatingGivenByUser.get(0).getText());
	}
}
