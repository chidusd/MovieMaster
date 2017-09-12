package testclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.Home_Page;

import common.BaseTest;
import common.MyProperties;

public class User_SignIn_To_Site extends BaseTest{

	MyProperties prop = new MyProperties();
	
	@Test
	public void sign_In_With_IMDB() throws IOException{
		Home_Page homePage = new Home_Page(driver);
		homePage.click_On_Sign_In_Options();
		homePage.click_On_SignIn_With_IMDB();
		homePage.user_SignIn_To_IMDB(prop.getProperty("userid"), prop.getProperty("password"));
		Assert.assertEquals(homePage.get_Signed_In_User_Name(), prop.getProperty("username"));
	}
}
