package SeleniumTests;

import PageObjects.*;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertTrue;

/**
 * Created by streser on 02.01.2017.
 */
public class PostsTest extends SeleniumTest {
    private String postTitle;
    private String postContent;

    @Before
    public void generateTestData() {
        UUID uuid = UUID.randomUUID();
        postTitle = "Post Title" + uuid.toString();
        postContent = "Post Content" + uuid.toString();
    }

    @Test
    public void shouldBePossibleToAddNewPost() {
        LoginPage lp = new LoginPage(driver);
        lp.open();
        DashboardPage dp = lp.logIn();
        PostsListPage plp = dp.goToPostsListPage();
        AddNewPostPage anpp = plp.goToAddNewPostPage();

        anpp.addNewPost(postTitle, postContent);

        plp = anpp.goToPostsListPage();
        assertTrue(plp.isPostPublished(postTitle));
        lp = plp.logOut();


        BlogPage bp = lp.goToBlogPage();
        assertTrue(bp.isPostPublished(postTitle));
    }
}
