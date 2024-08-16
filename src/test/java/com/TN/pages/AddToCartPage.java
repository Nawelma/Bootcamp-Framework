package com.TN.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
public WebDriver driver;
	
	@FindBy(id = "button-cart")
	private WebElement addToCartButton;
	
	
	
	
	public AddToCartPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnAddToCartButton() {
		addToCartButton.click();	
	}
}
