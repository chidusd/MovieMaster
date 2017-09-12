package testclasses;

import java.io.IOException;

import org.testng.annotations.Test;

import common.BaseTest;
import common.MyProperties;
import pageClasses.Home_Page;

public class Login_And_Your_Ratings extends BaseTest{
	
	MyProperties prop = new MyProperties();
	
	@Test
	public void loginAndYourRatings() throws InterruptedException, IOException {
		Home_Page homePage = new Home_Page(driver);
		homePage.click_On_Sign_In_Options();
		homePage.click_On_SignIn_With_IMDB();
		homePage.user_SignIn_To_IMDB(prop.getProperty("userid"), prop.getProperty("password"));
		homePage.open_Your_Ratings();
	}

}
