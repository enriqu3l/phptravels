package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	private WebDriver driver;
	private WebDriverWait wait;
	
	//Constructor
	Login(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(username));
	}
	
	@FindBy(how=How.NAME, using="username")
	private WebElement username;
	
	@FindBy(how=How.NAME, using="password")
	private WebElement userpass;
	
	@FindBy(how=How.CLASS_NAME, using="loginbtn")
	private WebElement loginButton;
	
	
	public void setUsername(String name) {
		username.sendKeys(name.trim());
	}
	
	public void setPass(String pass) {
		userpass.sendKeys(pass.trim());
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
}
