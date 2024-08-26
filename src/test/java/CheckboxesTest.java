import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
public class CheckboxesTest extends BasicSetupTest {
    @Test
    public void checkboxesElementsTest() throws InterruptedException {

        browser.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = browser.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement checkbox2 = browser.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(3)"));

        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }

        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }
        Assert.assertTrue(checkbox1.isSelected(), "The first checkbox should be selected.");
        Assert.assertTrue(checkbox2.isSelected(), "The second checkbox should be selected.");

        String checkbox1Attribute = checkbox1.getAttribute("checked");
        String checkbox2Attribute = checkbox2.getAttribute("checked");
        Assert.assertEquals(checkbox1Attribute, "true", "The 'checked' attribute must be set for the first checkbox.");
        Assert.assertEquals(checkbox2Attribute, "true", "The 'checked' attribute must be set for the second checkbox.");
    }
}