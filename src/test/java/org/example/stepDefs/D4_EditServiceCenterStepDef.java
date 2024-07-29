package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P2_ServiceCenterList;
import org.example.pages.P4_EditServiceCenter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class D4_EditServiceCenterStepDef {

    P2_ServiceCenterList serviceCenterPage=new P2_ServiceCenterList();
    P4_EditServiceCenter serviceCenterEditPage=new P4_EditServiceCenter();
    private WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(100));


    @When("user is navigated to service center List screen")
    public void navigateToServiceCenterListscreen(){
        Hooks.driver.navigate().to("https://madar-development-backoffice-wedvk6ltea-uc.a.run.app/en/ServiceCenters");
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://madar-development-backoffice-wedvk6ltea-uc.a.run.app/en/ServiceCenters"));
        soft.assertEquals(serviceCenterPage.ServiceCenterListScreenTitleLabel().getText(),"Service Centers");
        soft.assertAll();
    }


    @And("user clicks on the edit action of the first item on the data table to edit it")
    public void clickOnEditActionForFirstItemInDatatable(){
        // Find all rows in the datatable
        // Check if there are any rows
        if (serviceCenterPage.allRowsInServiceCenterDatatable().isEmpty()) {
            // Handle the case where there are no rows in the datatable
            System.out.println("No items in the datatable to edit.");
            // You can throw an exception, log a message, or handle it as per your test requirement
            throw new IllegalStateException("No items in the datatable to edit.");
        } else{
        serviceCenterPage.editActionOfFirstRowInServiceCenterDatatable().click();
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://madar-development-backoffice-wedvk6ltea-uc.a.run.app/en/ServiceCenters/edit"));
        soft.assertEquals(serviceCenterEditPage.ServiceCenterEditScreenTitleLabel().getText(),"Edit Service Center");
        soft.assertAll();
    }}
    @And("user changes the service center fields with {string}, {string} ,{string} ,{string}, {string} and clicks on the Save button")
    public void editServiceCenterFields(String ServiceCenterArabicName,String ServiceCenterEnglishName, String ServiceCenterArabicAddress,String ServiceCenterEnglishAddress,String ServiceCenterCode){
        serviceCenterEditPage.ArabicNameTxtBox().clear();
        serviceCenterEditPage.ArabicNameTxtBox().sendKeys(ServiceCenterArabicName);
        serviceCenterEditPage.englishNameTxtBox().clear();
        serviceCenterEditPage.englishNameTxtBox().sendKeys(ServiceCenterEnglishName);
        serviceCenterEditPage.ArabicAddressTxtBox().clear();
        serviceCenterEditPage.ArabicAddressTxtBox().sendKeys(ServiceCenterArabicAddress);
        serviceCenterEditPage.EnglishAddressTxtBox().clear();
        serviceCenterEditPage.EnglishAddressTxtBox().sendKeys(ServiceCenterEnglishAddress);
        serviceCenterEditPage.codeTxtBox().clear();
        serviceCenterEditPage.codeTxtBox().sendKeys(ServiceCenterCode);
        serviceCenterEditPage.map().click();
        WebElement saveButton=wait.until(ExpectedConditions.elementToBeClickable(serviceCenterEditPage.saveBtn()));
        try {
            saveButton.click();
        } catch (Exception e) {
            System.out.println("Regular click failed, attempting JavaScript click.");
            ((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].click();", saveButton);
        }

        System.out.println("Save button clicked successfully!");
    }
    @Then("service center edited successfully")
    public  void verifyServiceCenterScreenCreatedSuccessfully() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().equals("https://madar-development-backoffice-wedvk6ltea-uc.a.run.app/en/ServiceCenters"));
        Thread.sleep(1000);
        soft.assertEquals(serviceCenterPage.dialogMessage().getText(),"Updated Successfully");
        soft.assertAll();
        serviceCenterPage.dialogMessageOkBtn().click();

    }
    @Then("service center is displayed on the datatabale after editing with the entered {string},{string},{string}")
    public  void verifyServiceCenterIsDisplayedOnDataTable(String ServiceCenterArabicName,String ServiceCenterEnglishName, String ServiceCenterCode) throws InterruptedException {
      //  serviceCenterPage.dataTablesortIdBtn().click(); //this sort for the datatable id to make sure that the inserted customer service object is the first row so I could assert that it is displayed on the datatable correctly
        Thread.sleep(2000);
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(serviceCenterPage.arabicNameCell().getText(),ServiceCenterArabicName);
        soft.assertEquals(serviceCenterPage.englishNameCell().getText(),ServiceCenterEnglishName);
        soft.assertEquals(serviceCenterPage.codeCell().getText(),ServiceCenterCode);
        soft.assertAll();
    }

}
