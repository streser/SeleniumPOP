package PageObjects;

import org.apache.commons.configuration.CompositeConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public  class LoginPage extends Page {

    private WebElement message;


    public LoginPage(WebDriver driver,CompositeConfiguration cc) {
       super(driver,cc);
    }

    public LoginPage open() {
        driver.get(baseUrl + "/wp-login.php");
        return this;
    }

    public DashboardPage logIn() {
        tryLogIn("warsztatautomatyzacja","notsosimplepass123");
        return new DashboardPage(driver,cc);
    }

    public void logInWithWrongCredentials(){
        tryLogIn("test","test");

    }

    private void tryLogIn(String login, String password) {
        insertText(login, By.id("user_login"));
        insertText(password, By.id("user_pass"));
        clickWhenReady(By.id("wp-submit"),2);

    }

    public String failedMessage(){
//        this.message = driver.findElement(By.cssSelector("div[id='login_error']"));
        this.message = getElement("div[id='login_error']","css");
        return this.message.getText();
    }



}
