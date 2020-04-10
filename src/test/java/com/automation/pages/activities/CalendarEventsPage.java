package com.automation.pages.activities;

import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalendarEventsPage extends AbstractTestBase {

    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEvent;

    @FindBy(className = ".select2-chosen")
    private WebElement owner;



    public String getOwnerName(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();
    }



 public void clickToCreateCalendarEvent(){
     BrowserUtils.waitForPageToLoad(10);
     wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent));

 }










}
