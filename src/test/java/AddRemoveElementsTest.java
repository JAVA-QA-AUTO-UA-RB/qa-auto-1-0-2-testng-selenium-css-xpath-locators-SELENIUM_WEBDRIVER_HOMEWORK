import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class AddRemoveElementsTest extends BasicSetupTest {

    @Test
        public void addRemoveElementsTest() throws InterruptedException {

            browser.get("https://the-internet.herokuapp.com/add_remove_elements/");
            Thread.sleep(1000);
            // Add three "Delete" buttons
            WebElement buttonAddElements = browser.findElement(By.xpath("/html/body/div[2]/div/div/button"));
            for (int i = 0; i < 3; i++) {
                buttonAddElements.click();
            }

            List<WebElement> buttonDelete = browser.findElements(By.cssSelector("button.added-manually"));
            Assert.assertEquals(3, buttonDelete.size(),"3 delete buttons should be  added.");
            Thread.sleep(1000);

            for (WebElement element : buttonDelete) {
                WebElement deleteButton = browser.findElement(By.cssSelector("button.added-manually"));
                deleteButton.click();
                Thread.sleep(1000);
            }
            buttonDelete = browser.findElements(By.cssSelector("button.added-manually"));
            Assert.assertTrue(buttonDelete.isEmpty());
        }

}
