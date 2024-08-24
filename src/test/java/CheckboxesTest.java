import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest extends BasicSetupTest {
	/**
	 * 3.
	 * This test navigates to the "Checkboxes" page and ensures that all checkboxes are set to the "checked" position.
	 * It verifies that both checkboxes are selected and have the "checked" attribute properly set.
	 */
	@Test
	public void checkboxesSelectedTest() {
		browser.get("https://the-internet.herokuapp.com/checkboxes");

		WebElement header = browser.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
		Assert.assertEquals(header.getText(), "Checkboxes", "The title of the page should be 'Checkboxes'.");

		WebElement checkbox1 = browser.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(1)"));
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
