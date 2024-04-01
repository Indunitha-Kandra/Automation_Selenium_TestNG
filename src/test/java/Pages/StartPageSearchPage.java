package Pages;

import Utils.ActionsOnPage;
import Utils.Helpers;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class StartPageSearchPage extends ActionsOnPage {
    //WebElements
    private By searchBox=By.cssSelector("#search #q");
    private By searchButton=By.cssSelector(".search-btn");
    private By searchResults=By.cssSelector("a[class='p_ si27 a']");

    //Object Creation
    Helpers helpers=new Helpers();

    //Page Methods
    /**
     * @Performs
     *          Searches the keyword in search box in StartPage Search Engine
     * @param keyword
     */
    public void searchKeyword(String keyword){
        clearAndEnterText(searchBox,keyword,"Search box in StartPage search engine");
        waitAndClick(searchButton,"Search button in StartPage search engine");
    }

    /**
     * @Performs
     *      Gets the search results URLs and stores in the form of a ArrayList
     * @return
     */
    public ArrayList<String> getSearchResults(){
        return helpers.getAttributeArrayList(searchResults,"href","Search Results in StartPage search engine");
    }

}
