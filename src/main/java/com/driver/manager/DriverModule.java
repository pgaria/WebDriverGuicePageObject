package com.driver.manager;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.name.Names;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(DriverManager.class)
                .to(ChromeDriverManager.class).in(Scopes.SINGLETON);;
        //My test input properties
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/uat.properties"));
            Names.bindProperties(binder(), props);
        } catch (IOException e) {
            //skip
        }

    }
    @Provides
    public WebDriver getDriver(DriverManager driverManager) {
        return driverManager.getDriver();
    }
    @Provides
    public Actions getActions(WebDriver driver) {
        return new Actions(driver);
    }

    @Provides
    public JavascriptExecutor getExecutor(WebDriver driver) {
        return (JavascriptExecutor)(driver);
    }

}