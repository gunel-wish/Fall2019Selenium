package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http:/google.com");
        Thread.sleep(2000);
        //By.name("q") --->name"q"
        //name it's one of selenium locators
        //there are 8 locators
        // we use locators
        WebElement search = driver.findElement(By.name("q"));
        //once we found an element , how to enter text?
        //to enter
        search.sendKeys( "Java", Keys.ENTER);
        Thread.sleep(2000);
        //if see <a> element , it's calls link
        // visible text of this link , can be used
        WebElement news = driver.findElement(By.linkText("news"));
        driver.quit();
    }
}
