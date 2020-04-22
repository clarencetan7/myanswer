package tmsandbox.common.pageobjects;

import org.openqa.selenium.WebDriver;
import tmsandbox.common.BasePage;
import tmsandbox.common.LocatorWrapper;

public class HomePage extends BasePage {
    private WebDriver driver = null;

    private static LocatorWrapper MOTORS_CAT = new LocatorWrapper("Motor Category", "SearchTabs1_MotorsAnchor", LocatorWrapper.LocatorType.ID);

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void openMotorCategory(){
        findElementWhenVisible(MOTORS_CAT).click();
    }

}
