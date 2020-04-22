package tmsandbox.common.pageobjects;

import org.openqa.selenium.WebDriver;
import tmsandbox.common.BasePage;
import tmsandbox.common.LocatorWrapper;

public class MotorsCategoryPage extends BasePage {
    private WebDriver driver = null;

    private static LocatorWrapper USED_CARS_LINK = new LocatorWrapper("Used Cars link", "Used cars", LocatorWrapper.LocatorType.LINKTEXT);

    public MotorsCategoryPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void openUsedCars(){
        findElementWhenVisible(USED_CARS_LINK).click();
    }

}
