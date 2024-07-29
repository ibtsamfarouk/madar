package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P5_DetailsServiceCenter {

    public WebElement TitleLabel(){
        return (Hooks.driver.findElement(By.cssSelector("span.navbar-brand")));
    }
    public WebElement englishNameDiv(){
        return (Hooks.driver.findElement(By.xpath("//div[contains(@class, 'details-row')]//div[contains(text(), 'English Name')]/following-sibling::div[1]")));
    }
    public WebElement arabicNameDiv(){
        return (Hooks.driver.findElement(By.xpath("//div[contains(@class, 'details-row')]//div[contains(text(), ' Arabic Name')]/following-sibling::div[1]")));
    }
    public WebElement arabicAddressDiv(){
        return (Hooks.driver.findElement(By.xpath("//div[contains(@class, 'details-row')]//div[contains(text(), 'Arabic Address')]/following-sibling::div[1]")));
    }
    public WebElement englishAddressDiv(){
        return (Hooks.driver.findElement(By.xpath("//div[contains(@class, 'details-row')]//div[contains(text(), 'English Address')]/following-sibling::div[1]")));
    }
    public WebElement codeDiv(){
        return (Hooks.driver.findElement(By.xpath("//div[contains(@class, 'details-row')]//div[contains(text(), 'Code')]/following-sibling::div[1]")));
    }

}
