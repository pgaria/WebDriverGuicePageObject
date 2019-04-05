package example.second.way.test;

import com.google.inject.Inject;
import org.testng.annotations.Test;

public class HomePageTests extends AbstractMultipleWebDriverTest {

    @Inject
    private GoogleHomePage googleHomePage;

    @Test
    void googleHomePageTest() {
        System.out.println("google home page object google"+ googleHomePage);
        googleHomePage.loadHomePage();
        googleHomePage.enterText("google");
        googleHomePage.CickSearch();
    }

    @Test
    void FacebookHomePageTest() {
        System.out.println("google home page object pawan"+ googleHomePage);
        googleHomePage.loadHomePage();
        googleHomePage.enterText("pawan");
        googleHomePage.CickSearch();
    }

}
