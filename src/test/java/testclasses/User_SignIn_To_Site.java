package testclasses;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePage;

import common.BaseTest;

public class User_SignIn_To_Site extends BaseTest{

	@Test
	public void sign_In_With_IMDB(){
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.navigateToHomePage();	
		homePage.click_On_Sign_In_Options();
		homePage.click_On_SignIn_With_IMDB();
		homePage.user_SignIn_To_IMDB("chidusd@gmail.com", "Chidu%1432");
		String UserName = homePage.get_Signed_In_User_Name();
		Assert.assertEquals(UserName, "Chidambar Deshpande");
	}
}
