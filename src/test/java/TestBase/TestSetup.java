package TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.util.Properties;

public class TestSetup {

    public static WebDriver driver;
    public Properties prop = new Properties();

    /**
     * @Performs
     *      Read and load the properties file.
     */
    public TestSetup() {
        try {
            prop.load(new FileInputStream("./src/test/resources/config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Performs
     *     Setups the browser before the actual test case execution.
     */
    @BeforeMethod
    public void setupBrowser() {
        String browser=System.getProperty("browser").toLowerCase();
        try {
            switch (browser) {
                case "chrome":
                    //Chrome driver setup with WebDriverManager dependency
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                    // Deletes all the cookies
                    driver.manage().deleteAllCookies();
                    System.out.println("Chrome browser launched successfully");
                    break;
                case "firefox":
                    //FireFox driver setup with WebDriverManager dependency
                    WebDriverManager.firefoxdriver().setup();
                    //Initializing Firefox driver
                    driver = new FirefoxDriver();
                    driver.manage().deleteAllCookies();
                    System.out.println("Firefox browser launched successfully");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception occurred to launch the browser " + e);
            Assert.fail("Exception occurred to launch the browser " + e);
        }
    }

    /**
     * @Performs
     *        Closes the browser after the test execution is completed.
     */
    @AfterMethod
    public void closeBrowser() {
        try {
            driver.quit();
            System.out.println("Browser closed successfully");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception occurred to close the driver" + e);
            Assert.fail("Exception occurred to close the driver" + e);
        }
    }

    /**
     * @Performs
     *      Launches the URL in the browser
     * @param URL
     */
    public void launchURL(String URL) {
        try {
            //Launching the URL using get() method
            driver.get(URL);
            //Maximize the browser window
//            driver.manage().window().maximize();
            System.out.println("User successfully navigated to URL " + URL);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to launch " + URL + " with exception " + e);
            Assert.fail("Failed to launch " + URL + " with exception " + e);
        }
    }
}
