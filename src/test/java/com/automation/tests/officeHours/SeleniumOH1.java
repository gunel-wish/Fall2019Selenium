package com.automation.tests.officeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SeleniumOH1 {

    public static void main(String[] args) {

        ArrayList<String > keysToSearch = new ArrayList<>();
        keysToSearch.add("fruits");
        keysToSearch.add("veggies");
        keysToSearch.add("berries");
        Iterator <String >iterator = keysToSearch.iterator();
        while (iterator.hasNext() ) {
            System.out.println(iterator.next());
        }


        Iterator <String > iterator1 = keysToSearch.iterator();
        while (iterator1.hasNext()  ){
            String item = iterator1.next();
            System.out.println(iterator1.next());
            System.out.println("*" + iterator1.next());

            HashMap<String ,String > personalInfo =  new HashMap<>();
            personalInfo.put("name" ,"Brayn");
            personalInfo.put("student_id" , "1246789087765");
            personalInfo.put("major" , "Computer since");

            Iterator<String > mapIterator = personalInfo.keySet().iterator();
            while (mapIterator.hasNext() ){
                String key = mapIterator.next();
                System.out.println(mapIterator.next() + ":" + personalInfo.get( key));
            }

        }
//======================
        // Selenium
 /*
        id- unique (it is not always available)- we always want to use it
        class- classname
        name
        tag- every element will have a tag
        will only work with the link
        linkText
        partial linkText
        css
        xpath
        <input id = "global - enhancements - search - query "

        input - tag
        key = "value" - attributes
        id = "global - enhancements - search - query " - one of the attributes
        - we can use class to locate element


  */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver()  ;
        driver.get("http://etsy.com");
        WebElement searchBar = driver.findElement(By.id("global - enhancements - search - query ") );
        // find  element ( )--> return Webelement
        //as parameter we put By.locator  


    }
}
