package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P0_LoginPage;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D0_loginStepDef {

        P0_LoginPage loginPage=new P0_LoginPage();


        @Given("^user enters \"(.*)\" \"(.*)\" and \"(.*)\"$")
        public void loginSteps(String type,String username, String password)
        {
            if(type.equals("valid")){
                loginPage.emailTxtBox().sendKeys(username);
                loginPage.passwordTxtBox().sendKeys(password);
            }
            else {
                loginPage.emailTxtBox().sendKeys(type+username);
                loginPage.passwordTxtBox().sendKeys(type+password);

            }
        }
        @And("user presses on the login button")
        public void clickLoginBtn()
        {
            loginPage.loginBtn().click();
        }
        @Then("user logs in to the system successfully")
        public void checkSuccessfulLogin()
        {

            SoftAssert soft=new SoftAssert();
            soft.assertEquals(Hooks.driver.getCurrentUrl(),"https://madar-development-backoffice-wedvk6ltea-uc.a.run.app/en");
            soft.assertTrue(loginPage.DashboardSpan().isDisplayed());
            soft.assertAll();

        }

        @Then("user can not login to the system")
        public void checkUnSuccessfulLogin()
        {
            //  1- error message contains "Login was unsuccessful."
            // 2- the color of this message is red  "#e4434b"
            SoftAssert soft=new SoftAssert();
            soft.assertTrue(loginPage.errorMessage().getText().contains("Login Failed"));
         // String color= loginPage.errorMessage().getCssValue("color");
         //  soft.assertEquals(Color.fromString(color).asHex(),"#e4434b");
            soft.assertAll();

        }

    }


