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
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        //if assertion passed, it will set test status in report to passed


    }

    /**
     * Enter wrong credentials and verify warning message
     */


   @Test
  public void verifyWarningMassage(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong","wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(),"Invalid user name or password.");
        //take a secreenshot
        BrowserUtils.getScreenshot("warning_massage");

  }



}
