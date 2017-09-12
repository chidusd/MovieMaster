package common;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public WebDriver driver;

	@BeforeClass
	public void launchBrowser(){		
		String systemOS = System.getProperty("os.name").toLowerCase();
		switch (systemOS) {
		case "windows 8.1":
		case "windows 8":
		case "windows 10":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\lib\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions(); 
			options.addArguments("disable-infobars"); 
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			break;
		default:
			SafariOptions safariOpts = new SafariOptions();
			DesiredCapabilities cap = DesiredCapabilities.safari();

			safariOpts.setUseCleanSession(true);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "dismiss");
			cap.setCapability(SafariOptions.CAPABILITY, safariOpts);
			cap.setBrowserName("safari");
			cap.setPlatform(Platform.MAC);
			driver = new SafariDriver(cap);
			driver.manage().window().maximize();
			break;
		}
	}
	
	@BeforeMethod
	public void goToHomePage() {
		driver.get("http://www.imdb.com/");
	}

	@AfterClass
	public void quitBrowser(){
		driver.quit();
	}

}
