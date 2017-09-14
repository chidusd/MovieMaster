package testclasses;

import org.testng.annotations.Test;

import common.BaseTest;
import pageClasses.CelebrityImagePage;
import pageClasses.Home_Page;

public class Browse_Celebrity_Photos extends BaseTest{
	
	@Test
	public void browseCelebrityPhotos() throws InterruptedException {
		Home_Page homePage = new Home_Page(driver);
		homePage.clickOnWidgetImage();
		CelebrityImagePage CI = new CelebrityImagePage(driver);
		CI.clickOnFirstImage();
		CI.browseCelebrityPhotos();
	}

}
