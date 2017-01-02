package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by streser on 02.01.2017.
 */
public abstract class Page {
    protected final WebDriver driver;

    public Page(WebDriver driver){
        this.driver = driver;
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void insertText(String text, By locator) {
        driver.findElement(locator).sendKeys(text);
    }


}
