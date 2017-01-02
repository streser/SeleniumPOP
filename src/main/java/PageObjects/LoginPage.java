package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by streser on 02.01.2017.
 */
public class LoginPage extends Page {

    public String baseUrl = "http://streser.nazwa.pl/szkolenia/";

    public LoginPage(WebDriver driver) {
       super(driver);
    }

    public LoginPage open() {
        driver.get(baseUrl + "/wp-admin");
        return this;
    }

    public DashboardPage logIn(String login, String password) {
        driver.findElement(By.id("user_login")).sendKeys(login);
        driver.findElement(By.id("user_pass")).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();
        return new DashboardPage(driver);
    }
}
