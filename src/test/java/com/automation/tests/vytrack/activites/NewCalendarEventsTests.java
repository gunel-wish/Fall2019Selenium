package com.automation.tests.vytrack.activites;

import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalendarEventsPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class NewCalendarEventsTests extends AbstractTestBase {
    LoginPage loginPage = new LoginPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    /**
     * Test Case: Default options
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Default owner name should be current user/
     **/

    @Test
    public void defaultOptionsTest(){
        loginPage.login();

        calendarEventsPage.navigateTo("Activities" ,"Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();

        Assert.assertEquals(calendarEventsPage.getOwnerName(),calendarEventsPage.getCurrentUserName());
        String actualStarDate  = calendarEventsPage.getStartDate();
        String expectedStartDate = DateTimeUtilities.getCurrentDate("MMM dd ,yyyy");

        Assert.assertEquals(actualStarDate,expectedStartDate);

    }

    @Test
    public void timeDifference(){
        loginPage.login();
        calendarEventsPage.navigateTo("Activities" ,"Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();

        String startTime = calendarEventsPage.getStartTime();
        String endTime = calendarEventsPage.getEndTime();
        String fotmat = "h:mm a";

        long actual = DateTimeUtilities.getTimeDifference(startTime, endTime , fotmat);

        Assert.assertEquals(actual,1,"Time different is not correct");


    }
    @Test
    public void verifyColumnNamesTest(){
        loginPage.login();
        calendarEventsPage.navigateTo("Activities" ,"Calendar Events");

        List<String> expected = Arrays.asList("TITLE","CALENDAR","START" ,"END","RECURRENT" ,"RECURRENCE","INVITATION STATUS");
     Assert.assertEquals(calendarEventsPage.getColumnNames(),expected);

    }

    @Test(dataProvider = "calendarEvents")
    public void createCalendarEvenTest( String title ,String description){
        //only for extent report , To create a test in html report
        test = report.createTest("Create calendar event");
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        calendarEventsPage.enterCalendarEventTitle(title);
        calendarEventsPage.enterCalendarEventDescription(description);
        calendarEventsPage.clickOnSaveAndClose();

        //verify that calendar event info  is correct
        Assert.assertEquals(calendarEventsPage.getGeneralInfoDescriptionText(),description);
        Assert.assertEquals(calendarEventsPage.getGeneralInfoTitleText(),title);
        // for extend report , specify test pass in report (if all assertion passed)
        test.pass("Calendar event was created successfully");

    }

    @DataProvider
    public  Object[][] calendarEvents(){
        return  new Object[][]{
                {"Daily stand-up","Scrum meeting to provide updates"}
        };
    }






}
