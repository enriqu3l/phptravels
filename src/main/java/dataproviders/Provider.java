package dataproviders;

import org.testng.annotations.DataProvider;

public class Provider {
	
	@DataProvider(name="provideUserLogin")
	public Object[][] provideUserLogin() {
		
		//Aqui el codigo para obtener datos
		//Puede ser BD, Excel, CSV, txt, etc..
		
		return new Object[][] {
			   { "user@phptravels.com","demouser" }
			 };
	}
	
}
