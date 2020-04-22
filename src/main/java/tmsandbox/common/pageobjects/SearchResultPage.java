package tmsandbox.common.pageobjects;

import org.openqa.selenium.WebDriver;
import tmsandbox.common.BasePage;
import tmsandbox.common.Helper;
import tmsandbox.common.LocatorWrapper;

public class SearchResultPage extends BasePage {
    private WebDriver driver = null;

    private static LocatorWrapper LISTING_MESSAGE = new LocatorWrapper("Search listing header", "//div[@id=\"SearchResults\"]/div[@id=\"ListView_listingTableHeader_headerColumnListView\"]", LocatorWrapper.LocatorType.XPATH);
    private static LocatorWrapper SEARCH_SUMMARY = new LocatorWrapper("Search summary", "div[class=\"search-summary\"]", LocatorWrapper.LocatorType.CSS);

    public SearchResultPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public String getNumberOfMatchingCarListing(){
        String message = findElementWhenPresent(LISTING_MESSAGE).getText();
        return message.substring(0, message.indexOf(' '));
    }

    public String getSearchSummaryHeading(){
        return findElementWhenPresent(SEARCH_SUMMARY).getText();
    }

}
