package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class productsPage {

    WebDriver ldriver;
    public productsPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this); 
    }

    @FindBy(xpath="//h2[@class='title text-center']")
    WebElement allProductsText;





    public String getAllProductsText()
    {
        return allProductsText.getText();
    }   




}
