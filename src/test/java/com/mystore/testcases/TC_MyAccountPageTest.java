package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

import com.mystore.pageobjects.accountCreationDetailsPage;
import com.mystore.pageobjects.indexPage;
import com.mystore.pageobjects.myAccountPage;
import com.mystore.pageobjects.registeredUserAccountPage;

public class TC_MyAccountPageTest extends BaseClass {

	@Test(enabled = false)
	public void verifyRegisterataion() throws InterruptedException {

		logger.info("***************TestCase Verify Registration and Login starts*****************");

		indexPage pg = new indexPage(driver);
		pg.clickOnSignInandSignUpBtn();
		logger.info("Clicked on Sign In Link");

		myAccountPage myAcpg = new myAccountPage(driver);
		myAcpg.enterUserName("demoo8");
		Thread.sleep(10);
		myAcpg.enterNewUserEmailAddress("al08@gmail.com");
		logger.info("Email address entered in create account section.");

		myAcpg.clickSignUp();
		logger.info("Clicked on Sign Up Button");

		accountCreationDetailsPage accCrePg = new accountCreationDetailsPage(driver);
		accCrePg.selectTitleMr();
		// accCrePg.enterName("Meth1");
		// accCrePg.enterEmail("Meth01@gmail.com");
		accCrePg.enterPassword("pwd01");
		accCrePg.selectDay("10");
		accCrePg.selectMonth("April");
		accCrePg.selectYear("2000");
		accCrePg.clickOnNewletters();
		accCrePg.clickOnoptin();
		accCrePg.enterFirstName("Meth1");
		accCrePg.enterLastName("Bed");
		accCrePg.enterCompanyName("To The New");
		accCrePg.enterAddress1("101 streeet");
		accCrePg.enterAddress2("Walking");
		accCrePg.enterCountry("Israel");
		accCrePg.selectState("UP");
		accCrePg.selectCity("Merrut");
		accCrePg.enterZipCode("201301");
		accCrePg.enterMobileNumber("9012395604");

		logger.info("User entered all the requied details.");

		accCrePg.clickOnCreateAccount();

		logger.info("Clicked on Create Button.");

		registeredUserAccountPage regAcc = new registeredUserAccountPage(driver);
		String accountCreatedText = regAcc.getAccountCreatedText();
		Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!");
		logger.info("Account has been created");
	}

	@Test(enabled = false)
	public void VerifyLogin() throws IOException {
		logger.info("***************TestCase Verify Login starts*****************");

		indexPage pg = new indexPage(driver);
		pg.clickOnSignInandSignUpBtn();
		logger.info("Clicked on Sign In Link");

		myAccountPage myAcpg = new myAccountPage(driver);
		myAcpg.enterOldUserEmail("al05@gmail.com");
		myAcpg.enterPassword("pwd01");
		myAcpg.clickSignIn();

		logger.info("User entered Details and Clicked on Login CTA");

		registeredUserAccountPage regUserAcc = new registeredUserAccountPage(driver);
		String userName = regUserAcc.getAccountUserName();
		if (userName.equals("demoo5")) {
			logger.info("Verify login Passed");
			Assert.assertTrue(true);
		} else {
			logger.info("Verify Login Failed");
			captureScreenShot(driver, "verifyLogin");
			Assert.assertFalse(true);
		}
	}

	@Test(enabled = false)
	public void verifyLoginWithInvalidCredentials() {
		logger.info("*************** TestCase: Verify Invalid Login starts ***************");

		// Navigate to Sign In Page and perform invalid login
		indexPage indexPg = new indexPage(driver);
		indexPg.clickOnSignInandSignUpBtn();
		logger.info("Clicked on Sign In Link");

		myAccountPage myAccPg = new myAccountPage(driver);
		myAccPg.enterOldUserEmail("invalidUser@gmail.com");
		myAccPg.enterPassword("Invalid");
		myAccPg.clickSignIn();
		logger.info("Clicked on Sign In Button");

		// Validate error message
		String actualError = myAccPg.getInvalidCredsUsedError();
		Assert.assertEquals(actualError, "Your email or password is incorrect!", "Error message mismatch!");

		logger.info("*************** TestCase: Verify Invalid Login ends ***************");
	}

	@Test(enabled = false)
	public void logoutUser() {
		logger.info("*************** TestCase: Verify Invalid Login starts ***************");
		indexPage indexPage = new indexPage(driver);
		indexPage.clickOnSignInandSignUpBtn();
		logger.info("Clicked on Sign In Link");

		myAccountPage myAccPg = new myAccountPage(driver);
		myAccPg.enterOldUserEmail("al05@gmail.com");
		myAccPg.enterPassword("pwd01");
		myAccPg.clickSignIn();
		logger.info("Clicked on Sign In Button");

		registeredUserAccountPage regUserAcc = new registeredUserAccountPage(driver);
		regUserAcc.clickOnSignOut();
		logger.info("User clicked on Sign Out Button");
		String current_URL = driver.getCurrentUrl();
		Assert.assertEquals(current_URL, "https://automationexercise.com/login");
		logger.info("User has been logged out successfully");
		logger.info("*************** TestCase: Verify Invalid Login ends ***************");
	}

	@Test(enabled = true)
	public void verifyRegisterationUsingRegisteredUser() throws InterruptedException {
		logger.info("*************** TestCase: Verify Invalid Login starts ***************");

		// Navigate to Sign In Page
		indexPage indexPg = new indexPage(driver);
		indexPg.clickOnSignInandSignUpBtn();
		logger.info("Clicked on Sign In Link");

		// Attempt registration with an already registered email
		myAccountPage myAccPg = new myAccountPage(driver);
		myAccPg.enterUserName("Maven");
		myAccPg.enterNewUserEmailAddress("al05@gmail.com");
		myAccPg.clickSignUp();
		logger.info("Clicked on Sign Up Button");

		// Validate error message for existing email
		String actualError = myAccPg.getExistingEmailError();
		String expectedError = "Email Address already exist!";
		Assert.assertEquals(actualError, expectedError, "Error message mismatch!");
		logger.info("Existing email error message has been verified successfully");

		logger.info("*************** TestCase: verifyRegisterationUsingRegisteredUser ends ***************");
	}
}