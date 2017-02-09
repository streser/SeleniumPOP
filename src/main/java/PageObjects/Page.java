package PageObjects;

import util.HelperUtil.ELEMENT_SELECTOR;
import org.apache.commons.configuration.CompositeConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public abstract class Page  {

    protected final WebDriver driver;
    protected final CompositeConfiguration cc;
    protected final ELEMENT_SELECTOR defaultElementSelector = ELEMENT_SELECTOR.CSS;



    public String baseUrl = "http://streser.nazwa.pl/szkolenia";
    protected long timeout = 3;



    public Page(WebDriver driver,CompositeConfiguration cc){
        this.driver = driver;
        this.cc = cc;

    }

    public WebElement getElement(String locator, String type) {
        type = type.toLowerCase();
        if (type.equals("id")) {
            System.out.println("Element found with id: " + locator);
            return this.driver.findElement(By.id(locator));
        }
        else if (type.equals("name")) {
            System.out.println("Element found with name: " + locator);
            return this.driver.findElement(By.name(locator));
        }
        else if (type.equals("xpath")) {
            System.out.println("Element found with xpath: " + locator);
            return this.driver.findElement(By.xpath(locator));
        }
        else if (type.equals("css")) {
            System.out.println("Element found with css: " + locator);
            return this.driver.findElement(By.cssSelector(locator));
        }
        else if (type.equals("classname")) {
            System.out.println("Element found with classname: " + locator);
            return this.driver.findElement(By.className(locator));
        }
        else if (type.equals("tagname")) {
            System.out.println("Element found with tagname: " + locator);
            return this.driver.findElement(By.tagName(locator));
        }
        else if (type.equals("linktext")) {
            System.out.println("Element found with link text: " + locator);
            return this.driver.findElement(By.linkText(locator));
        }
        else if (type.equals("partiallinktext")) {
            System.out.println("Element found with partial link text: " + locator);
            return this.driver.findElement(By.partialLinkText(locator));
        }
        else {
            System.out.println("Locator type not supported");
            return null;
        }
    }

    public List<WebElement> getElementList(String locator, String type) {
        type = type.toLowerCase();
        List<WebElement> elementList = new ArrayList<WebElement>();
        if (type.equals("id")) {
            elementList = this.driver.findElements(By.id(locator));
        }
        else if (type.equals("name")) {
            elementList = this.driver.findElements(By.name(locator));
        }
        else if (type.equals("xpath")) {
            elementList = this.driver.findElements(By.xpath(locator));
        }
        else if (type.equals("css")) {
            elementList = this.driver.findElements(By.cssSelector(locator));
        }
        else if (type.equals("classname")) {
            elementList = this.driver.findElements(By.className(locator));
        }
        else if (type.equals("tagname")) {
            elementList = this.driver.findElements(By.tagName(locator));
        }
        else if (type.equals("linktext")) {
            elementList = this.driver.findElements(By.linkText(locator));
        }
        else if (type.equals("partiallinktext")) {
            elementList = this.driver.findElements(By.partialLinkText(locator));
        }
        else {
            System.out.println("Locator type not supported");
        }
        if (elementList.isEmpty()) {
            System.out.println("Element not found with " + type +": " + locator);

        } else {
            System.out.println("Element found with " + type +": " + locator);
        }
        return elementList;
    }

    public WebElement waitForElement(By locator, int timeout){
        WebElement element = null;
        try{
            System.out.println("Waiting for max:: " + timeout + " seconds for " + element + " to be available");
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("Element" + element + "appeared on the web page");
        } catch (Exception e){
            System.out.println("Element" + element + "not appeared on the web page");

        }
        return element;
    }

    public WebElement clickWhenReady(By locator, int timeout){
        WebElement element = null;
        try{
            System.out.println("Waiting for max:: " + timeout + " seconds for " + element + " to be available");
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            element = wait.until(
                    ExpectedConditions.elementToBeClickable(locator));
            System.out.println("Element" + element + " clicked on the web page");
            element.click();
        } catch (Exception e){
            System.out.println("Element" + element + " not clicked on the web page");

        }
        return element;
    }




    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void insertText(String text, By locator) {
        driver.findElement(locator).sendKeys(text);
    }




    public BlogPage goToBlogPage() {
        driver.get(baseUrl);
        return new BlogPage(driver,cc);
    }


    public boolean isNullOrEmpty(ArrayList <WebElement> a){

        return a == null || a.isEmpty();
    }


}
