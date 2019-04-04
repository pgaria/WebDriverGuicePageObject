package com.driver.manager;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new ChromeDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();

        }
        return driverManager;

    }
}