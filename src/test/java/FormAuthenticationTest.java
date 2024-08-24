import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormAuthenticationTest extends BasicSetupTest {
	/**
	 * 5.
	 * This test navigates to the "Form Authentication" page, enters valid credentials, and verifies successful login.
	 * It then logs out of the system and confirms that the user is successfully logged out, with the login button becoming available again.
	 */
	@Test
	public void formAuthenticationTest() {
		browser.get("https://the-internet.herokuapp.com/login");

		WebElement header = browser.findElement(By.xpath("//*[@id=\"content\"]/div/h2"));
		Assert.assertEquals(header.getText(), "Login Page", "The title of the page should be 'Login Page'.");

		WebElement usernameField = browser.findElement(By.id("username"));
		WebElement passwordField = browser.findElement(By.id("password"));
		Assert.assertTrue(usernameField.isDisplayed(), "The login field must be displayed.");
		Assert.assertTrue(passwordField.isDisplayed(), "The password field must be displayed.");

		usernameField.sendKeys("tomsmith");
		passwordField.sendKeys("SuperSecretPassword!");

		WebElement loginButton = browser.findElement(By.cssSelector("#login > button"));
		Assert.assertTrue(loginButton.isDisplayed(), "The login button should be displayed.");
		loginButton.click();

		WebElement successMessage = browser.findElement(By.cssSelector("#flash"));
		Assert.assertTrue(successMessage.isDisplayed(), "A message about successful login should be displayed.");
		Assert.assertTrue(successMessage.getText().contains("You logged into a secure area!"),
				"The text of the message must contain 'You logged into a secure area!'.");

		WebElement entryHeader = browser.findElement(By.xpath("//*[@id=\"content\"]/div/h2"));
		Assert.assertEquals(entryHeader.getText(), "Secure Area", "The title of the page should be 'Secure Area'.");

		WebElement logoutButton = browser.findElement(By.cssSelector("#content > div > a"));
		Assert.assertTrue(logoutButton.isDisplayed(), "The 'Logout' button should be displayed after logging in.");
		Assert.assertEquals(logoutButton.getText(), "Logout", "The text on the button should be 'Logout'.");
		logoutButton.click();

		WebElement logoutMessage = browser.findElement(By.cssSelector("#flash"));
		Assert.assertTrue(logoutMessage.isDisplayed(), "A logout message should be displayed.");
		Assert.assertTrue(logoutMessage.getText().contains("You logged out of the secure area!"),
				"The text of the message must contain 'You logged out of the secure area!'.");

		WebElement loginButtonAfterLogout = browser.findElement(By.cssSelector("#login > button"));
		Assert.assertTrue(loginButtonAfterLogout.isDisplayed(), "The login button should be displayed after logging out.");
	}
}
