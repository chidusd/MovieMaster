package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class LoginPage extends BasePage{
	WebDriver driver;

	@FindBy(css = "#txtUsername")
	private WebElement usernameTextBox;
	
	@FindBy(css = "#txtPassword")
	private WebElement passwordTextBox;
	
	@FindBy(css = "#btnLogin")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
