package com.TN.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	public WebDriver driver;

	@FindBy(xpath = "//p[text() = 'I am a returning customer']")
	private WebElement checkoutLink;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean checkoutLinkDisplayed() {
		boolean display = checkoutLink.isDisplayed();
		return display;
	}

}
