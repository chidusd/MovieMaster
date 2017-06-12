package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePage;

import common.BaseTest;

public class HomePageTest extends BaseTest {

	@Test
	public void performSearchFunction(){
		HomePage homePage = new HomePage(driver);
		homePage.navigateToHomePage();
		homePage.inputTextToSearchBar("John Wick");;
		homePage.submitSearchQuery();
		Assert.assertEquals("http://www.imdb.com/find?ref_=nv_sr_fn&q=John+Wick&s=all", driver.getCurrentUrl());
	}
}
