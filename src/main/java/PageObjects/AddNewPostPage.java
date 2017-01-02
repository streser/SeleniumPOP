package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by streser on 02.01.2017.
 */
public class AddNewPostPage extends AdminPage {
    public AddNewPostPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPostPage addNewPost(String postTitle, String postContent) {
        insertText(postTitle, By.cssSelector("input#title"));
        insertText(postContent,  By.xpath("//*[@id=\"content\"]"));
        click(By.id("publish"));
        return this;
    }

}
