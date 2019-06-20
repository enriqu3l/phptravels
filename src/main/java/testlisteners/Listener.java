package testlisteners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.FWUtils;

public class Listener implements ITestListener{
	private WebDriver driver = null;

	@Override
	public void onTestStart(ITestResult result) {
		//
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ITestContext context = result.getTestContext();
	    driver = (WebDriver) context.getAttribute("WebDriver");
		
		//Imprimir pantalla de la falla!
	    String path = "./outputdata/screenshots/failures/";
		FWUtils.ScreenShot(driver, "FAILURE-"+result.getName(), path);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		//
	}

	@Override
	public void onStart(ITestContext context) {
		//
	}

	@Override
	public void onFinish(ITestContext context) {
		//
	}
}
