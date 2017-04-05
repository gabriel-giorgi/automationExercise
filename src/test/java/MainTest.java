import factories.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.DemoQAPage;
import pages.DemoQARegistrationPage;


import static utils.PropertiesHandler.getPropertyValue;
import static utils.LogHandler.initLogging;


/**
 * Created by gabriel.giorgi on 4/3/2017.
 */


public class MainTest {

    public static void main(String[] args) {

        //Locators of WebElements
        By FirstNameFieldLocator = By.id("name_3_firstname");
        By LastNameFieldLocator = By.xpath("html/body/div[1]/div/div[1]/main/article/div/div/div[3]/form/ul/li[1]/div[1]/div/input"); //absolute xpath
        By UserNameLocator = By.xpath(".//*[@id='username']");  // relative xpath
        By EmailNameLocator = By.id("email_1");

        //Initialization of Logger
        Logger logger = initLogging();

        //Getting properties to configure a new driver
        String typeConnection = getPropertyValue("connectionType");
        String typeBrowser = getPropertyValue("browserType");
        logger.info("Initializing the browser");

        //Invoke Factory to instance a new driver with the properties above (Exercise 2)
        WebDriver driver = DriverFactory.getIntance().startBrowser(typeConnection, typeBrowser);
        logger.info("Maximizing the browser");
        driver.manage().window().maximize();

        //Login into demo Page in order to complete some text fields
        DemoQAPage mainPage = new DemoQAPage(driver);
        mainPage.navigateTo(driver, getPropertyValue("mainPageURL"));

        logger.info("Going to the registration the page");
        DemoQARegistrationPage registrationPage = mainPage.registrar();

        //Completing some text fields (Exercise 1 )
        registrationPage.fillFieldText(FirstNameFieldLocator, getPropertyValue("firstName"));
        registrationPage.fillFieldText(LastNameFieldLocator, getPropertyValue("lastName"));
        registrationPage.fillFieldText(UserNameLocator, getPropertyValue("UserName"));
        registrationPage.fillFieldText(EmailNameLocator, getPropertyValue("Email"));


    }

}