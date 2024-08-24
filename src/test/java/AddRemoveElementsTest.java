import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class AddRemoveElementsTest extends BasicSetupTest {
	/**
	 * 2.
	 * This test opens the "Add/Remove Elements" page, adds 3 "Delete" buttons, and verifies their presence and visibility.
	 * It then removes all the "Delete" buttons and confirms that they are successfully deleted from the page.
	 */
	@Test
	public void addRemoveElementsTest() throws InterruptedException {
		browser.get("https://the-internet.herokuapp.com/add_remove_elements/");

		WebElement header = browser.findElement(By.xpath("//*[@id=\"content\"]/h3"));
		Assert.assertEquals(header.getText(), "Add/Remove Elements", "The title of the page should be 'Add/Remove Elements'.");

		WebElement addButton = browser.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
		Assert.assertTrue(addButton.isDisplayed(), "The 'Add Element' button should be visible.");
		for (int i = 0; i < 3; i++) {
			addButton.click();
		}

		List<WebElement> deleteButtons = browser.findElements(By.cssSelector("#elements > button"));
		Assert.assertEquals(deleteButtons.size(), 3, "There should be 3 delete buttons added.");

		for (WebElement deleteButton : deleteButtons) {
			Assert.assertTrue(deleteButton.isDisplayed(), "The 'Delete' button should be visible.");
			Assert.assertEquals(deleteButton.getText(), "Delete", "The text on the button should be 'Delete'.");
			deleteButton.click();
		}

		deleteButtons = browser.findElements(By.cssSelector("#elements > button"));
		Assert.assertEquals(deleteButtons.size(), 0, "All delete buttons should be removed.");
	}
}
