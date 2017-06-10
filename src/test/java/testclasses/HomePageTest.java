package testclasses;

import org.testng.annotations.Test;

import common.BaseTest;
import pageClasses.HomePage;

public class HomePageTest extends BaseTest {

	@Test
	public void performSearchFunction(){
		HomePage homePage = new HomePage(driver);
		homePage.navigateToHomePage();
		homePage.inputTextToSearchBar("John Wick");;
		homePage.submitSearchQuery();
	}

}
