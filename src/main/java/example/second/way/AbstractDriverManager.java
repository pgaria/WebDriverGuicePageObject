package example.second.way;

import org.openqa.selenium.WebDriver;

public abstract class AbstractDriverManager implements  WebDriverManager{

    private WebDriver driver;


    @Override
    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            System.out.println("WebDriver quit");
            driver = null;
        }
    }

    @Override
    public WebDriver get() {
        if (null == driver) {
            startService();
            createDriver();
        }
        return driver;
    }

    final void setDriver(final WebDriver driver) {
        this.driver = driver;
    }
}