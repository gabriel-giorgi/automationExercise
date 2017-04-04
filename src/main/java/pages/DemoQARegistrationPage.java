package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by gabriel.giorgi on 4/4/2017.
 */
public class DemoQARegistrationPage extends GeneralPage {

    By locatorSubmitButtom = By.name("pie_submit");

    public DemoQARegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
     public void submit(){
        driver.findElement(locatorSubmitButtom).click();
     }
}
