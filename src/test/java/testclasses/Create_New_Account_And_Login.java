package testclasses;

import org.testng.annotations.Test;

import common.BaseTest;
import pageClasses.Create_New_Account;

public class Create_New_Account_And_Login extends BaseTest {
	
	private String UserName = "Chidambar";
	private String UserEmail = "newemail6e5@mailinator.com";
	private String Password = "test123456";
	
@Test	
public void CreateNewAccount() throws InterruptedException {
	Create_New_Account createAccount = new Create_New_Account(driver);
	createAccount.NavigateToCreateAccountPage(driver);
	createAccount.EnterAccountDetailsAndSubmit(UserName,UserEmail,Password);
	Thread.sleep(5000);
}
	
}
