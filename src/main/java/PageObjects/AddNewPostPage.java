package PageObjects;

import org.openqa.selenium.WebDriver;

/**
 * Created by streser on 02.01.2017.
 */
public class AddNewPostPage extends Page {
    public AddNewPostPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPostPage addNewPost(String s, String s1) {
        return this;
    }

    public PostsListPage goToPostsListPage() {
        return new PostsListPage(driver);
    }
}
