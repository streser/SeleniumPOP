package PageObjects;

import org.openqa.selenium.WebDriver;

/**
 * Created by streser on 02.01.2017.
 */
public abstract class AdminPage extends Page{
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public AddNewPostPage goToAddNewPostPage() {
        return new AddNewPostPage(driver);
    }

    public BlogPage goToBlogPage() {
        return new BlogPage(driver);
    }

    public PostsListPage goToPostsListPage() {
        return new PostsListPage(driver);
    }
}
