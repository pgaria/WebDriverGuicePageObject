package com.driver.manager;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FactoryPatternTest {

    DriverManager driverManager;
    WebDriver driver;


    @BeforeMethod
    public void beforeMethod() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }


    @Test
    public void launchGoogleTest() {
        driver.get("https://www.google.com");
        Assert.assertEquals("Google", driver.getTitle());
    }

    @Test
    public void launchYahooTest() {
        driver.get("https://www.yahoo.com");
        Assert.assertEquals("Yahoo", driver.getTitle());
    }

}