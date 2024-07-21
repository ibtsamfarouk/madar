package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class P1_HomePage {
    public WebElement companyDataDropdown(){


        return Hooks.driver.findElement(By.cssSelector("a.dropdown-toggle"));
    }
    public WebElement logoutBtn(){
        return Hooks.driver.findElement(By.cssSelector("button.dropdown-item"));
    }
    public WebElement companyInfoMenu() {
        return Hooks.driver.findElement(By.xpath("//a[@data-bs-target='#companydata']"));
    }
    public WebElement serviceCenterSubCategoryUndercompanyInfoMenu() {
        return Hooks.driver.findElement(By.xpath("//a[@href='/en/ServiceCenters']"));
    }
    public WebElement empolyeesSubCategoryUndercompanyInfoMenu() {
        return Hooks.driver.findElement(By.xpath("//a[@href='/en/Employees']"));
    }
    public WebElement packagesSubCategoryUndercompanyInfoMenu() {
        return Hooks.driver.findElement(By.xpath("//a[@href='/en/HajjPackages']"));
    }
    public WebElement AssemblyPointsSubCategoryUndercompanyInfoMenu() {
        return Hooks.driver.findElement(By.xpath("//a[@href='/en/AssemblyPoints']"));
    }
}
