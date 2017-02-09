package PageObjects;

import org.apache.commons.configuration.CompositeConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by streser on 02.01.2017.
 */
public abstract class AdminPage extends Page{
    public AdminPage(WebDriver driver, CompositeConfiguration cc) {
        super(driver,cc);
    }

    public PostsListPage goToPostsListPage() {
        click(By.linkText("Posts"));
        return new PostsListPage(driver,cc);
    }

    public LoginPage logOut() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-my-account\"]/a"))).build().perform();
        action.moveToElement(driver.findElement(By.linkText("Log Out"))).click().build().perform();
        return new LoginPage(driver,cc);
    }
}
