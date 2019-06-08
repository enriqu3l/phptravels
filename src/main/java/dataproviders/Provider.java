package dataproviders;

import org.testng.annotations.DataProvider;

public class Provider {
	
	@DataProvider(name="provideUserLogin")
	public Object[][] provideUserLogin() {
		return new Object[][] {
			   { "user@phptravels.com","demouser" }
			 };
	}
	
}
