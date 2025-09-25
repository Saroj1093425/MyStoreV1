package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccountPage {
	
	WebDriver ldriver;
	
	
	public myAccountPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
	// identify WebElement
	
	@FindBy(xpath = "(//form[@action='/login']//input)[2]")
	WebElement enterExistingEmailAddress;
	
	@FindBy(xpath = "(//form[@action='/login']//input)[3]")
	WebElement enterPassword;
	
	@FindBy(xpath = "(//input[@placeholder='Name'])[1]")
	WebElement enterNewUserName;
	
	@FindBy(xpath = "(//form[@action='/signup']//input)[2]")
	WebElement enterNewEmailAddress;
	
	@FindBy(xpath="(//button[normalize-space()='Signup'])[1]")
	WebElement clickOnSignUpButton;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement clickOnSignInButton;

	@FindBy(xpath="//p[text()='Your email or password is incorrect!']")
	WebElement InvalidCreds;
	
	
	
	
	public void enterUserName(String userName)
	{
		enterNewUserName.sendKeys(userName);
	}
	
	public void enterEmailAddress(String emailAddress)
	{
		enterNewEmailAddress.sendKeys(emailAddress);
	}
	
	public void clickSignUp()
	{
		clickOnSignUpButton.click();
	}
	
	public void enterExistingEmail(String email)
	{
		enterExistingEmailAddress.sendKeys(email);
	}
	
	public void enterPassword(String pwd)
	{
		enterPassword.sendKeys(pwd);
	}
	public void clickSignIn()
	{
		clickOnSignInButton.click();
	}

	public String getInvalidCredsUsedError()
	{
		String inValidText = InvalidCreds.getText();
		return inValidText;
	}
	
	
	
	
	
	

}