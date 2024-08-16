package com.TN.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TN.base.TestBase;
import com.TN.pages.AccountPage;
import com.TN.pages.HomePage;
import com.TN.pages.LoginPage;

public class LoginTest extends TestBase {

	public LoginTest() throws Exception {
		super();
	}

	@BeforeMethod
	public void Setup() {
		driver = Initialization(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.clickOnLogin();
	}

	@Test(priority = 1)
	public void LoginWithValidCredentials() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmail(prop.getProperty("validEmail"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
		AccountPage accountpage = new AccountPage(driver);
		Assert.assertTrue(accountpage.validateMyAccountLink());

	}

	@Test(priority = 2)
	public void LoginWithInvalidEmail() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmail(dataProp.getProperty("invalidEmail"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
	}

	@Test(priority = 3)
	public void LoginWithInvalidPassword() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmail(prop.getProperty("validEmail"));
		loginpage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginpage.clickOnLoginButton();
		String actualMessage = loginpage.LoginMessageWarningText();
		String expectedMessage = dataProp.getProperty("warningText");
		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test(priority = 4)
	public void LoginWithInvalidCredentials() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmail(dataProp.getProperty("invalidEmail"));
		loginpage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginpage.clickOnLoginButton();
		String actualMessage = loginpage.LoginMessageWarningText();
		String expectedMessage = dataProp.getProperty("warningText");
		Assert.assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test(priority = 5)
	public void LoginWithNoCredentials() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickOnLoginButton();
		String actualMessage = loginpage.LoginMessageWarningText();
		String expectedMessage = dataProp.getProperty("warningMessage");
		Assert.assertTrue(actualMessage.contains(expectedMessage));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
