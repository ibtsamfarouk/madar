package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.P2_ServiceCenterList;
import org.example.pages.P3_CreateServiceCenter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class D3_CreateServiceCenterStepDef {
    private WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(100));
    P3_CreateServiceCenter createServiceCenterPage=new P3_CreateServiceCenter();
    P2_ServiceCenterList serviceCenterPage=new P2_ServiceCenterList();

    @Then("user is navigated to Create service center screen")
    public  void navigateToServiceCenterScreen(){
        Hooks.driver.navigate().to("https://madar-development-backoffice-wedvk6ltea-uc.a.run.app/en/ServiceCenters/Create");
    }
    @And("user fill the create service center fields {string}, {string} ,{string} ,{string}, {string} and clicks on the Save button")
    public  void createServiceCenterSteps(String ServiceCenterArabicName,String ServiceCenterEnglishName, String ServiceCenterArabicAddress,String ServiceCenterEnglishAddress,String ServiceCenterCode) throws InterruptedException {
       // try {
            createServiceCenterPage.ArabicNameTxtBox().sendKeys(ServiceCenterArabicName);
            createServiceCenterPage.englishNameTxtBox().sendKeys(ServiceCenterEnglishName);
            createServiceCenterPage.ArabicAddressTxtBox().sendKeys(ServiceCenterArabicAddress);
            createServiceCenterPage.EnglishAddressTxtBox().sendKeys(ServiceCenterEnglishAddress);
            createServiceCenterPage.codeTxtBox().sendKeys(ServiceCenterCode);
            createServiceCenterPage.map().click();
           // Thread.sleep(10000);
        WebElement saveButton=wait.until(ExpectedConditions.elementToBeClickable(createServiceCenterPage.saveBtn()));
      //  ((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);
        try {
            saveButton.click();
        } catch (Exception e) {
            System.out.println("Regular click failed, attempting JavaScript click.");
            ((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].click();", saveButton);
        }

        System.out.println("Save button clicked successfully!");

    }
    @Then("service center created successfully")
    public  void verifyServiceCenterScreenCreatedSuccessfully() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().equals("https://madar-development-backoffice-wedvk6ltea-uc.a.run.app/en/ServiceCenters"));
       Thread.sleep(1000);
        soft.assertEquals(serviceCenterPage.dialogMessage().getText(),"Created Successfully");
        soft.assertAll();
        serviceCenterPage.dialogMessageOkBtn().click();

    }
    @Then("service center is displayed on the databale after creation with the entered {string},{string},{string}")
    public  void verifyServiceCenterIsDisplayedOnDataTable(String ServiceCenterArabicName,String ServiceCenterEnglishName, String ServiceCenterCode) throws InterruptedException {
        serviceCenterPage.dataTablesortIdBtn().click(); //this sort for the datatable id to make sure that the inserted customer service object is the first row so I could assert that it is displayed on the datatable correctly
        Thread.sleep(1000);
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(serviceCenterPage.arabicNameCell().getText(),ServiceCenterArabicName);
        soft.assertEquals(serviceCenterPage.englishNameCell().getText(),ServiceCenterEnglishName);
        soft.assertEquals(serviceCenterPage.codeCell().getText(),ServiceCenterCode);
        soft.assertAll();
    }

    }


