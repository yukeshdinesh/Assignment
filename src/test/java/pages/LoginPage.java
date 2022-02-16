package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "loginusername")
	WebElement usernamElement;

	@FindBy(id = "loginpassword")
	WebElement passwordElement;

	@FindBy(id = "login2")
	WebElement loginElement;

	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement loginButtonElement;

	public void UserLogin() {
		loginElement.click();
		waitTime(2);
		usernamElement.sendKeys("yukeshdinesh@gmail.com");
		passwordElement.sendKeys("Yukesh");
		loginButtonElement.click();

	}

}
