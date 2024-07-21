package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.P1_HomePage;
import org.example.pages.P3_ServiceCenterList;
import org.example.pages.P4_CreateServiceCenter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class D3_CreateServiceCenterStepDef {
    private WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(100));
    P4_CreateServiceCenter createServiceCenterPage=new P4_CreateServiceCenter();
    P3_ServiceCenterList serviceCenterPage=new P3_ServiceCenterList();

    @Then("user is navigated to Create service center screen")
    public  void navigateToServiceCenterScreen(){
        Hooks.driver.navigate().to("https://madar-development-backoffice-wedvk6ltea-uc.a.run.app/en/ServiceCenters/Create");
    }
    @And("user fill the create service center fields and click on the Save button")
    public  void createServiceCenterSteps() throws InterruptedException {
       // try {
            createServiceCenterPage.ArabicNameTxtBox().sendKeys("اتوماتيد الاسم بالعربي");
            createServiceCenterPage.englishNameTxtBox().sendKeys("automated english name");
            createServiceCenterPage.ArabicAddressTxtBox().sendKeys("اتوماتيد العنوان بالعربي");
            createServiceCenterPage.EnglishAddressTxtBox().sendKeys("automated english address");
            createServiceCenterPage.codeTxtBox().sendKeys("453534");
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
    @Then("service center is displayed on the databale after creation")
    public  void verifyServiceCenterIsDisplayedOnDataTable()  {
            serviceCenterPage.dataTablesortIdBtn().click();

        }

    }


