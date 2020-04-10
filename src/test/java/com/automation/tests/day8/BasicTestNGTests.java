package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {
    @BeforeTest
    public void beforeTest(){
        System.out.println("BEFORE TEST");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AFTER TEST");
    }

    //RUNS BEFORE EVERY TEST AUTOMATICALLY
    //works as a pre-condition or setup
    @BeforeClass
    public void beforeClass(){
        System.out.println("BEFORE CLASS");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AFTER CLASS");
    }


     @BeforeMethod
     public void setUp(){
         System.out.println("BEFORE METHOD");
     }

     //runs automatically after every test
     @AfterMethod
     public void tearDown(){
         System.out.println("AFTER METHOD");
     }

    @Test
    public  void test1() {
        System.out.println("Test 1");
        String expected ="apple";
        String actual = "apple";
        Assert.assertEquals(actual , expected);
    }

    @Test
    public  void test2(){
        System.out.println("Test 2");
        int num1 =5;
        int num2 = 10;
        // it calls hard assertion
        //if assertion fails - it stops the execution(due to execution)
        Assert.assertTrue(num1 < num2);
    }





}
