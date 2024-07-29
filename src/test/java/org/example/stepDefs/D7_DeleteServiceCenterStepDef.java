package org.example.stepDefs;

import io.cucumber.java.en.Then;
import org.example.pages.P2_ServiceCenterList;
import org.example.pages.P7_DeleteServiceCenter;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D7_DeleteServiceCenterStepDef {
    P2_ServiceCenterList serviceCenterListPage = new P2_ServiceCenterList();
    P7_DeleteServiceCenter deleteServiceCenterPage = new P7_DeleteServiceCenter();
    String id;

    @Then("user clicks on the Delete action on the datatable")
    public void clickOnDeleteActionForFirstItemOnDatatable() throws InterruptedException {
        serviceCenterListPage.dataTablesortIdBtn().click(); //this sort for the datatable id to make sure that the inserted customer service object is the first row so I could assert that it is displayed on the datatable correctly
        Thread.sleep(1000);
        id = serviceCenterListPage.idCellOfFirstRow().getText();
        System.out.println("The Id of the item that it should be deleted is " + id);
        serviceCenterListPage.deleteActionOfFirstRowInServiceCenterDatatable().click();
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://madar-development-backoffice-wedvk6ltea-uc.a.run.app/en/ServiceCenters/delete"));
        soft.assertEquals(deleteServiceCenterPage.ServiceCenterDeleteScreenTitleLabel().getText(), "Delete Service Center");
        soft.assertAll();
    }

    @Then("User clicks on the delete button and successful delete dialog message is displayed")
    public void clickOnDeleteButton() {
        deleteServiceCenterPage.deleteBtn().click();
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://madar-development-backoffice-wedvk6ltea-uc.a.run.app/en/ServiceCenters"));
        soft.assertEquals(serviceCenterListPage.dialogMessage().getText(), "Deleted Successfully");
        serviceCenterListPage.dialogMessageOkBtn().click();
        soft.assertAll();
    }

    @Then("verify that service center item is not displayed on the datatable")
    public void VerifyServiceCenterIsNotDisplayedOnDatatableAfterDeleting() {
        List<WebElement> serviceCenterIds = serviceCenterListPage.serviceCenterIdsOndatatable();
        // Flag to check if the text is found
        boolean isTextFound = false;
        // Loop through each WebElement in the list
        for (WebElement serviceCenterId : serviceCenterIds) {
            // Get the text of the current WebElement
            String actualText = serviceCenterId.getText();

            // Compare the text with the expected text
            if (actualText.equals(id)) {
                isTextFound = true;
                break; // Exit the loop as we found the id
            }
        }

        // Assert that the text was not found
        Assert.assertFalse(isTextFound, "The deleted id '" + id + "' was found in the service center datatable");
    }
    }
