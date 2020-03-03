package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation  {
    public static void main(String[] args) throws Exception {
      // to start selenium script we need:
      // setup webDriver (browser driver)and create webDriver object
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        // in selenium , eveything start from webdriver interface
        driver.get("http://google.com");

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
       driver.close();

    }





}
