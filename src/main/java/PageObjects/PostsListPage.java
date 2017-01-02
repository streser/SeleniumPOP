package PageObjects;

import org.openqa.selenium.WebDriver;

/**
 * Created by streser on 02.01.2017.
 */
public class PostsListPage extends Page{
    public PostsListPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPostPublished(String s) {
        return false;
    }

    public BlogPage goToBlogPage() {
        return new BlogPage(driver);
    }
}
