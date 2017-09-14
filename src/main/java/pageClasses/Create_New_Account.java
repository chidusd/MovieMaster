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
	private WebElement UserName;
	
	@FindBy(id = "ap_email")
	private WebElement UserEmail;
	
	@FindBy(id = "ap_password")
	private WebElement UserPassword;
	
	@FindBy(id = "ap_password_check")
	private WebElement UserPasswordCheck;
	
	@FindBy(css = "input[id='continue']")
	private WebElement CreateAccountButton;
	
	public void NavigateToCreateAccountPage(WebDriver driver) {
		driver.get("https://www.imdb.com/registration/signin");
		WebElement element = driver.findElement(By.linkText("Create a New Account"));
		element.click();
	}
	
	public void EnterAccountDetailsAndSubmit(String Name, String Email, String password) throws InterruptedException {
		UserName.sendKeys(Name);
		UserEmail.sendKeys(Email);
		UserPassword.sendKeys(password);
		UserPasswordCheck.sendKeys(password);
		CreateAccountButton.click();
		waitTimer(driver, 5000);
	}

}
