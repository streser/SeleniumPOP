package SeleniumTests;

import org.apache.commons.configuration.CompositeConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by streser on 02.01.2017.
 */
public class SeleniumTest {

    protected WebDriver driver;
    public CompositeConfiguration config;


    @Before
    public void setUp() throws Exception {
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    public WebElement getElement(String locator, String type) {
        type = type.toLowerCase();
        if (type.equals("id")) {
            System.out.println("Element found with id: " + locator);
            return this.driver.findElement(By.id(locator));
        } else if (type.equals("name")) {
            System.out.println("Element found with name: " + locator);
            return this.driver.findElement(By.name(locator));
        } else if (type.equals("xpath")) {
            System.out.println("Element found with xpath: " + locator);
            return this.driver.findElement(By.xpath(locator));
        } else if (type.equals("css")) {
            System.out.println("Element found with css: " + locator);
            return this.driver.findElement(By.cssSelector(locator));
        } else if (type.equals("classname")) {
            System.out.println("Element found with classname: " + locator);
            return this.driver.findElement(By.className(locator));
        } else if (type.equals("tagname")) {
            System.out.println("Element found with tagname: " + locator);
            return this.driver.findElement(By.tagName(locator));
        } else if (type.equals("linktext")) {
            System.out.println("Element found with link text: " + locator);
            return this.driver.findElement(By.linkText(locator));
        } else if (type.equals("partiallinktext")) {
            System.out.println("Element found with partial link text: " + locator);
            return this.driver.findElement(By.partialLinkText(locator));
        } else {
            System.out.println("Locator type not supported");
            return null;
        }
    }

    public List<WebElement> getElementList(String locator, String type) {
        type = type.toLowerCase();
        List<WebElement> elementList = new ArrayList<WebElement>();
        if (type.equals("id")) {
            elementList = this.driver.findElements(By.id(locator));
        } else if (type.equals("name")) {
            elementList = this.driver.findElements(By.name(locator));
        } else if (type.equals("xpath")) {
            elementList = this.driver.findElements(By.xpath(locator));
        } else if (type.equals("css")) {
            elementList = this.driver.findElements(By.cssSelector(locator));
        } else if (type.equals("classname")) {
            elementList = this.driver.findElements(By.className(locator));
        } else if (type.equals("tagname")) {
            elementList = this.driver.findElements(By.tagName(locator));
        } else if (type.equals("linktext")) {
            elementList = this.driver.findElements(By.linkText(locator));
        } else if (type.equals("partiallinktext")) {
            elementList = this.driver.findElements(By.partialLinkText(locator));
        } else {
            System.out.println("Locator type not supported");
        }
        if (elementList.isEmpty()) {
            System.out.println("Element not found with " + type + ": " + locator);

        } else {
            System.out.println("Element found with " + type + ": " + locator);
        }
        return elementList;
    }

    public WebElement waitForElement(By locator, int timeout) {
        WebElement element = null;
        try {
            System.out.println("Waiting for max:: " + timeout + " seconds for " + element + " to be available");
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("Element" + element + "appeared on the web page");
        } catch (Exception e) {
            System.out.println("Element" + element + "not appeared on the web page");

        }
        return element;
    }

    public WebElement clickWhenReady(By locator, int timeout) {
        WebElement element = null;
        try {
            System.out.println("Waiting for max:: " + timeout + " seconds for " + element + " to be available");
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            element = wait.until(
                    ExpectedConditions.elementToBeClickable(locator));
            System.out.println("Element" + element + " clicked on the web page");
            element.click();
        } catch (Exception e) {
            System.out.println("Element" + element + " not clicked on the web page");

        }
        return element;
    }

    public boolean isNullOrEmpty(List<WebElement> a) {

        return a == null || a.isEmpty();
    }


    @Test
    public void test_nr_1() {

        driver.get("http://streser.nazwa.pl/szkolenia/wp-login.php");
        driver.findElement(By.id("user_login")).sendKeys("warsztatautomatyzacja");
        driver.findElement(By.id("user_pass")).sendKeys("notsosimplepass123");
        driver.findElement(By.id("wp-submit")).click();
        driver.findElement(By.linkText("Posts")).click();
        assertTrue(driver.getPageSource().contains("Posts"));


    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
