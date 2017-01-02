package PageObjects;

import org.openqa.selenium.WebDriver;

/**
 * Created by streser on 02.01.2017.
 */
public class BlogPage extends Page {
    public BlogPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPostPublished(String title) {
        return driver.getPageSource().contains(title);
    }
}
