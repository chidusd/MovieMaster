package testclasses;

import static org.testng.Assert.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import common.BaseTest;
import pageClasses.Home_Page;
import pageClasses.Movie_Detail_Page;

public class Search_And_Open_Movie_Detail_Page extends BaseTest {

	@Test
	public void search_And_Open_Movie_Detail_Page() throws Exception{
		String SearchQuery = "fantastic beasts and where to find them";
		Home_Page homePage = new Home_Page(driver);
		homePage.navigateToHomePage();	
		homePage.inputTextToSearchBar(SearchQuery.toLowerCase());
		homePage.submitSearchQuery();
		homePage.clickSearchResult();
		Movie_Detail_Page movieDetailPage = new Movie_Detail_Page(driver);
	    getscreenshot();
		Thread.sleep(6000);
		assertTrue(movieDetailPage.get_Movie_Name().toLowerCase().contains(SearchQuery.toLowerCase()));
		
	}
	
	public void getscreenshot() throws Exception 
    {
            File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with name "screenshot.png"
            FileUtils.copyFile(file, new File("D:\\screenshot.png"));
    }
}
