package com.google.guice.tests;

import com.driver.manager.DriverModule;
import com.google.inject.Inject;
import com.google.pages.Google;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

@Guice(modules = DriverModule.class)
public class GuiceTest {

    @Inject
    Google google;


    @Test()
    public void searchGoogle() throws InterruptedException {

        google.goTo();

        //change the color of the google page
        google.execute("document.body.style.backgroundColor='green';");

        //do search and show results
        google.getSearchWidget().searchFor("guice");
        google.getResults().displayResult();
    }

    @AfterMethod
    public void quitDriver()
    {
        google.driver.quit();
    }

}