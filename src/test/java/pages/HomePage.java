package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;

public class HomePage extends TestBase {
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a.navbar-brand")
	WebElement homepagElement;

	@FindBy(id = "nameofuser")
	WebElement usernamElement;

	@FindBy(xpath = "//*[contains(text(),'s6')]")
	WebElement Samsungs6;
	
	@FindBy(xpath = "//a[contains(text(),'1520')]")
	WebElement Nokia1520;
	
	//Action methods
	public boolean verifyHomePage() {
		return homepagElement.isDisplayed();
	}

	public void verifyUserLoggedIn() {
		waitTime(2);
		String username = usernamElement.getText();
		System.out.println(username);
		boolean userloggedin = username.contains("yukeshdinesh@gmail.com");
		Assert.assertTrue(userloggedin);

	}
	
	public void selectsamsungS6() {
		Samsungs6.click();
	}

	public void selectNokia1520() {
		Nokia1520.click();
	}
}
