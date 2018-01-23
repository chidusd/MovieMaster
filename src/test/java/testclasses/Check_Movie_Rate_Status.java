package testclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest;
import common.MyProperties;
import pageClasses.Home_Page;
import pageClasses.Movie_Detail_Page;

public class Check_Movie_Rate_Status extends BaseTest {
	
	MyProperties prop = new MyProperties();
	
	@Test
	public void rateUnratedMovie() throws IOException {
		Home_Page homePage = new Home_Page(driver);
		homePage.click_On_Sign_In_Options();
		homePage.click_On_SignIn_With_IMDB();
		homePage.user_SignIn_To_IMDB(prop.getProperty("userid"), prop.getProperty("password"));
		Assert.assertEquals(homePage.get_Signed_In_User_Name(), prop.getProperty("username"));
		homePage.inputTextToSearchBar(prop.getProperty("searchquery2").toLowerCase());
		homePage.submitSearchQuery();
		homePage.clickSearchResult();
		Movie_Detail_Page movieDetailPage = new Movie_Detail_Page(driver);
		System.out.println(movieDetailPage.isMovieRatedByUser());
		
	}
}