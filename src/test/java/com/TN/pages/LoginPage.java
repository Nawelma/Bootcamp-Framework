package com.TN.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	@FindBy(id = "input-email")
	private WebElement emailTextBox;

	@FindBy(id = "input-password")
	private WebElement paswordTextBox;

	@FindBy(css = "input.btn.btn-primary")
	private WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement loginWarningMessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterEmail(String emailWords) {
		emailTextBox.sendKeys(emailWords);
	}

	public void enterPassword(String passwordBody) {
		paswordTextBox.sendKeys(passwordBody);
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

	public String LoginMessageWarningText() {
		String text = loginWarningMessage.getText();
		return text;
	}
}