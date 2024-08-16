package com.TN.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
public WebDriver driver;
	
	@FindBy(id = "cart-total")
	private WebElement displayPrice;
	
	@FindBy(linkText = "Checkout")
	private WebElement checkoutButton;
	
	
	
	public void ShoppingCartPager() {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	public boolean displayPriceWebElement() {
		boolean display =  displayPrice.isDisplayed();
		return display;
	}
	
	
	public void clickOnCheckoutButton() {
		checkoutButton.click();
	}
}

