package example.second.way.test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import example.second.way.DriverFactoryModule;
import example.second.way.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class AbstractMultipleWebDriverTest {

    // As I want to create multiple injector instances of the configured type I can reuse the module
    private DriverFactoryModule driverFactoryModule;

    @Inject
    private WebDriverManager driverManager;

    @BeforeSuite
    void prepare() {
        driverFactoryModule = new DriverFactoryModule();
    }

    @BeforeMethod
    void setup() {
        System.out.println("Creating Driver");
        Guice.createInjector(driverFactoryModule)
                .injectMembers(this);
    }

    @AfterMethod
    void teardown() {
        System.out.println("Quitting Driver");
        driverManager.quitDriver();
    }

    @AfterSuite
    void shutdown() {
        driverManager.stopService();
    }
}