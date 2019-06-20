package pages;

import org.openqa.selenium.WebDriver;

public class Pages {
	private static WebDriver driver;
	
	public static void setDriver(WebDriver _driver) {
		driver = _driver;
	}
	
	public static Home home() {
		return new Home(driver);
	}

	public static Login login() {
		return new Login(driver);
	}

}
