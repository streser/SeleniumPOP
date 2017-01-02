package SeleniumTests;

import PageObjects.DashboardPage;
import PageObjects.LoginPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by streser on 02.01.2017.
 */
public class LoginTest extends SeleniumTest {
    @Test
    public void shouldBePossibleToLogIn() {
        LoginPage lp = new LoginPage(driver);
        lp.open();

        DashboardPage dp = lp.logIn();

        assertTrue(dp.isOpen());
    }
}
