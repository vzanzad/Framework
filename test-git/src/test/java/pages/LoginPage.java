package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(id = "login_field")
	@CacheLookup
	WebElement username;

	@FindBy(how = How.ID, using = "password")
	@CacheLookup
	WebElement password;

	@FindBy(how = How.XPATH, using = ".//input[@name='commit']")
	@CacheLookup
	WebElement submit_button;

	
	
	public void login(String uid, String pass) {
		username.sendKeys(uid);
		password.sendKeys(pass);
		submit_button.click();
	}
	 
	 

	/*
	 * public void enterUsername(String uname) { username.sendKeys(uname); }
	 * 
	 * public void enterPassword(String passwd) { password.sendKeys(passwd); }
	 * 
	 * public void clickSubbitButton() { submit_button.click(); }
	 */

}
