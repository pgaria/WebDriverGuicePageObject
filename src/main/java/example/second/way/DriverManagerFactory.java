package example.second.way;

import com.google.inject.Provider;

public class DriverManagerFactory implements Provider<WebDriverManager> {

    private WebDriverManager webDriverManager;


    @SuppressWarnings("CyclomaticComplexity")
    public static AbstractDriverManager getManager(final String typeBrowser) {

        final AbstractDriverManager driverManager;

        if (typeBrowser == null) {
            throw new IllegalArgumentException("Requested DriverType is not recognised");
        }

        switch (typeBrowser) {
            case "CHROME":
                driverManager = new ChromeDriverManager();
                break;

            case "FIREFOX":
                driverManager = new FirefoxDriverManager();
                break;
            default:
                throw new UnsupportedOperationException(
                        String.format("Requested Browser '%s' has not yet been implemented.",
                                typeBrowser));
        }
        return driverManager;

    }

    @Override
    public WebDriverManager get() {
        if (webDriverManager == null) {
            webDriverManager = getManager("CHROME");
        }
        return webDriverManager;
    }
}