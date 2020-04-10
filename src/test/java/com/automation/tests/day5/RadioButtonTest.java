package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonTest {
    public static void main(String[] args) {
       // WebDriver driver = DriverFactory.createDriver("chrome") ;
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);

        WebElement blackButton = driver.findElement(By.id("black"));
        // if visible and eligible to click
        if(blackButton.isDisplayed() && blackButton.isEnabled()) {
            System.out.println("CLICKED ON BLACK BUTTON");
            blackButton.click();
        }else  {
            System.out.println("FAILED TO CLICK ON BLACK BUTTON");
        }

        BrowserUtils.wait(2);
        // how do we verify that button clicked
        if( blackButton.isSelected() ){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

 BrowserUtils.wait(2);
        driver.quit();

    }
}
