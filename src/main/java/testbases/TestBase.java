package testbases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import pages.Pages;
import utils.BrowserFactory;

public abstract class TestBase {
	protected WebDriver driver;

	@BeforeTest
	public void start() {
		driver = BrowserFactory.startBrowser("chrome", "https://www.phptravels.net/");
		Pages.setDriver(driver);
	}

	@AfterTest
	public void stop() {
		driver.quit();
	}
	
	@BeforeMethod
	public void prerequisites(ITestContext itc) {
		itc.setAttribute("WebDriver", driver);
	}
}
