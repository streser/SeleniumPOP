package SeleniumTests;

import org.junit.Test;

/**
 * Created by streser on 02.01.2017.
 */
public class LoginTest extends SeleniumTest {
    @Test
    public void shouldBePossibleToLogIn() {
        LoginPage lp = new LoginPage(driver);
        lp.open();

        DashboardPage dp = lp.logIn("Warsztatautomatyzacja","notsosimplepass123");

        assertTrue(dp.isOpen());
    }
}
