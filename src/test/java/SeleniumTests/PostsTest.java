package SeleniumTests;

import PageObjects.DashboardPage;
import PageObjects.LoginPage;
import org.junit.Test;

/**
 * Created by streser on 02.01.2017.
 */
public class PostsTest extends SeleniumTest {
    @Test
    public void shouldBePossibleToAddNewPost() {
        LoginPage lp = new LoginPage(driver);
        lp.open();
        DashboardPage dp = lp.logIn();
        AddNewPostPage anpp = dp.goToAddNewPostPage();

        anpp.addNewPost("Post Title", "Post Content");

        PostsListPage plp = anpp.goToPostsListPage();
        assertTrue(plp.isPostPublished("Post Title"));
        BlogPage bp = plp.goToBlogPage();
        assertTrue(bp.isPostPublished("Post Title"));
    }
}
