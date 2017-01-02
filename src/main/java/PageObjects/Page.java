package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by streser on 02.01.2017.
 */
public abstract class Page {
    protected final WebDriver driver;

    public String baseUrl = "http://streser.nazwa.pl/szkolenia";

    public Page(WebDriver driver){
        this.driver = driver;
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void insertText(String text, By locator) {
        driver.findElement(locator).sendKeys(text);
    }


    public BlogPage goToBlogPage() {
        driver.get(baseUrl);
        return new BlogPage(driver);
    }
}
