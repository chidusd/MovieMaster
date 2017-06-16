package testclasses;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pageClasses.Home_Page;
import pageClasses.Movie_Detail_Page;
import common.BaseTest;

public class Search_And_Open_Movie_Detail_Page extends BaseTest {

	@Test
	public void search_And_Open_Movie_Detail_Page(){
		String SearchQuery = "wonder woman";
		Home_Page homePage = new Home_Page(driver);
		homePage.navigateToHomePage();	
		homePage.inputTextToSearchBar(SearchQuery.toLowerCase());
		homePage.submitSearchQuery();
		homePage.clickSearchResult();
		Movie_Detail_Page movieDetailPage = new Movie_Detail_Page(driver);
		assertTrue(movieDetailPage.display_Movie_Name().toLowerCase().contains(SearchQuery.toLowerCase()));
	}
}
