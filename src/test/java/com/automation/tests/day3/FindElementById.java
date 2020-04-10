package com.automation.tests.day3;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById {
    public static void main(String[] args) throws  Exception {
        WebDriverManager.chromedriver().version("79.0").setup();
       WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
     Thread.sleep(2000);
    WebElement password = driver.findElement(By.name("password"));
    password.sendKeys("SuperSecretPassword");
    driver.findElement(By.id("wooden spoon") ).click();
        Thread.sleep(2000);

        String expected = "Welcome to the Secure Area. When you are done click logout below ";
        String  actual = driver.findElement(By.tagName("h4")).getText();

        if(expected.equals(actual)) {
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        WebElement logout = driver.findElement(By.partialLinkText("Logout"));
        String href = logout.getAttribute("href");
        System.out.println(href);
        System.out.println("className");
        logout.click();
        Thread.sleep(2000);
        driver.findElement(By.name("usrename")) .sendKeys("wrong");
        driver.findElement(By.name("password")) .sendKeys("wrong");
        Thread.sleep(2000);
      WebElement errorMassage = driver.findElement(By.id("flash-massage"));
        System.out.println(errorMassage.getText());
        Thread.sleep(2000);






      driver.quit();


    }
}
