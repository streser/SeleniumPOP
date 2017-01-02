package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by streser on 02.01.2017.
 */
public class DashboardPage extends AdminPage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpen() {
        return driver.findElement(By.linkText("Howdy, warsztatautomatyzacja")).isDisplayed();
    }

}
