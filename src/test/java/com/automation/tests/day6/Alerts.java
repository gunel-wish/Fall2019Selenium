package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        //   WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click();

        BrowserUtils.wait(3);
         //to get text from popup massage
        String popupText = driver.switchTo().alert().getText();
        System.out.println(popupText);
        driver.switchTo().alert().accept();
        System.out.println("Test #1");
        String  expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        // if will fail, because there is a type
        if (expected.equals(actual)){
            System.out.println("Test passed");
        }else {
            System.out.println("Test Failed");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
        }
        System.out.println("Test #2");
        BrowserUtils.wait(3);

        buttons.get(1).click();//to click on the 2nd button
        BrowserUtils.wait(3);
        //to click cancel
        driver.switchTo().alert().dismiss();

        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();
        if (expected2.equals(actual2)){
            System.out.println("Test passed");
        }else {
            System.out.println("Test Failed");
            System.out.println("Expected: " + expected2);
            System.out.println("Actual: " + actual2);
        }

        //click on button3
        //enter some text :Hello World!
        //verify that result text ends with hell world!
        System.out.println("Test #3");
        buttons.get(2).click();
        BrowserUtils.wait(3);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello, World!");    //enter text
        alert.accept();   //click ok

        String actual3 = driver.findElement(By.id("result")).getText();
        String  expected3 = "Hello, World!";

        if (expected3.endsWith(actual3)){
            System.out.println("Test passed");
        }else {
            System.out.println("Test Failed");
            System.out.println("Expected: " + expected3);
            System.out.println("Actual: " + actual3);
        }
        BrowserUtils.wait(3);

        BrowserUtils.wait(3);
        driver.quit();

    }
}
