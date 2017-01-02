package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by streser on 02.01.2017.
 */
public abstract class AdminPage extends Page{
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public PostsListPage goToPostsListPage() {
        click(By.linkText("Posts"));
        return new PostsListPage(driver);
    }

    public LoginPage logOut() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-my-account\"]/a"))).build().perform();
        action.moveToElement(driver.findElement(By.linkText("Log Out"))).click().build().perform();
        return new LoginPage(driver);
    }
}
