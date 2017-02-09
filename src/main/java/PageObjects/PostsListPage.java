package PageObjects;

import org.apache.commons.configuration.CompositeConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by streser on 02.01.2017.
 */
public class PostsListPage extends AdminPage{
    public PostsListPage(WebDriver driver,CompositeConfiguration cc) {
        super(driver,cc);
    }

    protected void cleanUpPosts() {
        boolean isAllCleaned = false;

        while (!isAllCleaned) {
            //int size = tr1.size();
            // for (int i = 0; i < size; i++) {
            List<WebElement> tr = getElementList("//tbody[@id='the-list']//tr", "xpath");
            if (tr.size() > 0) {
                System.out.println("Current list size " + tr.size());
                String actualRow = tr.get(0).getText();
                if (!actualRow.contains("No posts found")) {
                    System.out.println(actualRow);
                    WebElement input = clickWhenReady(By.xpath("(//tbody[@id='the-list']//tr)[1]"), 2);
                    WebElement mainElement = waitForElement(
                            By.xpath("(//tbody[@id='the-list']//tr)[1]//a[@class='row-title']"), 2);
                    Actions action = new Actions(driver);
                    action.moveToElement(mainElement).perform();
                    WebElement subelement = clickWhenReady(
                            By.xpath("(//tbody[@id='the-list']//tr)[1]//span[@class='trash']"), 2);
                } else {
                    isAllCleaned = true;
                    break;
                }
            }

            isAllCleaned = tr.size() == 0;
            System.out.println("Value of isAllCleaned: " + isAllCleaned);

        }
    }


    public boolean isPostPublished(String title) {
        return driver.getPageSource().contains(title);
    }

    public AddNewPostPage goToAddNewPostPage() {
        click(By.linkText("Add New"));
        return new AddNewPostPage(driver,cc);
    }


}
