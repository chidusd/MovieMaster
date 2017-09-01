package testclasses;

import org.testng.annotations.Test;

import pageClasses.Home_Page;
import pageClasses.Movie_Detail_Page;

import common.BaseTest;

public class Compare_Movies_By_Rating extends BaseTest {
	
		@Test	
		public void compare_Movies_By_Rating(){
			
			String FirstMovie = "equillibrium 2002";
			String SecondMovie = "fantastic beasts 2016";
			double RatingFirstMovie;
			double RatingSecondMovie; 
			Home_Page homePage = new Home_Page(driver);
			homePage.navigateToHomePage();	
			homePage.inputTextToSearchBar(FirstMovie.toLowerCase());
			homePage.submitSearchQuery();
			homePage.clickSearchResult();
			Movie_Detail_Page movieDetailPage = new Movie_Detail_Page(driver);
			RatingFirstMovie = movieDetailPage.get_Movie_Rating();
			homePage.inputTextToSearchBar(SecondMovie.toLowerCase());
			homePage.submitSearchQuery();
			homePage.clickSearchResult();
			Movie_Detail_Page movieDetailPage_Second = new Movie_Detail_Page(driver);
			RatingSecondMovie = movieDetailPage_Second.get_Movie_Rating();
			compare_Double_Values(RatingFirstMovie, RatingSecondMovie, FirstMovie, SecondMovie);
		}
		
		public void compare_Double_Values(double FirstValue, double SecondValue, String MovieFirst, String MovieSecond){
			if(FirstValue > SecondValue){
				System.out.println("\n"+MovieFirst.toUpperCase() + " has higher ratings than "+ MovieSecond.toUpperCase());
			}
			else if(FirstValue < SecondValue){
				System.out.println("\n"+MovieSecond.toUpperCase() + " has higher ratings than "+ MovieFirst.toUpperCase());
			}
			else if(FirstValue == SecondValue){
				System.out.println("\nBoth the movies have same rating!!");
			}
		}

}
