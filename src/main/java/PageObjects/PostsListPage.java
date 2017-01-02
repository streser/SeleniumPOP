package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by streser on 02.01.2017.
 */
public class PostsListPage extends AdminPage{
    public PostsListPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPostPublished(String title) {
        return driver.getPageSource().contains(title);
    }

    public AddNewPostPage goToAddNewPostPage() {
        click(By.linkText("Add New"));
        return new AddNewPostPage(driver);
    }
}
