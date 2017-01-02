package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by streser on 02.01.2017.
 */
public class LoginPage extends Page {


    public LoginPage(WebDriver driver) {
       super(driver);
    }

    public LoginPage open() {
        driver.get(baseUrl + "/wp-login.php");
        return this;
    }

    public DashboardPage logIn() {
        tryLogIn("warsztatautomatyzacja","notsosimplepass123");
        return new DashboardPage(driver);
    }

    private void tryLogIn(String login, String password) {
        insertText(login, By.id("user_login"));
        insertText(password, By.id("user_pass"));
        click(By.id("wp-submit"));
    }

}
