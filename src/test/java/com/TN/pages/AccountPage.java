package com.TN.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
public WebDriver driver;
	
	@FindBy(linkText = "My Account")
	private WebElement MyAccountLink;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateMyAccountLink() {
		boolean displayStatus = MyAccountLink.isDisplayed();
		return displayStatus;
	}
}
