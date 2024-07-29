package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P7_DeleteServiceCenter {
    public WebElement ServiceCenterDeleteScreenTitleLabel(){
        return (Hooks.driver.findElement(By.cssSelector("span.navbar-brand")));
    }

    public WebElement deleteBtn(){
        return (Hooks.driver.findElement(By.cssSelector("input.btn.btn-success.ms-2")));
    }
}

