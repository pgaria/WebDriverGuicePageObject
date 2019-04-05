package example.second.way;

import com.google.inject.Provider;
import com.google.inject.Provides;
import org.openqa.selenium.WebDriver;

public interface WebDriverManager  extends Provider<WebDriver> {

    void createDriver();
    void startService();
    void stopService();
    void quitDriver();
    WebDriver get();
}
