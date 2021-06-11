package tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;
import pages.ResultsPage;

public class TestWebsite {
	
	static WebDriver driver;

	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();

	}

	@Before
	public void setup() {
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(HomePage.getUrl());

	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		HomePage searchBar = PageFactory.initElements(driver, HomePage.class);
		ResultsPage results = PageFactory.initElements(driver, ResultsPage.class);
		Thread.sleep(2000);
		
		searchBar.query("dress");
		Thread.sleep(2000);
		
		assertEquals("7 results have been found.", results.strResult().getText());
		Thread.sleep(2000);

	}

}
