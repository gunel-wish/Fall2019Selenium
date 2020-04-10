package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation  {
    public static void main(String[] args) throws Exception {
      // to start selenium script we need:
      // setup webDriver (browser driver)and create webDriver object
        WebDriverManager.chromedriver().version("79").setup();
       WebDriver driver = new ChromeDriver();
        // in selenium , eveything start from webdriver interface
        driver.get("http://google.com");
        driver.manage().window().maximize();// to max broweser
      Thread.sleep(3000);
      //method that return
      String title = driver.getTitle();
      String expectedTitle = "Google";

        System.out.println( " Title is ..." + title);

        if(expectedTitle.equals(title)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("Test Failed");
        }

        driver.navigate().to("http://amazon.com");
       if(driver.getTitle().toLowerCase().contains("amazon")){
           System.out.println("Test Passed");
       }else{
           System.out.println("Test Failed");
       }
// comeback to google
        driver.navigate().back();
        Thread.sleep(3000);

       verifyEquals(driver.getTitle(),"Google");
         driver.navigate().forward();
        Thread.sleep(3000);
        System.out.println( " Title is ..." + title);
        // to get URL
        System.out.println("URL: " + driver.getCurrentUrl());
        driver.navigate().refresh();
        Thread.sleep(3000);

       driver.close();


    }

       public static void verifyEquals(String arg1 , String arg2) {
        if(arg1.equals(arg2)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        }



}
