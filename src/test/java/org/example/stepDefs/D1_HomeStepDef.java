package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P0_LoginPage;
import org.example.pages.P1_HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D1_HomeStepDef {
    P1_HomePage homePage=new P1_HomePage();
    P0_LoginPage loginPage=new P0_LoginPage();
    Actions action=new Actions(Hooks.driver);
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(30));

    @And("user clicks on the logout button.")
    public void ClickOnLogoutBtn(){
       homePage.companyDataDropdown().click();
        homePage.logoutBtn().click();
    }
    @Then("the user is be navigated to the Login screen.")
    public void verifyUserLoggedoutSuccessfully(){
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://madar-development-backoffice-wedvk6ltea-uc.a.run.app/en/Account/Login"));
        soft.assertEquals(loginPage.loginHeader().getText(),"Login");
        soft.assertAll();
    }
    @Given("user clicks on {string} on the side menu And user selects {string} the user will be navigated to the subcaegory screen\"")
    public void clickOnCategorySideMenu(String categoryName, String subCategoryName) {
        try {
            if (categoryName.equals("Company Info")) {
                wait.until(ExpectedConditions.visibilityOf(homePage.companyInfoMenu()));
              //  action.moveToElement(homePage.companyInfoMenu()).perform();
                homePage.companyInfoMenu().click();

                WebElement subCategoryElement = null;

                switch (subCategoryName) {
                    case "Service Centers":
                        subCategoryElement = homePage.serviceCenterSubCategoryUndercompanyInfoMenu();
                        wait.until(ExpectedConditions.visibilityOf(subCategoryElement));
                       // action.moveToElement(subCategoryElement).click().perform();
                        subCategoryElement.click();
                        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://madar-development-backoffice-wedvk6ltea-uc.a.run.app/en/ServiceCenters","failed");
                        break;

                    case "Employees":
                        subCategoryElement = homePage.empolyeesSubCategoryUndercompanyInfoMenu();
                        wait.until(ExpectedConditions.visibilityOf(subCategoryElement));
                        action.moveToElement(subCategoryElement).click().perform();
                        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("Employees"));
                        break;

                    case "Packages":
                        subCategoryElement = homePage.packagesSubCategoryUndercompanyInfoMenu();
                        wait.until(ExpectedConditions.visibilityOf(subCategoryElement));
                        action.moveToElement(subCategoryElement).click().perform();
                        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("HajjPackages"));
                        break;

                    case "Assembly Points":
                        subCategoryElement = homePage.AssemblyPointsSubCategoryUndercompanyInfoMenu();
                        wait.until(ExpectedConditions.visibilityOf(subCategoryElement));
                        action.moveToElement(subCategoryElement).click().perform();
                        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("AssemblyPoints"));
                        break;

                    default:
                        System.out.println("This subcategory doesn't exist");
                        break;
                }

                if (subCategoryElement != null) {
                    System.out.println("The side menu category is " + categoryName + " sub-category URL: " +Hooks.driver.getCurrentUrl());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("An error occurred while clicking on the side menu: " + e.getMessage());
        }
    }
}