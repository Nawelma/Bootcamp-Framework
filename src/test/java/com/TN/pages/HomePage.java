package com.TN.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	@FindBy(linkText = "My Account")
	private WebElement myAccountDropdown;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(linkText = "Register")
	private WebElement registerOption;

	@FindBy(name = "search")
	private WebElement searchBox;

	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMyAccount() {
		myAccountDropdown.click();
	}

	public void clickOnLogin() {
		loginOption.click();
	}

	public void clickOnRegister() {
		registerOption.click();
	}

	public void entervalidProduct(String productName) {
		searchBox.sendKeys(productName);
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

}
