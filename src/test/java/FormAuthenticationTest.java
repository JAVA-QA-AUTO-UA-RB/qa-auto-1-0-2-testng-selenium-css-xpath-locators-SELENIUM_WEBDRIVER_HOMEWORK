import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormAuthenticationTest extends BasicSetupTest{
    @Test
    public void formAuthenticationTest() throws InterruptedException {

        browser.get("https://the-internet.herokuapp.com/login");
        WebElement usernameField = browser.findElement(By.cssSelector("#username"));
        WebElement passwordField = browser.findElement(By.cssSelector("#password"));
        usernameField.sendKeys("tomsmith");
        passwordField.sendKeys("SuperSecretPassword!");
        Thread.sleep(1000);
        WebElement loginButton = browser.findElement(By.cssSelector("button[type='submit']"));
        Thread.sleep(1000);

        loginButton.click();
        Thread.sleep(1000);
        WebElement message = browser.findElement(By.cssSelector("#flash"));

        Assert.assertTrue(message.isDisplayed(), "A message about successful login should be displayed.");
        Assert.assertTrue(message.getText().contains("You logged into a secure area!"),
                "The text of the message must contain 'You logged into a secure area!'.");

        WebElement logoutButton = browser.findElement(By.cssSelector("#content > div > a"));
        Thread.sleep(1000);
        logoutButton.click();

        WebElement logoutMessage = browser.findElement(By.cssSelector("#flash"));
        Assert.assertTrue(logoutMessage.isDisplayed(), "A logout message should be displayed.");
        Assert.assertTrue(logoutMessage.getText().contains("You logged out of the secure area!"),
                "The text of the message must contain 'You logged out of the secure area!'.");
        Thread.sleep(1000);
        WebElement loginButtonAfterLogout = browser.findElement(By.cssSelector("button[type='submit']"));

        Assert.assertTrue(loginButtonAfterLogout.isDisplayed(), "Login button should be displayed after logout!");


    }
}
