import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSliderTest extends BasicSetupTest {
    @Test
    public void horizontalSliderTest() throws InterruptedException {
        browser.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = browser.findElement(By.xpath("//*[@id=\"content\"]/div/div/input"));
        WebElement value = browser.findElement(By.cssSelector("#range"));


        while (!value.getText().equals("4.5")) {
            slider.sendKeys(Keys.ARROW_RIGHT);
            Thread.sleep(500);
        }

            String currentValue = value.getText();
            Assert.assertEquals(currentValue, "4.5", "The value is not '4.5' after the moving.");
    }
}
