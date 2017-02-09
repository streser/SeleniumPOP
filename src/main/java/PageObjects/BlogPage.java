package PageObjects;

import org.apache.commons.configuration.CompositeConfiguration;
import org.openqa.selenium.WebDriver;

/**
 * Created by streser on 02.01.2017.
 */
public class BlogPage extends Page {
    public BlogPage(WebDriver driver,CompositeConfiguration cc) {
        super(driver,cc);
    }

    public boolean isPostPublished(String title) {
        return driver.getPageSource().contains(title);
    }
}
