package testclasses;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageClasses.HomePage;

import common.BaseTest;

public class Search_And_Open_Movie_Detail_Page extends BaseTest {

	@Test
	public void search_And_Open_Movie_Detail_Page(){
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.navigateToHomePage();	
		homePage.inputTextToSearchBar("Mad max");;
		homePage.submitSearchQuery();
		homePage.clickSearchResult();
		//Assert.assertEquals(driver.getCurrentUrl(), "http://www.imdb.com/title/tt2911666/?ref_=fn_al_tt_1");
	}
}
