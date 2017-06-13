package testclasses;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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
		Assert.assertEquals(driver.getCurrentUrl(), "http://www.imdb.com/find?ref_=nv_sr_fn&q=Mad+max&s=all","Expected Result does not match with the actual result");
	}
}
