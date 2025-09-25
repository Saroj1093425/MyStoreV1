package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobjects.accountCreationDetailsPage;
import com.mystore.pageobjects.indexPage;
import com.mystore.pageobjects.myAccountPage;
import com.mystore.pageobjects.registeredUserAccountPage;


public class TC_MyAccountPageTest extends BaseClass{
	
	
	@Test(priority = 1)
	public void verifyRegisterataion() throws InterruptedException
	{
		
		logger.info("***************TestCase Verify Registration and Login starts*****************"); 
		
		indexPage pg = new indexPage(driver);
		pg.clickOnSignInandSignUpBtn();
		logger.info("Clicked on Sign In Link");
		
		
		
		myAccountPage myAcpg = new myAccountPage(driver);
		myAcpg.enterUserName("demoo8");
		Thread.sleep(10);
		myAcpg.enterEmailAddress("al08@gmail.com");
		logger.info("Email address entered in create account section.");
		
		myAcpg.clickSignUp();
		logger.info("Clicked on Sign Up Button");
		
		accountCreationDetailsPage accCrePg = new accountCreationDetailsPage(driver);
		accCrePg.selectTitleMr();
		//accCrePg.enterName("Meth1");
		//accCrePg.enterEmail("Meth01@gmail.com");
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
	
	
	@Test(priority = 2)
	public void VerifyLogin() throws IOException
	{
		logger.info("***************TestCase Verify Login starts*****************"); 
		
		indexPage pg = new indexPage(driver);
		pg.clickOnSignInandSignUpBtn();
		logger.info("Clicked on Sign In Link");
		
		myAccountPage myAcpg = new myAccountPage(driver);
		myAcpg.enterExistingEmail("al05@gmail.com");
		myAcpg.enterPassword("pwd01");
		myAcpg.clickSignIn();
		
		logger.info("User entered Details and Clicked on Login CTA");
		
		registeredUserAccountPage regUserAcc = new registeredUserAccountPage(driver);
		String userName = regUserAcc.getAccountUserName();
		if(userName.equals("demoo5"))
		{
			logger.info("Verify login Passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Verify Login Failed");
			captureScreenShot(driver,"verifyLogin");
			Assert.assertFalse(true);
		}
	}
	
	@Test()
	public void VerifyLoginWithInValidLogin()
	{
		
	}
	
}
