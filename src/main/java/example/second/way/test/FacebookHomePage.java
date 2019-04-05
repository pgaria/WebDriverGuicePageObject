package example.second.way.test;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookHomePage {

    private final WebDriver webDriver;
    @FindBy(name = "q")
    WebElement searchBox;

    @FindBy(name = "btnK")
    WebElement searchButton;

    @Inject
    public FacebookHomePage(
            final WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void loadHomePage() {
        webDriver.get("https://www.facebook.com");
    }


    public void enterText(String text) {
        searchBox.sendKeys(text);
    }

}
