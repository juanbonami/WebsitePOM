package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
private static final String url = "http://automationpractice.com/index.php";
	
	// targets element/search bar
	@FindBy(xpath = "//input[@id='search_query_top']")
		private WebElement searchBar;
	
	// returns address
	public static String getUrl() {
		return url;
	}
	
	// inputs query and submit
	public void query(String item) {
		searchBar.sendKeys(item);
		searchBar.submit();
	}

}
