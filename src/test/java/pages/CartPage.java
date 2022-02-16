package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class CartPage extends TestBase {

	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Cart')]")
	WebElement carteElement;

	@FindBy(xpath = "//button[contains(text(),'Place Order')]")
	WebElement placeorderElement;

	@FindBy(xpath = "//td[contains(text(),'Nokia lumia 1520')]")
	WebElement nokiaElement;

	@FindBy(xpath = "//td[contains(text(),'Samsung galaxy s6')]")
	WebElement samsungElement;

	@FindBy(xpath = "//tr[@class='success']")
	List<WebElement> availableItems;

	@FindBy(xpath = "//a[contains(text(),'Delete')]")
	WebElement deletElement;

	// Action methods
	public void selectCart() {
		waitTime(3);
		carteElement.click();
		waitTime(3);
	}

	public void verifyPlaceOrderButton() {
		placeorderElement.isDisplayed();
	}

	public void verifyProducts(String product) {

		waitTime(3);
		if (product.equalsIgnoreCase("Samsung galaxy s6")) {
			nokiaElement.isDisplayed();
		} else if (product.equalsIgnoreCase("Nokia lumia 1520")) {
			samsungElement.isDisplayed();
		}
	}

	public void availableItem() {
		waitTime(3);
		int size = availableItems.size();

		Assert.assertTrue(size > 0);

	}

	public void removeItem() {
		deletElement.click();
		waitTime(5);
	}

	public void selectPlaceOrder() {
		placeorderElement.click();
	}

}
