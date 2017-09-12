package testclasses;

import org.testng.annotations.Test;

import common.BaseTest;
import pageClasses.Home_Page;

public class Login_And_Your_Ratings extends BaseTest{
	
	@Test
	public void loginAndYourRatings() throws InterruptedException {
		Home_Page homePage = new Home_Page(driver);
		homePage.navigateToHomePage();	
		homePage.click_On_Sign_In_Options();
		homePage.click_On_SignIn_With_IMDB();
		homePage.user_SignIn_To_IMDB("chidusd@gmail.com", "Chidu%1432");
		homePage.open_Your_Ratings();
	}

}
