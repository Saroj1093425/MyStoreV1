package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
	
	WebDriver ldriver;
	
	
	public indexPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
	
	// identify WebElement
	
	
	@FindBy(xpath="//i[@class='fa fa-home']")
	WebElement homeBtn;
	
	@FindBy(xpath="//a[text()=' Products']")
	WebElement productsBtn;
	
	@FindBy(xpath = "//a[text()=' Signup / Login']")
	WebElement signInandLoginBtn;
	
	@FindBy(xpath = "//a[text()=' Cart']")
	WebElement cartBtn;
	
	@FindBy(xpath="//a[text()=' Test Cases']")
	WebElement testCasesBtn;
	
	@FindBy(xpath = "//a[text()=' API Testing']")
	WebElement apiTestingBtn;
	
	@FindBy(xpath="//a[text()=' Video Tutorials']")
	WebElement videoTutorialBtn;
	
	@FindBy(xpath = "//a[text()=' Contact us']")
	WebElement contactUsBtn;
	
	// Identify the actions on webelement
	
	public void clickOnSignInandSignUpBtn()
	{
		signInandLoginBtn.click();
	}
	
	public void clickOnHome()
	{
		homeBtn.click();
	}
	
	public void clickOnProduct()
	{
		productsBtn.click();
	}
	
	public void clickOnCart()
	{
		cartBtn.click();
	}
	
	public void clickOnTestCases()
	{
		testCasesBtn.click();
	}
	
	public void clickOnApiTesting()
	{
		apiTestingBtn.click();
	}
	
	public void clickOnVideoTutorial()
	{
		videoTutorialBtn.click();
	}
	
	public void clickOnContactUsBtn()
	{
		contactUsBtn.click();
	}
	
	
	

}



























