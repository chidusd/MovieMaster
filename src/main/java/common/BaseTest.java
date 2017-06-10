package common;

import java.io.IOException;
import java.util.Properties;

import utilities.ExcelUtils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Operation.ReadObjectRepo;
import Operation.UIOperation;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeClass
	public void launchBrowser(){
		String systemOS = System.getProperty("os.name");
		switch (systemOS) {
		case "Windows 8.1":
		case "Windows 8":
		case "Windows 10":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//lib//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		default:
			driver = new SafariDriver();
			driver.manage().window().maximize();
			break;
		}
	}
	
	@AfterClass
	public void quitBrowser(){
		driver.quit();
	}
	
	protected void readObectAndPerformOpertions(Properties allObjects, Sheet sheet, String tag) throws Exception {
		UIOperation uIoperation = new UIOperation(driver);
		boolean isRowStarted = false;
		int rowCount = sheet.getLastRowNum();
		for (int i = 1; i < rowCount + 1; i++) {
	        Row row = sheet.getRow(i);
	        if((row.getCell(0) != null && row.getCell(0).toString().trim().equalsIgnoreCase(tag)) || isRowStarted){
	        	if(row.getCell(0) != null && !row.getCell(0).toString().trim().isEmpty() && isRowStarted){
	        		break;
	        	}
	        	isRowStarted = true;
	        	System.out.println(row.getCell(1).toString() + "*****" + row.getCell(2).toString() + "*****" + row.getCell(3).toString() + "*****" + row.getCell(4).toString());
	        	String operation = row.getCell(1).toString();
	        	String objectName = row.getCell(2).toString();
	        	String objectType = row.getCell(3).toString();
	        	String objectValue = row.getCell(4).toString();
	        	uIoperation.performAction(allObjects, operation, objectName, objectType, objectValue);
	        }
	    }
	}
	
	protected void executeTest(String filePath, String fileName, String sheetName, String tag) throws IOException, Exception {
		ExcelUtils file = new ExcelUtils();
		ReadObjectRepo object = new ReadObjectRepo();
		Properties allObjects = object.getObjectRepository();
		Sheet sheet = file.readExcel(filePath, fileName, sheetName);
	    readObectAndPerformOpertions(allObjects, sheet, tag);
	}
}
