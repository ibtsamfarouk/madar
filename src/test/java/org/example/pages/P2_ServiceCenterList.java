package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P2_ServiceCenterList {
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
    public WebElement idCellOfFirstRow (){

        return (Hooks.driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(1)")));
    }

    public List<WebElement> serviceCenterIdsOndatatable() {
        return (Hooks.driver.findElements(By.cssSelector("td:nth-child(1)")));

    }

    public WebElement codeCell(){
        return (Hooks.driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(2)")));
    }
    public WebElement arabicNameCell (){

        return (Hooks.driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(3)")));
    }
    public WebElement englishNameCell  (){

        return (Hooks.driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(4)"  )));
    }
    public WebElement detailsActionOfFirstRowInServiceCenterDatatable  (){

        return (Hooks.driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(6) i.fas.fa-book.bg-success")));
    }
    public WebElement editActionOfFirstRowInServiceCenterDatatable  (){

        return (Hooks.driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(6) i.fas.fa-pen.bg-warning"  )));
    }
    public WebElement deleteActionOfFirstRowInServiceCenterDatatable (){

        return (Hooks.driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(6) i.fas.fa-trash.bg-danger"  )));
    }
    public List <WebElement> allRowsInServiceCenterDatatable (){

        return (Hooks.driver.findElements(By.cssSelector("tbody tr")));
    }

    public WebElement ServiceCenterListScreenTitleLabel(){

        return (Hooks.driver.findElement(By.cssSelector("span.navbar-brand")));
    }
}
