package example.second.way;

import com.google.inject.AbstractModule;
import org.openqa.selenium.WebDriver;

public class DriverFactoryModule extends AbstractModule {

    @Override
    protected void configure() {
        final WebDriverManager webDriverManager = new DriverManagerFactory().get();
        bind(WebDriverManager.class).toInstance(webDriverManager);
        bind(WebDriver.class).toProvider(webDriverManager);
    }
}
