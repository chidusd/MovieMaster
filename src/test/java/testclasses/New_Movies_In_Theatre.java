package testclasses;

import org.testng.annotations.Test;

import common.BaseTest;
import pageClasses.Home_Page;
import pageClasses.Movies_In_Theatre;

public class New_Movies_In_Theatre extends BaseTest {
	
	@Test
	public void getCurrentMoviesInTheatre() throws InterruptedException {
		Home_Page homePage = new Home_Page(driver);
		homePage.hoverOnNavigationBar();
		Movies_In_Theatre mTheatre = new Movies_In_Theatre(driver);
		mTheatre.getAllMovieTitles();
		mTheatre.browseAllMoviesInTheatre();
	}

}
