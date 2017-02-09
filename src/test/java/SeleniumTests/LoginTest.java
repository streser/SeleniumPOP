package SeleniumTests;

import PageObjects.DashboardPage;
import PageObjects.LoginPage;
import org.apache.commons.configuration.CompositeConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



/**
 * Created by streser on 02.01.2017.
 */
public class LoginTest extends SeleniumTest {



    @Test
    public void shouldBePossibleToLogInWithValidUsernameAndPassword() {
        LoginPage lp = new LoginPage(driver,config);
        lp.open();

        DashboardPage dp = lp.logIn();

        assertTrue(dp.isOpen());
    }



    @Test
    public void shouldBePossibleToLogInWithInvalidUsernameAndPassword(){
        LoginPage lp = new LoginPage(driver,config);
        lp.open();
        lp.logInWithWrongCredentials();
        String actualMessage = lp.failedMessage();
        String expectedMessage = "ERROR: Invalid username. Lost your password?";
        Assert.assertEquals(actualMessage, expectedMessage);

    }
}