package smoke;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tmsandbox.common.DriverUtil;
import tmsandbox.common.pageobjects.HomePage;
import tmsandbox.common.pageobjects.MotorsCategoryPage;
import tmsandbox.common.pageobjects.SearchResultPage;
import tmsandbox.common.pageobjects.UsedCarsPage;

public class TmSandboxTests {
    HomePage homePage = null;
    MotorsCategoryPage motorCategory = null;
    UsedCarsPage usedCars = null;
    SearchResultPage searchResult = null;

    @BeforeMethod
    public void setUpTest(){
        DriverUtil.initializeDriver();
        DriverUtil.openApplicationUrl();

        homePage = new HomePage(DriverUtil.getDriver());
        motorCategory = new MotorsCategoryPage(DriverUtil.getDriver());
        usedCars = new UsedCarsPage(DriverUtil.getDriver());
        searchResult = new SearchResultPage(DriverUtil.getDriver());
    }

    @Test
    public void numberOfUsedCarMakeTest(){
        int expectedUsedCarsMake = 35;
        homePage.openMotorCategory();
        motorCategory.openUsedCars();
        int usedCarsNum = usedCars.getUsedCarMakes().size();

        Assert.assertEquals(expectedUsedCarsMake, usedCarsNum,
                "The expected Used car makes (" + expectedUsedCarsMake + ") was not equal to actual (" + usedCarsNum + "). ");
    }

    @Test
    public void currentKiaAvailableTest(){
        String expectedListingNum = "1";
        homePage.openMotorCategory();
        motorCategory.openUsedCars();
        usedCars.searchUsedCarBasedOnKeyword("Kia");
        String actualNum = searchResult.getNumberOfMatchingCarListing();

        Assert.assertEquals(expectedListingNum, actualNum,
                "The expected matches (" + expectedListingNum + ") does not match the actual (" + actualNum + ").");
    }

    @Test
    public void searchForUnavailableVehicle(){
        homePage.openMotorCategory();
        motorCategory.openUsedCars();
        usedCars.searchUsedCarBasedOnKeyword("Hispano Suiza");
        String actualHeading = searchResult.getSearchSummaryHeading();

        Assert.assertTrue(actualHeading.contains("No search results"),
                "The expected message on an empty search result was not found.");
    }

    @AfterMethod
    public void cleanUpTest(){
        DriverUtil.quitTest();
        // clean page objects
        homePage = null;
        motorCategory = null;
        usedCars = null;
        searchResult = null;
    }
}
