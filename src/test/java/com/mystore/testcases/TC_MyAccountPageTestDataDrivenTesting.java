package com.mystore.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobjects.accountCreationDetailsPage;
import com.mystore.pageobjects.indexPage;
import com.mystore.pageobjects.myAccountPage;
import com.mystore.pageobjects.registeredUserAccountPage;
import com.mystore.utilities.ReadExcelFile;

public class TC_MyAccountPageTestDataDrivenTesting extends BaseClass{
    
    @Test(priority=1)
    public void verifyRegisterataion()
    {
        
        logger.info("***************TestCase Verify Registration and Login starts*****************"); 
        
        indexPage pg = new indexPage(driver);
        pg.clickOnSignInandSignUpBtn();
        logger.info("Clicked on Sign In Link");
        
        myAccountPage myAcpg = new myAccountPage(driver);
        myAcpg.enterUserName("demoo9");
        myAcpg.enterEmailAddress("al09@gmail.com");
        logger.info("Email address entered in create account section.");
        
        myAcpg.clickSignUp();
        logger.info("Clicked on Sign Up Button");
        
        accountCreationDetailsPage accCrePg = new accountCreationDetailsPage(driver);
        accCrePg.selectTitleMr();
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
    
@Test(dataProvider = "LoginDataProvider")
    
    public void VerifyLogin(String userEmail, String userPwd, String expectedUsername) throws IOException 
    {

        logger.info("***************TestCase VerifyLogin starts*****************"); 


        indexPage pg = new indexPage(driver);

        pg.clickOnSignInandSignUpBtn();
        logger.info("Clicked on sign in link");

        myAccountPage myAcpg = new myAccountPage(driver);

        myAcpg.enterExistingEmail(userEmail);
        logger.info("Entered email address");
        
        myAcpg.enterPassword(userPwd);
        logger.info("Entered password");

        myAcpg.clickSignIn();
        logger.info("Clicked on sign in link..");

        registeredUserAccountPage regUser = new registeredUserAccountPage(driver);
        String userName = regUser.getAccountUserName();
        
        
        if(userName.equals(expectedUsername))
        {
            logger.info("VerifyLogin - Passed");
            Assert.assertTrue(true);
            
            regUser.clickOnSignOut();
            
        }
        else
        {
            logger.info("VerifyLogin - Failed");
            captureScreenShot(driver,"VerifyLogin");
            Assert.assertTrue(false);

        } 
        
         
        logger.info("***************TestCase Verify login ends*****************"); 


    }

    /**
     * Robust DataProvider: opens workbook only once, uses bounded for-loop and returns Object[][]
     */
    @DataProvider(name = "LoginDataProvider")
    public Object[][] LoginDataProvider() throws IOException
    {
        String fileName = System.getProperty("user.dir") + File.separator + "TestData" + File.separator + "MyStoreTestData.xlsx";
        String sheetName = "LoginTestData";

        List<Object[]> rows = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(fileName);
             Workbook wb = new XSSFWorkbook(fis)) {

            Sheet sheet = wb.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet not found: " + sheetName);
            }

            DataFormatter df = new DataFormatter();

            int firstRow = sheet.getFirstRowNum() + 1; // assume header at first row
            int lastRow = sheet.getLastRowNum();

            for (int r = firstRow; r <= lastRow; r++) {
                Row row = sheet.getRow(r);
                if (row == null) continue;

                String email = getCellValue(row, 0, df);
                String password = getCellValue(row, 1, df);
                String expectedUser = getCellValue(row, 2, df);

                // skip completely empty rows
                if (email.isEmpty() && password.isEmpty() && expectedUser.isEmpty()) continue;

                rows.add(new Object[] { email, password, expectedUser });
            }
        }

        // Convert to Object[][] as required by TestNG
        return rows.toArray(new Object[0][]);
    }

    private static String getCellValue(Row row, int col, DataFormatter df) {
        Cell cell = row.getCell(col, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
        return cell == null ? "" : df.formatCellValue(cell).trim();
    }

}
