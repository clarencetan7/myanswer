package tmsandbox.common.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tmsandbox.common.BasePage;
import tmsandbox.common.Helper;
import tmsandbox.common.LocatorWrapper;

import java.util.List;

public class UsedCarsPage extends BasePage {
    private WebDriver driver = null;

    private static LocatorWrapper CAR_MAKES = new LocatorWrapper("Used car makes", "//table[@id=\"makes\"]/.//a[not(contains(.,'more...'))]", LocatorWrapper.LocatorType.XPATH);
    private static LocatorWrapper MOTOR_SEARCH_KEYWORD_INPUT = new LocatorWrapper("Used car keyword input", "sidebar-54", LocatorWrapper.LocatorType.ID);
    private static LocatorWrapper USED_CAR_SEARCH_BTN = new LocatorWrapper("Used car keyword input", "//div[@id=\"sidebarSearch1\"]/.//button[contains(.,\"Search\")]", LocatorWrapper.LocatorType.XPATH);

    public UsedCarsPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public List<WebElement> getUsedCarMakes(){
        return findElementsWhenVisible(CAR_MAKES);
    }

    public void searchUsedCarBasedOnKeyword(String keyword){
        int i = 0;
        while(!stateOfStaleElement(MOTOR_SEARCH_KEYWORD_INPUT)){
            Helper.sleepInMillis(200);
            i++;
            if(i == 5){
                break;
            }
        }

        findElementWhenPresent(MOTOR_SEARCH_KEYWORD_INPUT).sendKeys(keyword);
        findElementWhenVisible(USED_CAR_SEARCH_BTN).click();
    }

}
