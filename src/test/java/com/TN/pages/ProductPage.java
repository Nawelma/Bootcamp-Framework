package com.TN.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
public WebDriver driver;
	
	@FindBy(linkText = "Dell P-19H")
	private WebElement productExists;
	
	
	@FindBy(xpath = "//p[text() = 'There is no product that matches the search criteria.']")
	private WebElement invalidMessage;
	
	@FindBy(xpath = "//span[text() ='Add to Cart']")
	private WebElement addToCardButton;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyProductExistance() {
		boolean display = productExists.isDisplayed();
		return display;
	}
	
	public String verifyWarningMessage() {
		String display = invalidMessage.getText();
		return display;
	}

	public void clickOnAddToCard() {
		addToCardButton.click();
	}
	
}

