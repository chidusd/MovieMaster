package testclasses;

import org.testng.annotations.Test;

import common.BaseTest;
import pageClasses.Home_Page;
import pageClasses.Movie_Detail_Page;

public class Play_Movie_Trailer extends BaseTest {
	
	@Test
	public void play_Movie_Trailer() throws InterruptedException{
		String SearchQuery = "mad max";
		Home_Page homePage = new Home_Page(driver);
		homePage.navigateToHomePage();	
		homePage.inputTextToSearchBar(SearchQuery.toLowerCase());
		homePage.submitSearchQuery();
		homePage.clickSearchResult();
		Movie_Detail_Page movieDetailPage = new Movie_Detail_Page(driver);
		movieDetailPage.play_Movie_Trailer();
	}
	

}
