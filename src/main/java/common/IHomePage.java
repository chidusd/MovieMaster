package common;

public interface IHomePage {
	
	public void inputTextToSearchBar(String searchQuery);
	
	public void submitSearchQuery();

	public void navigateToHomePage();
	
	public void clickSearchResult();
	
	public void showFullCast();
	
	public void click_On_Sign_In_Options();
	
	public void click_On_SignIn_With_IMDB();
	
	public void user_SignIn_To_IMDB(String UserName, String Password);
	
	public String get_Signed_In_User_Name();

}
