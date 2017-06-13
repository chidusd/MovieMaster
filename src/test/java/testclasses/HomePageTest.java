package testclasses;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePage;
import common.BaseTest;

public class HomePageTest extends BaseTest {

	@Test
	public void performSearchFunction(){
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.navigateToHomePage();	
		homePage.inputTextToSearchBar("John Wick");;
		homePage.submitSearchQuery();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Find - IMDb");
	}
}
