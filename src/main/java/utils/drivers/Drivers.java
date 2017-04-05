package utils.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;
import static utils.PropertiesHandler.getPropertyValue;

/**
 * Created by gabriel.giorgi on 4/4/2017.
 */

/* Static factory methods for drivers creation */
public class Drivers {

    static String chromeURL = Drivers.class.getClassLoader().getResource("drivers/chromedriver.exe").getFile();
    static String firefoxURL = Drivers.class.getClassLoader().getResource("drivers/geckodriver.exe").getFile();
    static String IExploreURL = Drivers.class.getClassLoader().getResource("drivers/IEDriverServer.exe").getFile();


    public static WebDriver asLocalChrome(WebDriver driver) {
        System.setProperty(CHROME_DRIVER_EXE_PROPERTY, chromeURL);
        driver = new ChromeDriver();
        return driver;

    }

    public static WebDriver asRemoteChrome(WebDriver driver) {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        try {
            driver = new RemoteWebDriver(new URL(getPropertyValue("urlRemote")), desiredCapabilities);
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        }
        return driver;
    }

    public static WebDriver asLocalFirefox(WebDriver driver) {
        System.setProperty("webdriver.gecko.driver", firefoxURL);
        driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver asRemoteFirefox(WebDriver driver) {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
        try {
            driver = new RemoteWebDriver(new URL(getPropertyValue("urlRemote")), desiredCapabilities);

        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        }
        return driver;
    }

    public static WebDriver asLocalIExplore(WebDriver driver) {
        System.setProperty("webdriver.ie.driver", IExploreURL);
        driver = new InternetExplorerDriver();
        return driver;
    }

    public static WebDriver asRemoteIExplore(WebDriver driver) {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.internetExplorer();
        try {
            driver = new RemoteWebDriver(new URL(getPropertyValue("urlRemote")), desiredCapabilities);
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        }
        return driver;
    }
}
