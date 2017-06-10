package Operation;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.BrowserActions;

public class UIOperation {
    
	WebDriver driver;
	BrowserActions actions;
    
    public UIOperation(WebDriver driver){
        this.driver = driver;
        actions = new BrowserActions(driver);
    }
    
    public void performAction(Properties p, String operation, String objectName, String objectType, String value) throws Exception{
    	System.out.println("");
        switch (operation.toUpperCase()) {
        case "CLICK":
            driver.findElement(this.getObject(p,objectName,objectType)).click();
            Thread.sleep(1000);
            break;
        case "SETTEXT":
            actions.clearAndSendKeysToElement(driver.findElement(this.getObject(p,objectName,objectType)), value);
            Thread.sleep(1000);
            break;
        case "GOTOURL":
            actions.getUrl(p.getProperty(value));
            Thread.sleep(1000);
            break;
        case "GETTEXT":
            actions.getText(driver.findElement(this.getObject(p,objectName,objectType)));
            Thread.sleep(1000);
            break;
        default:
            break;
        }
    }

    private By getObject(Properties p, String objectName, String objectType) throws Exception{
    	
        if(objectType.equalsIgnoreCase("XPATH"))
            return By.xpath(p.getProperty(objectName));
        else if(objectType.equalsIgnoreCase("CLASSNAME"))
            return By.className(p.getProperty(objectName));
        else if(objectType.equalsIgnoreCase("NAME"))
            return By.name(p.getProperty(objectName));
        else if(objectType.equalsIgnoreCase("CSS"))
            return By.cssSelector(p.getProperty(objectName));
        else if(objectType.equalsIgnoreCase("LINK"))
            return By.linkText(p.getProperty(objectName));
        else if(objectType.equalsIgnoreCase("PARTIALLINK"))
            return By.partialLinkText(p.getProperty(objectName));
        else if(objectType.equalsIgnoreCase("ID"))
            return By.id(p.getProperty(objectName));
        else
            throw new Exception("Invalid object type.");
    }
}