import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSliderTest extends BasicSetupTest {
	/**
	 * 7.
	 * This test navigates to the "Horizontal Slider" page, moves the slider to a position different from 0, specifically to 3,
	 * and verifies that the slider's value has changed to the desired position.
	 * It also checks that the slider remains visible and interactive after the adjustment.
	 */
	@Test
	public void horizontalSliderMoveTest() {
		browser.get("https://the-internet.herokuapp.com/horizontal_slider");

		WebElement header = browser.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
		Assert.assertEquals(header.getText(), "Horizontal Slider", "The title of the page should be 'Horizontal Slider'.");

		WebElement slider = browser.findElement(By.cssSelector("#content > div > div > input[type=range]"));
		WebElement rangeValue = browser.findElement(By.id("range"));

		String initialValue = rangeValue.getText();
		Assert.assertEquals(initialValue, "0", "The initial value of the slider should be '0'.");

		Actions actions = new Actions(browser);
		while (!rangeValue.getText().equals("3")) {
			actions.clickAndHold(slider).sendKeys(Keys.ARROW_RIGHT).release().perform();
		}

		String currentValue = rangeValue.getText();
		Assert.assertEquals(currentValue, "3", "The value of the slider should be '3' after the moving.");

		Assert.assertTrue(slider.isDisplayed(), "The slider should be displayed on the page.");
		Assert.assertTrue(slider.isEnabled(), "The slider should be available for interaction.");
	}
}
