package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

import com.mystore.pageobjects.accountCreationDetailsPage;
import com.mystore.pageobjects.contactUsPage;
import com.mystore.pageobjects.indexPage;
import com.mystore.pageobjects.myAccountPage;
import com.mystore.pageobjects.productsPage;
import com.mystore.pageobjects.registeredUserAccountPage;
import com.mystore.utilities.WebDriverUtils;

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

	@Test(enabled = false)
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

	@Test(enabled = false)
	public void verifyContactUsFormverifyContactUsForm() {
		logger.info("*************** TestCase: Verify Contact Us Form starts ***************");

		indexPage indexPg = new indexPage(driver);
		indexPg.clickOnContactUsBtn();
		logger.info("Clicked on Contact Us Button");

		String currentUrl = driver.getCurrentUrl();
		logger.info("Current URL is: " + currentUrl);
		Assert.assertEquals(currentUrl, "https://automationexercise.com/contact_us", "Contact Us page URL mismatch!");

		contactUsPage contpg = new contactUsPage(driver);
		Assert.assertTrue(contpg.getInTouchText().isDisplayed(), "'GET IN TOUCH' is not visible on the page!");

		// Use sample data for form fields
		contpg.enterName("Test User");
		contpg.enterEmail("testuser@example.com");
		contpg.enterSubject("Test Subject");
		contpg.enterMessage("This is a test message.");

		// Use the constant from contactUsPage for file upload
		contpg.uploadFile(contactUsPage.DEFAULT_UPLOAD_FILE_PATH);
		contpg.clickSubmitButton();

		WebDriverUtils.acceptAlert(driver);
		logger.info("Alert has been accepted successfully");

		String successmsg = contpg.getSuccessMessageString();
		Assert.assertEquals(successmsg, "Success! Your details have been submitted successfully.", "Success message mismatch!");
		logger.info("Success message has been verified successfully");	

		contpg.clickOnHomeButton();
		logger.info("Clicked on Home Button");		
		String homePageUrl = driver.getCurrentUrl();

		Assert.assertEquals(homePageUrl, "https://automationexercise.com/", "Home page URL mismatch!");
		logger.info("Contact Us page URL has been verified successfully");
		logger.info("*************** TestCase: verifyContactUsForm ends ***************");
	}

	@Test(enabled = false)
	public void verifytestcasePage(){
		logger.info("*************** TestCase: Verify Test Case Page starts ***************");

		indexPage indexPg = new indexPage(driver);
		indexPg.clickOnTestCases();
		logger.info("Clicked on Test Cases Button");

		String currentUrl = driver.getCurrentUrl();
		logger.info("Current URL is: " + currentUrl);
		Assert.assertEquals(currentUrl, "https://automationexercise.com/test_cases", "Test Cases page URL mismatch!");

		logger.info("*************** TestCase: Verify Test Case Page ends ***************");
	}

	@Test(enabled = true)
	public void verifyProductsAndProductDetailPage(){		
		indexPage indexPg = new indexPage(driver);
		indexPg.clickOnProduct();
		logger.info("Clicked on Products Button");
		String currentUrl = driver.getCurrentUrl();
		logger.info("Current URL is: " + currentUrl);	
		Assert.assertEquals(currentUrl, "https://automationexercise.com/products", "Products page URL mismatch!");


		productsPage prodPg = new productsPage(driver);
		String prodPageText = prodPg.getAllProductsText();
		Assert.assertEquals(prodPageText, "ALL PRODUCTS", "Products page text mismatch!");
		logger.info("Products page text has been verified successfully");	
	
			



	}







}	