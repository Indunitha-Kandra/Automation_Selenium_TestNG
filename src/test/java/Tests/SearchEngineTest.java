package Tests;

import Pages.GoogleSearchPage;
import Pages.StartPageSearchPage;
import TestBase.TestSetup;
import Utils.Helpers;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SearchEngineTest extends TestSetup {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    StartPageSearchPage startPageSearchPage=new StartPageSearchPage();
    Helpers helpers=new Helpers();

    @Test(description = "Automate 2 search engines")
    void SearchEngineTest() {
        /*Print statement to differentiate the test steps*/
        System.out.println("========================================================================");
        /*Getting the keyword from run time execution.*/
        String searchKeyword = System.getProperty("searchKeyword");
        /*Starting Test for Google Search Engine.*/
        System.out.println("Starting search Engine test for "+ prop.getProperty("GoogleSearchEngine"));
        /*Launching the URL for Google Search Engine*/
        launchURL(prop.getProperty("GoogleSearchEngine"));
        /*Searching for the keyword in search bar*/
        googleSearchPage.searchKeyword(searchKeyword);
        /*Getting the search Results URLs and storing it ina ArrayList.*/
        ArrayList<String> googleSearchResultsURls = googleSearchPage.getSearchResultsURls();
        /*Verifying the search result contains the keyword or no.*/
        helpers.verifySearchResultsContainsKeyword(googleSearchResultsURls, searchKeyword);
        /*Print statement to differentiate the test steps*/
        System.out.println("========================================================================");

        /*Starting Test for StartPage Search Engine.*/
        System.out.println("Starting search Engine test for "+ prop.getProperty("startPageSearchEngine"));
        /*Launching the URL for StartPage Search Engine.*/
        launchURL(prop.getProperty("startPageSearchEngine"));
        /*Searching for the keyword in search bar*/
        startPageSearchPage.searchKeyword(searchKeyword);
        /*Getting the search Results URLs and storing it ina ArrayList.*/
        ArrayList<String> startPageSearchURLs = startPageSearchPage.getSearchResults();
        /*Verifying the search result contains the keyword or no.*/
        helpers.verifySearchResultsContainsKeyword(startPageSearchURLs, searchKeyword);
        /*Print statement to differentiate the test steps*/
        System.out.println("========================================================================");

        /*Comparing stored results for both engines and listing out the most popular items (the ones which were
        found in both search engines)*/
        ArrayList<String> commonResults=helpers.getCommonValuesFromArrayList(googleSearchResultsURls,startPageSearchURLs);
        System.out.println("The common list of the mostPopular/Common search results: "+commonResults);
    }
}
