package stepdefinitions;

import java.util.ArrayList;
import java.util.List;
import base.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaceOrder;
import pages.ProductPage;

public class Feature1Stepdef extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	ProductPage productPage;
	CartPage cartPage;
	PlaceOrder placeOrder;
	ArrayList<String> itemArrayList = new ArrayList<String>();
	
	@Before
	public void setup() {
		initialize();
		homePage = new HomePage();
		loginPage = new LoginPage();
		productPage = new ProductPage();
		cartPage = new CartPage();
		placeOrder = new PlaceOrder();
	}
	
	@Given("Login into App")
	public void login_into_app() {
		homePage.verifyHomePage();
		loginPage.UserLogin();
		homePage.verifyUserLoggedIn();
	}

	@When("User Adds multiple {string} to cart")
	public void user_adds_multiple_to_cart_using_scenario_outline_examples(String item) {
		
		if(item.equalsIgnoreCase("Samsung galaxy s6")) {
			homePage.selectsamsungS6();
			productPage.addItemToCart();
		}
		else if (item.equalsIgnoreCase("Nokia lumia 1520")) {
			homePage.selectNokia1520();
			productPage.addItemToCart();
		}
		
	}
	
	@When("User Adds multiple {string}, {string} to cart")
	public void user_adds_multiple_to_cart(String item, String item2) {
		itemArrayList.add(item);
		itemArrayList.add(item2);
		for (String string : itemArrayList) {
			if(string.equalsIgnoreCase("Samsung galaxy s6") || item2.equalsIgnoreCase("Samsung galaxy s6")) {
				homePage.selectsamsungS6();
				productPage.addItemToCart();
			}
			else if (string.equalsIgnoreCase("Nokia lumia 1520")  || item2.equalsIgnoreCase("Nokia lumia 1520")) {
				homePage.selectNokia1520();
				productPage.addItemToCart();
			}
		}
		
	}




@Then("Items must be added to cart")
public void items_must_be_added_to_cart() {
	cartPage.selectCart();
	waitTime(3);
   cartPage.verifyPlaceOrderButton();
   for (String string : itemArrayList) {
	   cartPage.verifyProducts(string);
}
   
     
}

@When("Items should be available in cart")
public void items_should_be_available_in_cart() {
	cartPage.selectCart();
	
   cartPage.availableItem();
   
     
}

@Then("Delete an item from Cart")
public void delete_an_item_from_cart() {
	cartPage.removeItem();
     
}

@When("Items should be available in Cart")
public void items_should_be_available_in_cart(DataTable dataTable) {
   
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
	cartPage.selectCart();
	cartPage.verifyPlaceOrderButton();
	List<List<String>> itemlist = dataTable.asLists();
	String item = itemlist.get(0).get(0);
	cartPage.verifyProducts(item);
	
	
     
}

@Then("Place Order")
public void place_order() {
	cartPage.selectPlaceOrder();
     
}

@Then("Purchase Items")
public void purchase_items() {
   placeOrder.purchaseItems();
     placeOrder.verifySuccessfulOrder();
}



}
