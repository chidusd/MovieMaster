package testclasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import common.BaseTest;
import common.MyProperties;
import pageClasses.Create_New_Account;

public class Create_New_Account_And_Login extends BaseTest {
	
	MyProperties prop = new MyProperties();
	
	@Test	
	public void CreateNewAccount() throws InterruptedException, IOException {
		Create_New_Account createAccount = new Create_New_Account(driver);
		createAccount.NavigateToCreateAccountPage(driver);
		createAccount.EnterAccountDetailsAndSubmit(prop.getProperty("username"),prop.getProperty("newemail"),prop.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		}
	}
