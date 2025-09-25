package com.mystore.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registeredUserAccountPage {
	
	
	private WebDriver ldriver;
	public registeredUserAccountPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//h2//b[text()='Account Created!']")
	WebElement acountCreatedText;
	
	@FindBy(xpath="//div[@class='row']//li[10]//b")
	WebElement accountUserName;
	
	@FindBy(xpath="//a[text()=' Logout']")
	WebElement signOutBtn;
	
	
	
	public String getAccountCreatedText()
	{
		String text = acountCreatedText.getText();
		return text;
	}
	
	public String getAccountUserName()
	{
		String name = accountUserName.getText();
		return name;
	}
	
	public void clickOnSignOut()
	{
		signOutBtn.click();
	}

}
