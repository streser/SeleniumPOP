package PageObjects;

import org.openqa.selenium.WebDriver;

/**
 * Created by streser on 02.01.2017.
 */
public class LoginPage extends Page {
    public LoginPage(WebDriver driver) {
       super(driver);
    }

    public LoginPage open() {
        //TO DO implement this

        return this;
    }

    public DashboardPage logIn(String warsztatautomatyzacja, String notsosimplepass123) {
        //TO DO implement this

        return new DashboardPage(driver);
    }
}
