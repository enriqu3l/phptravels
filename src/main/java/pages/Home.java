package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
	private WebDriver driver;
	private WebDriverWait wait;
	
	//Constructor
	Home(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,20);
	}
	
	@FindBy(how=How.CSS, using="nav #li_myaccount > a")
	private WebElement myAccount;
	
	@FindBy(how=How.CSS, using="nav #li_myaccount li a")
	private WebElement login;
	
	public void clickMyAccount() {
		myAccount.click();
	}
	
	public void clickLogin() {
		login.click();
	}
		
}
