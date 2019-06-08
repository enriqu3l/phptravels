package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;

public class BrowserFactory {
	public static String BASEURL;
	public static boolean CANCELNOTIFICATIONS = true;
	public static int PAGELOADTIMEOUT = 30;
	
	public static WebDriver startBrowser(String _browserName) {
		Assert.assertFalse((_browserName.equals("") || _browserName.equals(null)),"El parametro _browserName es nullo o no contiene informacion");
		WebDriver driver = null;
		
		if(_browserName.equalsIgnoreCase("firefox")) {
			if(CANCELNOTIFICATIONS) {
				//Desabilitando las notificaciones
				FirefoxProfile profile =new FirefoxProfile();
				profile.setPreference("dom.webnotifications.enabled", false);
				FirefoxOptions option=new FirefoxOptions();
				option.setProfile(profile);
				driver = new FirefoxDriver(option);
			}else {
				driver = new FirefoxDriver();
			}
		}
		else if(_browserName.equalsIgnoreCase("chrome")) {
			if(CANCELNOTIFICATIONS) {
				//Opening chrome with notification disabled
				ChromeOptions ops = new ChromeOptions();
	            ops.addArguments("--disable-notifications");
				driver = new ChromeDriver(ops);
			}else {
				driver = new ChromeDriver();
			}
		}
		else if(_browserName.equalsIgnoreCase("ie")) {
			//Me falta agregar el if de la cancelacion de notificaciones en ie
			driver = new InternetExplorerDriver();
		}
		else if(_browserName.equalsIgnoreCase("opera")) {
			//Me falta agregar el if de la cancelacion de notificaciones en opera
			driver = new OperaDriver();
		}else{
			Assert.fail("No se ha especificado el browser correctamente (solo se acepta: chrome, firefox, ie, opera)");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(PAGELOADTIMEOUT, TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver startBrowser(String _browserName, String _url) {
		Assert.assertFalse((_browserName.equals("") || _browserName.equals(null)),"El parametro _browserName es nullo o no contiene informacion");
		Assert.assertFalse((_url.equals("") || _url.equals(null)),"El parametro _url es nullo o no contiene informacion");
		WebDriver driver = null;
		
		if(_browserName.equalsIgnoreCase("firefox")) {
			if(CANCELNOTIFICATIONS) {
				//Desabilitando las notificaciones
				FirefoxProfile profile =new FirefoxProfile();
				profile.setPreference("dom.webnotifications.enabled", false);
				FirefoxOptions option=new FirefoxOptions();
				option.setProfile(profile);
				driver = new FirefoxDriver(option);
			}else {
				driver = new FirefoxDriver();
			}
		}
		else if(_browserName.equalsIgnoreCase("chrome")) {
			if(CANCELNOTIFICATIONS) {
				//Opening chrome with notification disabled
				ChromeOptions ops = new ChromeOptions();
	            ops.addArguments("--disable-notifications");
				driver = new ChromeDriver(ops);
			}else {
				driver = new ChromeDriver();
			}
		}
		else if(_browserName.equalsIgnoreCase("ie")) {
			//Me falta agregar el if de la cancelacion de notificaciones en ie
			driver = new InternetExplorerDriver();
		}
		else if(_browserName.equalsIgnoreCase("opera")) {
			//Me falta agregar el if de la cancelacion de notificaciones en opera
			driver = new OperaDriver();
		}else{
			Assert.fail("No se ha especificado el browser correctamente (solo se acepta: chrome, firefox, ie, opera)");
		}
		driver.manage().window().maximize();
		driver.get(_url);
		driver.manage().timeouts().pageLoadTimeout(PAGELOADTIMEOUT, TimeUnit.SECONDS);
		return driver;
	}
}
