package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P3_ServiceCenterList {
    public WebElement ServiceCenterCreateBtn(){
        return (Hooks.driver.findElement(By.xpath("//a[@href='/en/ServiceCenters/Create']")));
    }
    public WebElement dataTablesortIdBtn(){
        return (Hooks.driver.findElement(By.xpath("//th[@class='sorting sorting_asc']")));
    }
    public WebElement dialogMessage(){
        return (Hooks.driver.findElement(By.xpath("//div[@class='swal-title']")));
    }
    public WebElement dialogMessageOkBtn(){
        return (Hooks.driver.findElement(By.xpath("//button[text()='OK']")));
    }
    public WebElement servicecenterDatatable(){
        return (Hooks.driver.findElement(By.id("table")));
    }
    public WebElement firstRowIntheDataTable(){
        return (Hooks.driver.findElement(By.cssSelector("tbody tr:first-child")));
    }
    public WebElement codeCell(){
        return (Hooks.driver.findElement(By.cssSelector("td:nth-child(2)")));
    }
    public WebElement arabicNameCell (){
        return (Hooks.driver.findElement(By.cssSelector("td:nth-child(3)")));
    }
    public WebElement englishNameCell  (){
        return (Hooks.driver.findElement(By.cssSelector("td:nth-child(4)"  )));
    }
}
