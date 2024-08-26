import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BasicSetupTest{
    @Test
    public void dropdownOption2Test() throws InterruptedException {

        browser.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdown = browser.findElement(By.xpath("//*[@id=\"dropdown\"]"));
        dropdown.click();
        Thread.sleep(2000);
        WebElement option2 = browser.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]"));
        option2.click();
        Thread.sleep(2000);
        Assert.assertTrue(option2.isSelected(),"Option2 should be selected");
    }
}
