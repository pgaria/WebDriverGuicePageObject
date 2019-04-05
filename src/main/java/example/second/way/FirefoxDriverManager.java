package example.second.way;

import org.openqa.selenium.chrome.ChromeDriver;

public class FirefoxDriverManager extends AbstractDriverManager implements WebDriverManager {

    @Override
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        setDriver(new ChromeDriver());
    }

    @Override
    public void startService() {

    }

    @Override
    public void stopService() {

    }
}
