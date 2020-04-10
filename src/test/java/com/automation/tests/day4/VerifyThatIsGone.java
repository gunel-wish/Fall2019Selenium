package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.print.DocFlavor;
import java.util.List;

public class VerifyThatIsGone {

    /*
    how to check if element doesn't exists any more
     */
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);
        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);
        List<WebElement> list = driver.findElements(By.id("disappearing_button"));
        if(driver.findElements(By.id("disappearing_button")).size() == 0 ){
            System.out.println("Test passed");
        }else{
            System.out.println("Test faild");
        }
        Thread.sleep(2000);
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        for (WebElement button : buttons){
            
        }
        driver.quit();


    }





}
