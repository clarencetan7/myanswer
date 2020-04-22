package tmsandbox.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BasePage {

    protected WebDriver driver = null;
    private long timeOut = 10;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    private static By getByObject(LocatorWrapper locator){
        By byObject = null;
        switch (locator.elementType){
            case ID:
                byObject = By.id(locator.elementValue);
                break;
            case XPATH:
                byObject = By.xpath(locator.elementValue);
                break;
            case CSS:
                byObject = By.cssSelector(locator.elementValue);
                break;
            default:
                byObject = By.linkText(locator.elementValue);
        }

        return byObject;
    }

    protected WebElement findElementWhenVisible(LocatorWrapper locator){
        WebElement element = null;
        try{
            element = new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOfElementLocated(getByObject(locator)));
        }catch (Exception e){
            Assert.fail("The element named : \"" + locator.elementName + "\" was not visible.");
        }
        return element;
    }

    protected WebElement findElementWhenPresent(LocatorWrapper locator){
        WebElement element = null;
        try{
            element = new WebDriverWait(driver, timeOut).until(ExpectedConditions.presenceOfElementLocated(getByObject(locator)));
        }catch (Exception e){
            Assert.fail("The element named : \"" + locator.elementName + "\" was not present.");
        }
        return element;
    }

    protected Boolean stateOfStaleElement(LocatorWrapper locator){
        return new WebDriverWait(driver, timeOut)
                    .until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(getByObject(locator)))));
    }

    protected List<WebElement> findElementsWhenVisible(LocatorWrapper locator){
        List<WebElement> element = null;
        try{
            element = new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByObject(locator)));
        }catch (Exception e){
            Assert.fail("The elements collectively named as : \"" + locator.elementName + "\" was not found");
        }
        return element;
    }

}
