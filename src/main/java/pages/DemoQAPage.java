package pages;

import org.openqa.selenium.WebDriver;
import static utils.PropertiesHandler.getPropertyValue;

/**
 * Created by gabriel.giorgi on 4/4/2017.
 */
public class DemoQAPage extends GeneralPage {

    public DemoQAPage (WebDriver driver) {
        super(driver);
    }

    public DemoQARegistrationPage registrar(){
        logger.info("Navigate to registration page");
        driver.get(getPropertyValue("registrationPageURL"));
        return new DemoQARegistrationPage(driver);
    }
}
