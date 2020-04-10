package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioButtons {

 private WebDriver driver;


     @Test
    public void  testRadioButtons() {
         driver.findElement(By.linkText("RadioButtons")).click();
         BrowserUtils.wait(4);
         List<WebElement> radioButtons = driver.findElements(By.tagName("input"));
         for (WebElement each : radioButtons) {
             if (each.getAttribute("id").equals(" ")) {
                 if (!each.isSelected()) {
                     each.click();
                 }
                 Assert.assertTrue(each.isSelected());
                 BrowserUtils.wait(3);
             }

         }

         BrowserUtils.wait(3);
     }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        //INTERVIEW QUESTION: HOW TO HANDLE SSL ISSUES IN SELENIUM?
        //ChromeOptions - use to customize browser for tests
        ChromeOptions chromeOptions = new ChromeOptions();
        //to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        //provide chromeOptions object into chromedriver constructor
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        //close browser and destroy webdriver object
        driver.quit();
    }





}
