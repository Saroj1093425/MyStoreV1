package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class accountCreationDetailsPage {

	WebDriver ldriver;
	
	public accountCreationDetailsPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(id="id_gender1") WebElement maleGender;
	
	@FindBy(id="id_gender2") WebElement femaleGender;
	
	@FindBy(id="name") WebElement enterName;
	
	@FindBy(id="email") WebElement enterEmail;
	
	@FindBy(id="password") WebElement enterPassword;
	
	@FindBy(id="days") WebElement enterDays;
	
	@FindBy(id="months") WebElement enterMonths;
	
	@FindBy(id="years") WebElement enterYears;
	
	@FindBy(id="newsletter") WebElement newletters;
	
	@FindBy(id="optin") WebElement optin;

	@FindBy(id="first_name") WebElement enterFirstName;
	
	@FindBy(id="last_name") WebElement enterLastName;
	
	@FindBy(id="company") WebElement enterCompany;

	@FindBy(id="address1") WebElement enterAddress1;
	
	@FindBy(id="address2") WebElement enterAddress2;
	
	@FindBy(id="country") WebElement enterCountry;

	@FindBy(id="state") WebElement enterState;
	
	@FindBy(id="city") WebElement enterCity;

	@FindBy(id="zipcode") WebElement enterZipCode;
	
	@FindBy(id="mobile_number") WebElement enterMobileNumber;
	
	@FindBy(xpath="//button[text()='Create Account']") WebElement clickOnCreateAccount;
	
	public void selectTitleMr()
	{
		maleGender.click();
	}
	
	public void selectTitleMrs()
	{
		femaleGender.click();
	}
	
	public void enterName(String name)
	{
		//enterName.clear();
		enterName.sendKeys(name);
	}
	
	public void enterEmail(String email)
	{
		//enterEmail.clear();
		enterEmail.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		enterPassword.sendKeys(password);
	}
	
	public void selectDay(String days)
	{
		Select select = new Select(enterDays);
		select.selectByVisibleText(days);
	}
	
	public void selectMonth(String months)
	{
		Select select = new Select(enterMonths);
		select.selectByVisibleText(months);
	}
	
	public void selectYear(String years)
	{
		Select select = new Select(enterYears);
		select.selectByVisibleText(years);
	}
	
	public void clickOnNewletters()
	{
		newletters.click();
	}
	
	public void clickOnoptin()
	{
		optin.click();
	}
	
	public void enterFirstName(String firstname)
	{
		enterFirstName.sendKeys(firstname);
	}
	
	public void enterLastName(String lastName)
	{
		enterLastName.sendKeys(lastName);
	}

	public void enterCompanyName(String company)
	{
		enterCompany.sendKeys(company);
	}
	
	public void enterAddress1(String address1)
	{
		enterAddress1.sendKeys(address1);
	}
	
	public void enterAddress2(String address2)
	{
		enterAddress2.sendKeys(address2);
	}
	
	public void enterCountry(String country)
	{
		Select select = new Select(enterCountry);
		select.selectByVisibleText(country);
	}
	
	public void selectState(String state)
	{
		enterState.sendKeys(state);
	}
	
	public void selectCity(String city)
	{
		enterCity.sendKeys(city);
	}
	
	public void enterZipCode(String zipcode)
	{
		enterZipCode.sendKeys(zipcode);
	}
	
	public void enterMobileNumber(String number)
	{
		enterMobileNumber.sendKeys(number);
	}
	
	public void clickOnCreateAccount()
	{
		clickOnCreateAccount.click();
	}
	
}
