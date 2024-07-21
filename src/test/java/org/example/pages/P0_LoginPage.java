package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P0_LoginPage {
    public WebElement emailTxtBox(){
        return Hooks.driver.findElement(By.id("Email"));
    }
    public WebElement passwordTxtBox(){
        return Hooks.driver.findElement(By.id("Password"));
    }
    public WebElement loginBtn(){
        return Hooks.driver.findElement(By.cssSelector("button.btn.btn-success.mr-1"));
    }

    public WebElement DashboardSpan(){
        return Hooks.driver.findElement(By.cssSelector("span.navbar-brand"));
    }

    public WebElement errorMessage(){
        return Hooks.driver.findElement(By.xpath("//li[text()='Login Failed']"));
    }
    public WebElement loginHeader(){
        return Hooks.driver.findElement(By.tagName("h1"));
    }

}
