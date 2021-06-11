package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage {
	
	@FindBy(className = "heading-counter")
		private WebElement results;
	
	public WebElement strResult() {
		return results;
	}

}
