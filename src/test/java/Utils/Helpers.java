package Utils;

import TestBase.TestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Helpers extends ActionsOnPage {

    public ArrayList<String> getCommonValuesFromArrayList(ArrayList<String> arr1, ArrayList<String> arr2) {
        ArrayList<String> resultArrayList = new ArrayList<String>();
        for (String temp : arr1) {
            if (arr2.contains(temp)) {
                resultArrayList.add(temp);
            }
        }
        return resultArrayList;
    }

    public void verifySearchResultsContainsKeyword(ArrayList<String> result, String keyWord) {
        for (String temp : result) {
            temp = temp.toLowerCase();
            keyWord = keyWord.toLowerCase();
            if (temp.contains(keyWord)) {
                Assert.assertTrue(temp.contains(keyWord));
                System.out.println("Expected " + keyWord + " contains in the result " + temp);
            } else {
                System.out.println("Expected " + keyWord + " does not contains in the result " + temp);
            }
        }
    }

    /**
     * @param locator
     * @param attribute
     * @param friendlyNameOfElement
     * @Performs Fetches the Attribute and stores in Array List
     * @return- Returns the Array List
     */
    public ArrayList<String> getAttributeArrayList(By locator, String attribute, String friendlyNameOfElement) {
        List<WebElement> searchResultsElements = getWebElements(locator, friendlyNameOfElement);
        ArrayList<String> searchResultsHasMap = new ArrayList<String>();
        for (int i = 0; i < searchResultsElements.size(); i++) {
            String resultText = getAttribute(searchResultsElements.get(i), attribute, friendlyNameOfElement);
            searchResultsHasMap.add(i, resultText);
        }
        System.out.println("Search Results are " + searchResultsHasMap);
        return searchResultsHasMap;
    }
}
