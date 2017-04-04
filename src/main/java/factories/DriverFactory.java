package factories;

import org.openqa.selenium.WebDriver;
import utils.drivers.Drivers;


/**
 * Created by gabriel.giorgi on 4/4/2017.
 */
public class DriverFactory {

    private static DriverFactory Instance;
    protected WebDriver driver = null;

    public static DriverFactory getIntance() {
        if (Instance == null) {
            Instance = new DriverFactory();
        }

        return Instance;
    }

    protected DriverFactory() {

    }


    public WebDriver startBrowser(String typeConnection, String typeBrowser) {
        /* Checking type connection for local ones */
        if (typeConnection.equals("local")) {
            /* Checking browser type */
            if (typeBrowser.equals("chrome")) {
                driver = Drivers.asLocalChrome(driver);
            }

            if (typeBrowser.equals("firefox")) {
                driver = Drivers.asLocalFirefox(driver);
            }
            if (typeBrowser.equals("iexplore")) {
                driver = Drivers.asLocalIExplore(driver);
            }
        }
        else {
            if (typeBrowser.equals("chrome")) {
                driver = Drivers.asRemoteChrome(driver);
            }

            if (typeBrowser.equals("firefox")) {
                driver = Drivers.asRemoteFirefox(driver);
            }

            if (typeBrowser.equals("iexplore")) {
                driver = Drivers.asRemoteIExplore(driver);
            }
        }
        return driver;
    }

}

