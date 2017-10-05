package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;
import common.BrowserActions;

public class Create_New_Account extends BasePage {
	
	WebDriver driver;
	BrowserActions actions;

	public Create_New_Account(WebDriver driver) {
		super(driver);
		this.driver = driver;	
		this.actions = new BrowserActions(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "ap_customer_name")
	private WebElement userName;
	
	@FindBy(id = "ap_email")
	private WebElement userEmail;
	
	@FindBy(id = "ap_password")
	private WebElement userPassword;
	
	@FindBy(id = "ap_password_check")
	private WebElement userPasswordCheck;
	
	@FindBy(css = "input[id='continue']")
	private WebElement createAccountButton;
	
	public void NavigateToCreateAccountPage(WebDriver driver) {
		driver.get("https://www.imdb.com/registration/signin");
		WebElement element = driver.findElement(By.linkText("Create a New Account"));
		element.click();
	}
	
	public void enterAccountDetailsAndSubmit(String Name, String Email, String password) throws InterruptedException {
		userName.sendKeys(Name);
		userEmail.sendKeys(Email);
		userPassword.sendKeys(password);
		userPasswordCheck.sendKeys(password);
		createAccountButton.click();
		waitTimer(driver, 5000);
	}

}
