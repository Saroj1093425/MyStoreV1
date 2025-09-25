package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactUsPage {

    public static final String DEFAULT_UPLOAD_FILE_PATH = "C:\\\\Users\\\\Saroj Kumar Gope\\\\Final\\\\MyStoreV1\\\\TestData\\\\1000000930.webp";

    WebDriver ldriver;
	
	
	public contactUsPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}


    @FindBy(xpath = "//h2[@class='title text-center' and contains(text(),'Get In Touch')]")
    WebElement getInTouchText;

    @FindBy(name="name")
    WebElement nameField;

    @FindBy(name="email")
    WebElement emailField;

    @FindBy(name="subject")
    WebElement subjectField;  
    
    @FindBy(name="message")
    WebElement messageField;

    @FindBy(xpath = "//input[@name='upload_file']")
    WebElement uploadFileField;

    @FindBy(xpath = "//input[@name='submit']")
    WebElement submitButton;   
    





    public WebElement getInTouchText()
    {
        return getInTouchText;
    }

    public void enterName(String name)
    {
        nameField.sendKeys(name);
    }       

    public void enterEmail(String email)
    {
        emailField.sendKeys(email);
    }       

    public void enterSubject(String subject)
    {
        subjectField.sendKeys(subject);
    }                               

    public void enterMessage(String message)
    {
        messageField.sendKeys(message);
    }

    public void uploadFile(String filePath)
    {
        uploadFileField.sendKeys(filePath);
    }

    public void clickSubmitButton()
    {
        submitButton.click();
    }   







}
