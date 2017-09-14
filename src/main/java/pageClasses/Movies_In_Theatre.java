package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class Movies_In_Theatre extends BasePage {

	public Movies_In_Theatre(WebDriver driver) {
		super(driver);
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "h4[itemprop='name']")
	private List<WebElement> AllMovies;
	
	public void getAllMovieTitles() {
		for(int i=0; i< AllMovies.size(); i++) {
			System.out.println(AllMovies.get(i).getText());
		}
	}
	
	public void browseAllMoviesInTheatre() throws InterruptedException {
		Actions actions = new Actions(driver);
		for(int i=0; i< AllMovies.size(); i++) {
			actions.moveToElement(AllMovies.get(i)).perform();
			waitTimer(driver, 2000);
		}
		waitTimer(driver, 2000);
	}
}
