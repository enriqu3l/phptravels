package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dataproviders.Provider;
import pages.Pages;
import testbases.TestBase;

public class LoginTest extends TestBase{
	
	
	// Simple
	@Test (enabled=true, priority = 1)
	public void TestLogin() {
    	Pages.home().clickMyAccount();
    	Pages.home().clickLogin();
    	Pages.login().setUsername("user@phptravels.com");
    	Pages.login().setPass("demouser");
    	Pages.login().clickLoginButton();
	}
	
	
	// Parameters 
	@Test (enabled=true, priority = 1)
	@Parameters({"usuario","pass"})
	public void TestLogin2(String usuario, String pass) {
		Pages.home().clickMyAccount();
    	Pages.home().clickLogin();
    	Pages.login().setUsername(usuario);
    	Pages.login().setPass(pass);
    	Pages.login().clickLoginButton();
	}
	
	
	// Data Providers
	@Test (enabled=false, dataProvider = "provideUserLogin", dataProviderClass = Provider.class)
	public void TestLogin3(String usuario, String pass) {
		Pages.home().clickMyAccount();
    	Pages.home().clickLogin();
    	Pages.login().setUsername(usuario);
    	Pages.login().setPass(pass);
    	Pages.login().clickLoginButton();
	}	
	
}
