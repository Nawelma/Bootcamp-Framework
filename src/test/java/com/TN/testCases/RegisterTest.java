package com.TN.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TN.base.TestBase;
import com.TN.pages.HomePage;
import com.TN.pages.NewAccountPage;
import com.TN.pages.RegisterPage;
import com.TN.utils.TestUtil;

@Test
public class RegisterTest extends TestBase {

	public RegisterTest() throws Throwable {
		super();

	}

	public WebDriver driver;
	public RegisterPage registerpage;
	public HomePage homepage;
	public NewAccountPage newaccount;

	@BeforeMethod

	public void setup() {
		driver = Initialization(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.clickOnRegister();

	}

	@Test(priority = 1)
	public void RegisterWithValidDetails() {

		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(dataProp.getProperty("firstName"));
		registerpage.enterLastName(dataProp.getProperty("lastName"));
		registerpage.enterEmail(TestUtil.emailWithDateTimeStampAction());
		registerpage.enterTelephone(dataProp.getProperty("telephone"));
		registerpage.enterPassword(dataProp.getProperty("password"));
		registerpage.enterConfirmPassword(dataProp.getProperty("confirmPassword"));
		registerpage.checkPrivacyPolicyCheckBox();
		registerpage.clickOnContinueButton();

		NewAccountPage newaccount = new NewAccountPage(driver);
		AssertJUnit.assertTrue(((com.TN.pages.NewAccountPage) newaccount).LinkDisplayed());

	}

	@Test(priority = 2)
	public void registerWithAllDetails() {

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmail(TestUtil.emailWithDateTimeStampAction());
		registerPage.enterTelephone(dataProp.getProperty("telephone"));
		registerPage.enterPassword(dataProp.getProperty("password"));
		registerPage.enterConfirmPassword(dataProp.getProperty("confirmPassword"));
		registerPage.clickOnNewsLetterRadioButton();
		registerPage.checkPrivacyPolicyCheckBox();
		registerPage.clickOnContinueButton();

		NewAccountPage newAccountPage = new NewAccountPage(driver);
		AssertJUnit.assertTrue(newAccountPage.LinkDisplayed());
	}

	@Test(priority = 3)
	public void registerWithExistingEmail() {

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmail(prop.getProperty("validEmail"));
		registerPage.enterTelephone(dataProp.getProperty("telephone"));
		registerPage.enterPassword(dataProp.getProperty("password"));
		registerPage.enterConfirmPassword(dataProp.getProperty("confirmPassword"));
		registerPage.clickOnNewsLetterRadioButton();
		registerPage.checkPrivacyPolicyCheckBox();
		registerPage.clickOnContinueButton();

		String actualMessage = registerPage.retrieveDuplicateEmailWarningMessage();
		String expectedMessage = dataProp.getProperty("warningMessageFoeExsistingEmail");
		AssertJUnit.assertTrue(actualMessage.contains(expectedMessage));

	}

	@Test(priority = 4)
	public void registerWithWrongPassword() {

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmail(TestUtil.emailWithDateTimeStampAction());
		registerPage.enterTelephone(dataProp.getProperty("telephone"));
		registerPage.enterPassword(dataProp.getProperty("password"));
		registerPage.enterConfirmPassword(dataProp.getProperty("wrongPassword"));
		registerPage.clickOnNewsLetterRadioButton();
		registerPage.checkPrivacyPolicyCheckBox();
		registerPage.clickOnContinueButton();
		AssertJUnit.assertTrue(registerPage.retrieveWrongConfirmPasswordWarningMessage()
				.contains(dataProp.getProperty("warning text ")));

	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}
}
