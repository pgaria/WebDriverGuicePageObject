package com.driver.manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class ChromeDriverManager extends DriverManager {

    private ChromeDriverService chService;

    @Override
    public void startService() {

    }

    @Override
    public void stopService() {

    }

    @Override
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();

    }

}
