package Utils;

import TestBase.TestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ActionsOnPage extends TestSetup {
    /**
     * @Performs
     *      Fetches all the WebElements for the given locator.
     * @param byLocator
     * @param friendlyNameOfElement
     * @return
     */
    public List<WebElement> getWebElements(By byLocator, String friendlyNameOfElement) {
        try {
            List<WebElement> elements = driver.findElements(byLocator);
            return elements;
        } catch (Exception e) {
            Assert.fail("Failed to find the element " + friendlyNameOfElement + " with exception " + e);
        }
        return null;
    }

    /**
     * @Performs
     *      Explicit wait in selenium- performs according to the condition.
     * @param element
     * @param time
     * @param condition
     */
    public void explicitWait(WebElement element, long time, String condition) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        switch (condition) {
            case "visibility":
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            case "clickable":
                wait.until(ExpectedConditions.elementToBeClickable(element));
                break;
        }
    }

    /**
     * @Performs
     *      Fetches the Attribute for the given WebElement and Attribute name.
     * @param element
     * @param attribute
     * @param friendlyNameOfElement
     * @return
     */
    public String getAttribute(WebElement element, String attribute, String friendlyNameOfElement) {
        try {
            String attributeValue = element.getAttribute(attribute);
            return attributeValue;
        } catch (Exception e) {
            Assert.fail("Failed to fetch the attribute " + attribute + " for " + friendlyNameOfElement + " with exception " + e);
        }
        return null;
    }

    /**
     * @Performs
     *         Clears and enters the text for the give locator
     * @param byLocator
     * @param text
     * @param friendlyNameOfElement
     */
    public void clearAndEnterText(By byLocator, String text, String friendlyNameOfElement) {
        try {
            WebElement element = driver.findElement(byLocator);
            explicitWait(element, 20, "clickable");
            element.clear();
            element.sendKeys(text);
            System.out.println("Entered the text as " + text + " in " + friendlyNameOfElement);
        } catch (Exception e) {
            Assert.fail("Failed to enter text with exception " + e);
        }
    }

    /**
     * @Performs
     *      Waits and click on the element for the given locator.
     * @param byLocator
     * @param friendlyNameOfElement
     */
    public void waitAndClick(By byLocator, String friendlyNameOfElement) {
        try {
            WebElement element = driver.findElement(byLocator);
            explicitWait(element, 10, "clickable");
            element.click();
            System.out.println("Clicked on " + friendlyNameOfElement);
        } catch (Exception e) {
            Assert.fail("Failed to click with exception " + e);
        }
    }
}
