package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P4_EditServiceCenter {
    public WebElement ServiceCenterEditScreenTitleLabel(){
        return (Hooks.driver.findElement(By.cssSelector("span.navbar-brand")));
    }
    public WebElement ArabicNameTxtBox(){
        return (Hooks.driver.findElement(By.name("ArabicName")));
    }
    public WebElement englishNameTxtBox(){
        return (Hooks.driver.findElement(By.name("EnglishName")));
    }
    public WebElement ArabicAddressTxtBox(){
        return (Hooks.driver.findElement(By.id("ArabicAddress")));
    }
    public WebElement EnglishAddressTxtBox(){
        return (Hooks.driver.findElement(By.id("EnglishAddress")));
    }
    public WebElement codeTxtBox(){
        return (Hooks.driver.findElement(By.id("Code")));
    }
    public WebElement map(){
        return (Hooks.driver.findElement(By.xpath("//div[@id='dvMap']/div/div[3]/div/div[2]")));
    }
    public WebElement saveBtn(){
        return (Hooks.driver.findElement(By.xpath("//input[@type='submit']")));
    }

}
