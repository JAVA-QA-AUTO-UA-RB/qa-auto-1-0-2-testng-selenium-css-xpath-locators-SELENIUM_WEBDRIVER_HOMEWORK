import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

// This test class inherits BasicSetupTest class, where the browser is initialized
// browser variable is available here as it's inherited, so you'll have it available at any place
public class ABPageTest extends BasicSetupTest {

    @Test
    public void abTestingPageHasSpecificTextTest() throws InterruptedException {
        browser.get("https://the-internet.herokuapp.com");
        //Write your code here (just an example provided)
        WebElement abTestingTaskLink = browser.findElement(By.linkText("A/B Testing"));
        abTestingTaskLink.click();
        Thread.sleep( 3000);
        // Write your assertions in the after the steps of scenario are executed to validate results
        Assert.assertTrue(true);

        WebElement abTestingPageHeader = browser.findElement((By.xpath("//*[@id=\"content\"]/div/h3")));
        String actualText = abTestingPageHeader.getText();

        Assert.assertTrue(actualText.equals("A/B Test Control") || actualText.equals("A/B Test Variation 1"),
                "The text on the page should be either 'A/B Test Control' or 'A/B Test Variation 1'.");
        WebElement abTestingPageText = browser.findElement(By.cssSelector("p"));

        String specificPageText = abTestingPageText.getText();

        assertEquals(specificPageText, "Also known as split testing. This is a way in which businesses are able to " +
                        "simultaneously test and learn different versions of a page to see which text and/or functionality works " +
                        "best towards a desired outcome (e.g. a user action such as a click-through).",
                "The text on the page should be as in the example");

    }
//

    }

    // Write the rest of TEST METHODS according to the task here, each method checking one scenario described in README.md file
    // In the end you should have a set of test methods each of them describing some specific scenario


