package Pages;

import Utils.ActionsOnPage;
import Utils.Helpers;
import org.openqa.selenium.By;
import java.util.ArrayList;

public class GoogleSearchPage extends ActionsOnPage {

    //WebElements
    private By searchBox = By.cssSelector("textarea[title='Search']");
    private By searchButton = By.cssSelector("input[value='Google Search']");
    private By searchResults = By.xpath("//div[@class='yuRUbf']//a | //div[@class='M42dy']//a");

    //Object Creation
    Helpers helpers=new Helpers();

    //Page Methods

    /**
     * @Performs
     *          Searches the keyword in search box in Google Search Engine
     * @param keyword
     */
    public void searchKeyword(String keyword) {
        clearAndEnterText(searchBox, keyword, "Search box in Google search engine");
        waitAndClick(searchButton, "Search button in Google search engine");
    }

    /**
     * @return
     * @Performs Gets the search results URLs and stores in the form of a ArrayList
     */
    public ArrayList<String> getSearchResultsURls() {
        return helpers.getAttributeArrayList(searchResults,"href","Search Results in Google search engine");
    }


}
