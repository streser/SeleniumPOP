package PageObjects;

import org.apache.commons.configuration.CompositeConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by streser on 02.01.2017.
 */
public class DashboardPage extends AdminPage {

    public DashboardPage(WebDriver driver,CompositeConfiguration cc) {
        super(driver,cc);
    }

    public boolean isOpen() {
        return driver.findElement(By.linkText("Howdy, warsztatautomatyzacja")).isDisplayed();
    }

}
