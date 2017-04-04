package pages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static utils.LogHandler.initLogging;


/**
 * Created by gabriel.giorgi on 4/4/2017.
 */
/*
 * Implementation of Logger on utils/LogHandler
 *
 *
 */

public class GeneralPage {

    protected WebDriverWait wait;
    protected WebDriver driver;
    protected Actions action;
    protected Logger logger;

        public GeneralPage(WebDriver driver){

            this.driver= driver;
            this.action= new Actions(driver);
            this.wait= new WebDriverWait(driver, 20);
            this.logger = initLogging();

        }

        //General Methods for navigating pages.

        public void navigateTo(WebDriver driver,String url){
            logger.info("Navigating to: " + url + " page.");
            driver.get(url);
        }

        //Exercice 2
        public void fillFieldText(final By locator , final String someText){
            logger.info("Entering: '" + someText + "' to text field.");
            driver.findElement(locator).sendKeys(someText);
            logger.info(someText + " entered successfully.");
        }

    }


