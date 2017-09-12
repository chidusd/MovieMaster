package testclasses;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import common.BaseTest;
import pageClasses.Home_Page;
import pageClasses.Movie_Detail_Page;

public class Play_Movie_Trailer extends BaseTest {
	
	@Test
	public void play_Movie_Trailer() throws Exception{
		String SearchQuery = "ray donovan";
		Home_Page homePage = new Home_Page(driver);
		homePage.navigateToHomePage();	
		homePage.inputTextToSearchBar(SearchQuery.toLowerCase());
		homePage.submitSearchQuery();
		homePage.clickSearchResult();
		Movie_Detail_Page movieDetailPage = new Movie_Detail_Page(driver);
		movieDetailPage.play_Movie_Trailer();
		getscreenshot();
		System.out.println("Screenshot successfully taken");
	}
	
	public void getscreenshot() throws Exception 
    {
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\lib\\NewImage.png"));
    }

}
