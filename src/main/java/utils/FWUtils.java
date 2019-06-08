package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.joda.time.LocalDateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FWUtils {
	// Check if a element is present
	public static boolean existsElement(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// Check if a element is present
	public static boolean existsElement(WebDriver driver, By by) {
		return !driver.findElements(by).isEmpty();
	}

	// Check if a element is NOT present
	public static boolean noExistsElement(WebDriver driver, By by) {
		return driver.findElements(by).isEmpty();
	}

	// Convert "WebElement" to "By"
	public static By toByVal(WebElement we) {
		// By format = "[foundFrom] -> locator: term"
		// see RemoteWebElement toString() implementation
		String[] data = we.toString().split(" -> ")[1].replace("]", "").split(": ");
		String locator = data[0];
		String term = data[1];
		switch (locator) {
		case "xpath":
			return By.xpath(term);
		case "css selector":
			return By.cssSelector(term);
		case "id":
			return By.id(term);
		case "tag name":
			return By.tagName(term);
		case "name":
			return By.name(term);
		case "link text":
			return By.linkText(term);
		case "class name":
			return By.className(term);
		}
		return (By) we;
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++
	// ++++++++++++++++ ScreenShots +++++++++++++++++++

	// Guardar un ScreenShot
	public static String ScreenShot(WebDriver d) {
		String date = LocalDateTime.now().toString("yyyy-MM-dd_HH-mm-ss");
		File src = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		String filePath = System.getProperty("user.dir") + "/outputdata/screenshots/failures/Screen_" + date + ".png";
		try {
			FileUtils.copyFile(src, new File(filePath));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return filePath;
	}// End of function

	// Guardar un ScreenShot y permite ponerle un nombre a la captura
	public static String ScreenShot(WebDriver d, String _name) {
		String date = LocalDateTime.now().toString("yyyy-MM-dd_HH-mm-ss");
		File src = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		String filePath = System.getProperty("user.dir") + "/outputdata/screenshots/failures/" + _name + "_" + date
				+ ".png";
		try {
			FileUtils.copyFile(src, new File(filePath));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return filePath;
	}// End of function

	/**
	 * Guardar un ScreenShot y permite ponerle un nombre a la captura y decidir
	 * donde guardar la captura. La imagen se guarda en formato png
	 * 
	 * @param webDriver
	 * @param name
	 * @param path
	 */
	public static String ScreenShot(WebDriver d, String _name, String _path) {
		String date = LocalDateTime.now().toString("yyyy-MM-dd_HH-mm-ss");
		File src = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		String filePath = _path + "Screen_" + _name + "_" + date + ".png";
		try {
			FileUtils.copyFile(src, new File(filePath));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return filePath;
	}// End of function
}
