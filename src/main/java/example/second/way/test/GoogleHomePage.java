package example.second.way.test;

import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {

    private final WebDriver webDriver;
    @FindBy(name = "q")
    WebElement searchBox;

    @FindBy(name = "btnK")
    WebElement searchButton;

    @Inject
    public GoogleHomePage(
                         final WebDriver webDriver) {
        System.out.println("Driver in Google page"+webDriver.toString());
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void loadHomePage() {
        webDriver.get("https://www.google.com");
    }


    public void enterText(String text) {
        searchBox.sendKeys(text);
    }

    public void CickSearch() {
        searchButton.click();
    }
}
