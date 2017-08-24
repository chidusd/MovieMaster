package testclasses;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import common.BaseTest;
import pageClasses.Create_New_Account;

public class Create_New_Account_And_Login extends BaseTest {
	
	private String UserName = "Chidambar";
	private String UserEmail = "6t64erf5@mailinator.com";
	private String Password = "test123456";
	
@Test	
public void CreateNewAccount() throws InterruptedException {
	Create_New_Account createAccount = new Create_New_Account(driver);
	createAccount.NavigateToCreateAccountPage(driver);
	createAccount.EnterAccountDetailsAndSubmit(UserName,UserEmail,Password);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
	
}
