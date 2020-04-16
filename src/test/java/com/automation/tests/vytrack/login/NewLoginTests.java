package com.automation.tests.vytrack.login;
import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import com.automation.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {


    @Test
    public void verifyPageTitle() {
        //test-->EXtendTest object
        // we must  add to test at the begining
        //test = report.create
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        test.info("Login as store manager");
        BrowserUtils.wait(2);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        //if assertion passed, it will set test status in report to passed
      test.pass("Page title Dashboard was verified");

    }

    /**
     * Enter wrong credentials and verify warning message
     */


   @Test
  public void verifyWarningMassage(){
       test = report.createTest("Verify warning massage");

        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong","wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(),"Invalid user name or password.");
        //take a secreenshot
        BrowserUtils.getScreenshot("warning_massage");

        test.pass("Warning massage is displayed");


  }

  @Test(dataProvider = "credentials")
  public void loginWithDDT(String userName , String password){
      test = report.createTest("Verify page title");
      LoginPage loginPage = new LoginPage();
      loginPage.login( userName, password);
      test.info("Login as " + userName);
      BrowserUtils.wait(2);
      Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
      test.pass("Page title Dashboard was verified");

  }


    @DataProvider
  public Object[][] credentials(){
       return new Object[][]{
               {"storemanager85" , "UserUser123"},
               {"salesmanager110" , "UserUser123"},
               {"user16" ,  "UserUser123"},
       };


  }

    // Object [][] or object[] or Iterator<Object[]>
    //Object [] -1 column with a data
    //Object[][] 2+



}
