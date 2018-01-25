package testclasses;

import java.io.IOException;

import org.testng.annotations.Test;

import common.BaseTest;
import common.MyProperties;
import pageClasses.Home_Page;
import pageClasses.Movie_Detail_Page;

public class Compare_Movies_By_Rating extends BaseTest {
	
		MyProperties prop = new MyProperties();
	
		@Test	
		public void compare_Movies_By_Rating() throws IOException{
			
			String FirstMovie = prop.getProperty("searchquery1");
			String SecondMovie = prop.getProperty("searchquery2");
			double RatingFirstMovie;
			double RatingSecondMovie; 
			Home_Page homePage = new Home_Page(driver);
			homePage.inputTextToSearchBar(FirstMovie.toLowerCase());
			homePage.submitSearchQuery();
			homePage.clickSearchResult();
			Movie_Detail_Page movieDetailPage = new Movie_Detail_Page(driver);
			RatingFirstMovie = movieDetailPage.get_Overall_Movie_Rating();
			homePage.inputTextToSearchBar(SecondMovie.toLowerCase());
			homePage.submitSearchQuery();
			homePage.clickSearchResult();
			Movie_Detail_Page movieDetailPage_Second = new Movie_Detail_Page(driver);
			RatingSecondMovie = movieDetailPage_Second.get_Overall_Movie_Rating();
			compare_Double_Values(RatingFirstMovie, RatingSecondMovie, FirstMovie, SecondMovie);
		}
		
		public void compare_Double_Values(double FirstValue, double SecondValue, String MovieFirst, String MovieSecond){
			if(FirstValue > SecondValue){
				System.out.println("\n"+MovieFirst.toUpperCase() + " has higher ratings("+FirstValue+") than "+ MovieSecond.toUpperCase()+"\n\n");
			}
			else if(FirstValue < SecondValue){
				System.out.println("\n"+MovieSecond.toUpperCase() + " movie has higher ratings("+SecondValue+") than "+ MovieFirst.toUpperCase()+"\n\n");
			}
			else if(FirstValue == SecondValue){
				System.out.println("\nBoth the movies have same rating!!\n\n");
			}
		}

}
