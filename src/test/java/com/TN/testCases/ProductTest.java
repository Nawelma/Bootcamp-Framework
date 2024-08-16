package com.TN.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TN.base.TestBase;
import com.TN.pages.AddToCartPage;
import com.TN.pages.CheckoutPage;
import com.TN.pages.HomePage;
import com.TN.pages.ProductPage;

@Test
public class ProductTest<ShoppingCartPage> extends TestBase {

	public ProductTest() throws Exception {
		super();
		
		}
		
	public WebDriver driver;
public HomePage homepage;
public ShoppingCartPage shoppingcart;
	
	@BeforeMethod
	public void setup() {
		driver = Initialization(prop.getProperty("browser"));
	}
	
	@Test(priority = 1)
	public void searchWithValidProduct() {
		HomePage homepage = new HomePage(driver);
		homepage.entervalidProduct(dataProp.getProperty("validProduct"));
		homepage.clickOnSearchButton();
		ProductPage productpage = new ProductPage(driver);
		Assert.assertTrue(productpage.verifyProductExistance());
	}
	
	@Test(priority = 2)
	public void searchWithInvalidProduct() {
		
		HomePage homepage = new HomePage(driver);
		homepage.entervalidProduct(dataProp.getProperty("invalidProduct"));
		homepage.clickOnSearchButton();
		ProductPage productpage = new ProductPage(driver);
		String actualMessage = productpage.verifyWarningMessage() ;
		String expectedMessage = dataProp.getProperty("WarningText");
		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}
	

	@Test(priority = 3)
	public void searchWithNoProduct() {
		
		HomePage homepage = new HomePage(driver);
		homepage.clickOnSearchButton();
        ProductPage productpage = new ProductPage(driver);
		String actualMessage = productpage.verifyWarningMessage() ;
		String expectedMessage = dataProp.getProperty("WarningText");
		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test(priority = 4)
	public void addValidProductAndCompleteCheckout() {
		HomePage homepage = new HomePage(driver);
		homepage.entervalidProduct(dataProp.getProperty("validProduct"));
		homepage.clickOnSearchButton();
		ProductPage productpage = new ProductPage(driver);
		Assert.assertTrue(productpage.verifyProductExistance());
		ProductPage productPage2 = new ProductPage(driver);
		productPage2.clickOnAddToCard();
		AddToCartPage addtocart = new AddToCartPage(driver);
		addtocart.clickOnAddToCartButton();
		// ShoppingCartPage shoppingcart = new ShoppingCartPage(driver);
			//Assert.assertTrue(shoppingcart.displayPriceWebElement());
			//ShoppingCartPage.clickOnCheckoutButton();
		CheckoutPage checkout = new CheckoutPage(driver);
		checkout.checkoutLinkDisplayed();
		
		
	}
	
	
	
	
	
	
@AfterMethod
public void tearDown() {
		driver.quit();
	}
	
	
}
	