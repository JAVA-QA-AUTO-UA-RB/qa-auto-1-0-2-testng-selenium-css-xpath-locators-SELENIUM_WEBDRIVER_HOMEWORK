import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest extends BasicSetupTest {
	/**
	 * 6.
	 * This test navigates to the "Drag and Drop" page, drags element A to the position of element B, and verifies that they have swapped places.
	 * It also checks that both elements remain interactive after the drag-and-drop action.
	 */
	@Test
	public void dragAndDropTest() {
		browser.get("https://the-internet.herokuapp.com/drag_and_drop");

		WebElement header = browser.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
		Assert.assertEquals(header.getText(), "Drag and Drop", "The title of the page should be 'Drag and Drop'.");

		WebElement squareA = browser.findElement(By.id("column-a"));
		WebElement squareB = browser.findElement(By.id("column-b"));

		String initialTextA = squareA.getText();
		String initialTextB = squareB.getText();
		Assert.assertEquals(initialTextA, "A", "The initial text of element A should be 'A'.");
		Assert.assertEquals(initialTextB, "B", "The initial text of element B should be 'B'.");

		Actions actions = new Actions(browser);
		actions.dragAndDrop(squareA, squareB).perform();

		WebElement headerA = browser.findElement(By.xpath("//*[@id=\"column-a\"]"));
		Assert.assertEquals(headerA.getText(), "B", "Element A must swap places with element B.");

		Assert.assertTrue(squareA.isEnabled(), "Element A must remain active to interact.");
		Assert.assertTrue(squareB.isEnabled(), "Element B must remain active to interact.");
	}
}

