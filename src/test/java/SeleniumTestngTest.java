import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumTestngTest extends BasicSetupTest {

    private String deleteButton = "button.added-manually";

    @Test
    public void abTestingPageHasSpecificTextTest() throws InterruptedException {
        browser.get("https://the-internet.herokuapp.com/abtest");
        WebElement abTestingTaskLink = browser.findElement(By.cssSelector("#content > div > h3"));
        String expectedText = "A/B Test";
        Assert.assertTrue(abTestingTaskLink.getText().contains(expectedText),
                "Expected text is not present in the element");
    }

    @Test
    public void addRemoveElementsPageVerifyDeleteButton() throws InterruptedException {
        browser.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElementButton = browser.findElement(By.cssSelector("div.example>button"));
        addElementButton.click();
        addElementButton.click();
        addElementButton.click();
        WebElement presenceAndVisibilityButton = browser.findElement(By.cssSelector(deleteButton));
        Assert.assertTrue(presenceAndVisibilityButton.isDisplayed());
        presenceAndVisibilityButton.click();
        presenceAndVisibilityButton = browser.findElement(By.cssSelector(deleteButton));
        presenceAndVisibilityButton.click();
        presenceAndVisibilityButton = browser.findElement(By.cssSelector(deleteButton));
        presenceAndVisibilityButton.click();
        List<WebElement> deleteButtonElements = browser.findElements(By.cssSelector(deleteButton));
        Assert.assertTrue(deleteButtonElements.isEmpty(), "One or more button is on the page");
    }

    @Test
    public void checkBoxesPageCheckboxesTesting() {
        browser.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = browser.findElements(By.cssSelector("form#checkboxes > input"));
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(checkbox.isSelected(), "Not all checkboxes are checked");
        }
    }

    @Test
    public void dropdownPageDropdownTesting() {
        browser.get("https://the-internet.herokuapp.com/dropdown");
        Select dropDown = new Select(browser.findElement(By.id("dropdown")));
        dropDown.selectByIndex(2);
        WebElement selectedOption = dropDown.getFirstSelectedOption();
        String selectedText = selectedOption.getText();
        Assert.assertEquals(selectedText, "Option 2", "The selected option is not 'Option 2'");
    }

    @Test
    public void loginPageTestValidLoginAndLogoutFunctionality() {
        browser.get(("https://the-internet.herokuapp.com/login"));
        WebElement usernameInput = browser.findElement(By.id("username"));
        usernameInput.clear();
        String username = "tomsmith";
        usernameInput.sendKeys(username);
        WebElement passwordInput = browser.findElement(By.id("password"));
        passwordInput.clear();
        String password = "SuperSecretPassword!";
        passwordInput.sendKeys(password);
        WebElement loginButton = browser.findElement(By.cssSelector("#login > button"));
        loginButton.click();
        WebElement logoutButton = browser.findElement(By.cssSelector("#content > div > a"));
        Assert.assertTrue(logoutButton.isDisplayed(), "Login was not successful or Logout button is not visible.");
        logoutButton.click();
        WebElement loginButton1 = browser.findElement(By.cssSelector("#login > button"));
        Assert.assertTrue(loginButton1.isDisplayed());
    }

    @Test
    public void dragAndDropPageSwapElementsAAndB() {
        browser.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement elementA = browser.findElement(By.id("column-a"));
        WebElement elementB = browser.findElement(By.id("column-b"));
        Actions actions = new Actions(browser);
        actions.dragAndDrop(elementA, elementB).perform();
        String textInElementA = browser.findElement(By.id("column-a")).getText();
        String textInElementB = browser.findElement(By.id("column-b")).getText();
        Assert.assertEquals(textInElementA, "B", "Element A was not swapped to position of B");
        Assert.assertEquals(textInElementB, "A", "Element B was not swapped to position of A");
    }

    @Test
    public void horizontalSliderPageSetAndVerifyValue() {
        browser.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = browser.findElement(By.cssSelector("#content > div > div > input[type=range]"));
        WebElement sliderValue = browser.findElement(By.id("range"));
        String targetValue = "2.5";
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("arguments[0].value = arguments[1];", slider, targetValue);
        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", slider);
        String finalValue = sliderValue.getText();
        Assert.assertNotEquals(finalValue, "0", "Slider value should be more than 0");
    }
}

