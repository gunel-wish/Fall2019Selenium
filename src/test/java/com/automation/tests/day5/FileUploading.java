package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.google.gson.internal.$Gson$Preconditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
         driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(2);

        WebElement upload = driver.findElement(By.id("file-upload"));
        String filepath = System.getProperty("user.dir") + "/pop.xml";
        String file2path = "88ac0737-f7e3-4dbb-80b5-9ac47fa669b4.jpg";
        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        //im gonna upload pom.xml file
       // System.out.println(filePath);
       upload.sendKeys(file2path);
       driver.findElement(By.id("file-submit")).click();



     //  driver.findElements(By.id("Screen Shot 2020-03-05 at 8.47.29 PM"));

        BrowserUtils.wait(3);
        driver.quit();



    }
}
