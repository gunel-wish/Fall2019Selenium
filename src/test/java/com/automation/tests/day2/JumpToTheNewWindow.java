package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver() ;
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);
        // every window has some id , this is calls window handle
        //based on window , we can swith in betweeen window
        String windowHandle = driver.getWindowHandle();

        System.out.println(windowHandle);
        //getWindowHandals() -returns od's of all current opende windows
        //Set- doen't allow duplicate
        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println(windowHandle);
        System.out.println("Before Switch :" + driver.getCurrentUrl());
        // since we have all windows
        // and we know id original window
        //we can say swith to something that is not equals to old window id
        for (String windowId : windowHandles){
            // if it's an old window,then switch
            if(!windowId.equals(windowHandle) ){
                //to jump to the window
                driver.switchTo().window(windowId);
            }
        }

        System.out.println("After switch :" + driver.getCurrentUrl());

       driver.close();
    }

    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for (String window: windows){
            driver.switchTo().window(window);
            if (driver.getTitle().equals(pageTitle)){
                break;
            }
        }
    }



}
