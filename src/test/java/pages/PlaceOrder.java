package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class PlaceOrder extends TestBase {

	public PlaceOrder() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h5[contains(text(),'Place order')]")
	WebElement placeOrderHeading;

	@FindBy(id = "totalm")
	WebElement totalElement;

	@FindBy(id = "name")
	WebElement nameElement;

	@FindBy(id = "country")
	WebElement countryElement;

	@FindBy(id = "city")
	WebElement cityElement;

	@FindBy(id = "card")
	WebElement cardeElement;

	@FindBy(id = "month")
	WebElement monthElement;

	@FindBy(id = "year")
	WebElement yearElement;

	@FindBy(xpath = "//button[contains(text(),'Purchase')]")
	WebElement purchasElement;
	
	@FindBy(xpath = "(//h2)[3]")
	WebElement OrderSuccessMessage;
	
	@FindBy(css = "p.lead.text-muted ")
	WebElement successMessageandOrderDetails; 
	
	@FindBy(css = "button.confirm.btn.btn-lg.btn-primary")
	WebElement okbuttonElement;

	//Action methods
	public void purchaseItems() {
		waitTime(5);
		placeOrderHeading.isDisplayed();
		System.out.println(totalElement.getText());
		nameElement.sendKeys("Yukesh");
		countryElement.sendKeys("India");
		cityElement.sendKeys("Thiruvannamalai");
		cardeElement.sendKeys("123456789");
		monthElement.sendKeys("March");
		yearElement.sendKeys("2022");
		purchasElement.click();
		waitTime(5);
	}

	public void verifySuccessfulOrder() {
		waitTime(5);
		OrderSuccessMessage.isDisplayed();
		System.out.println(OrderSuccessMessage.getText());
		System.out.println(successMessageandOrderDetails);
		okbuttonElement.click();
	}

}
