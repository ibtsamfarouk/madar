package org.example.stepDefs;

import io.cucumber.java.en.Then;
import org.example.pages.P2_ServiceCenterList;
import org.example.pages.P4_EditServiceCenter;
import org.example.pages.P5_DetailsServiceCenter;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D5_DetailsServiceCenterStepDef {
    P5_DetailsServiceCenter detailsServiceCenterPage=new P5_DetailsServiceCenter();
    P2_ServiceCenterList serviceCenterListPage=new P2_ServiceCenterList();
    private WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(100));

    @Then("user clicks on the details action on the datatable")
    public void clickOnDetailsActionForFirstItemOnDatatable() throws InterruptedException {
        serviceCenterListPage.dataTablesortIdBtn().click(); //this sort for the datatable id to make sure that the inserted customer service object is the first row so I could assert that it is displayed on the datatable correctly
        Thread.sleep(1000);
        serviceCenterListPage.detailsActionOfFirstRowInServiceCenterDatatable().click();
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://madar-development-backoffice-wedvk6ltea-uc.a.run.app/en/ServiceCenters/details"));
        soft.assertEquals(detailsServiceCenterPage.TitleLabel().getText(),"Service Center Details");
        soft.assertAll();
    }
    @Then("service center data {string},{string},{string},{string},{string} are displayed correctly on the details screen")
    public void verifyCreatedServiceCenterOnDetailsScreen(String ServiceCenterArabicName,String ServiceCenterEnglishName,String ServiceCenterArabicAddress,String ServiceCenterEnglishAddress,String ServiceCenterCode) throws InterruptedException {
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(detailsServiceCenterPage.arabicNameDiv().getText(),ServiceCenterArabicName);
        soft.assertEquals(detailsServiceCenterPage.englishNameDiv().getText(),ServiceCenterEnglishName);
        soft.assertEquals(detailsServiceCenterPage.arabicAddressDiv().getText(),ServiceCenterArabicAddress);
        soft.assertEquals(detailsServiceCenterPage.englishAddressDiv().getText(),ServiceCenterEnglishAddress);
        soft.assertEquals(detailsServiceCenterPage.codeDiv().getText(),ServiceCenterCode);
        soft.assertAll();
    }

}
