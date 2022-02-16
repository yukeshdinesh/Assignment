package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ProductPage extends TestBase {

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[contains(text(),'s6')]")
	WebElement Samsungs6;
	
	@FindBy(xpath = "//*[contains(text(),'//a[contains(text(),'1520')]')]")
	WebElement Nokia1520;
	
	@FindBy(xpath = "//a[contains(text(),'Add to cart')]")
	WebElement addToCartElement;
	
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement homElement;
	
	public void addItemToCart() {
		waitTime(2);
		addToCartElement.click();
		waitTime(2);
		driver.switchTo().alert().accept();
		homElement.click();
		
	}

}
