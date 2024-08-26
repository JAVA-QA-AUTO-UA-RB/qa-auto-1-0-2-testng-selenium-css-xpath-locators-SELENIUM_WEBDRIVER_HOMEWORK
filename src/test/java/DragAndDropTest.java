import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class DragAndDropTest extends BasicSetupTest{

    @Test
    public void dragAndDropTest() throws InterruptedException {
        browser.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement elementA = browser.findElement(By.cssSelector("#column-a"));
        Assert.assertTrue(elementA.isEnabled());
        WebElement elementB = browser.findElement(By.cssSelector("#column-b"));
//Получаем текстовое содержимое элементов
        String textElementA = elementA.getText();
        String textElementB = elementB.getText();

        Actions action = new Actions(browser);
        action.dragAndDrop(elementA,elementB).perform();

        WebElement newElementABySelectorB = browser.findElement(By.cssSelector("#column-b"));
        WebElement newElementBBySelectorA = browser.findElement(By.cssSelector("#column-a"));
        Assert.assertEquals(newElementABySelectorB .getText(), "A", "Element A on places element B");

    }
}
