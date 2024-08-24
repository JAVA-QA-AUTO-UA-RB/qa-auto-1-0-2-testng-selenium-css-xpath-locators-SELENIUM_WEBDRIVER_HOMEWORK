import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ABTestingTest extends BasicSetupTest {
	/**
	 * 1.
	 * This test opens the A/B Testing page and verifies the presence of the text "A/B Test Control" in the heading element.
	 * It checks that the element is displayed and that the text content matches the expected value.
	 */
	@Test
	public void abTestingPageHasSpecificTextTest() throws InterruptedException {
		browser.get("https://the-internet.herokuapp.com/abtest");

		WebElement abTestText = browser.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
		Assert.assertTrue(abTestText.isDisplayed(), "The text 'A/B Test Control' should be displayed on the page");

		String actualText = abTestText.getText();
		Assert.assertTrue(actualText.equals("A/B Test Control") || actualText.equals("A/B Test Variation 1"),
				"The text on the page should be either 'A/B Test Control' or 'A/B Test Variation 1'.");

	}
}
