import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BasicSetupTest {
	/**
	 * 4.
	 * This test navigates to the "Dropdown" page, selects "Option 2" from the dropdown list, and verifies that it is correctly selected.
	 * It also checks that the dropdown remains accessible after the selection is made.
	 */
	@Test
	public void dropdownSelectedTest() {
		browser.get("https://the-internet.herokuapp.com/dropdown");

		WebElement header = browser.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
		Assert.assertEquals(header.getText(), "Dropdown List", "The title of the page should be 'Dropdown List'.");

		WebElement dropdown = browser.findElement(By.cssSelector("#dropdown"));
		Assert.assertTrue(dropdown.isDisplayed(), "The dropdown list should be displayed on the page.");

		WebElement defaultOption = browser.findElement(By.xpath("//*[@id=\"dropdown\"]/option[@selected]"));
		Assert.assertEquals(defaultOption.getText(), "Please select an option", "'Please select an option' should be selected by default.");

		dropdown.click();
		WebElement option2 = browser.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]"));
		option2.click();

		Assert.assertTrue(option2.isSelected(), "The option 'Option 2' must be selected.");
		Assert.assertTrue(dropdown.isEnabled(), "The dropdown list should remain active after selecting the option.");
	}
}
