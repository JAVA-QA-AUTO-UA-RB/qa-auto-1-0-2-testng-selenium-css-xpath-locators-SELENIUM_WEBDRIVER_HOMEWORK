//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import java.util.List;
//
//// This test class inherits BasicSetupTest class, where the browser is initialized
//// browser variable is available here as it's inherited, so you'll have it available at any place
//public class SeleniumTestngTest extends BasicSetupTest {
//
//    /**
//     * 1.
//     * This test opens the A/B Testing page and verifies the presence of the text "A/B Test Control" in the heading element.
//     * It checks that the element is displayed and that the text content matches the expected value.
//     */
//    @Test
//    public void abTestingPageHasSpecificTextTest() throws InterruptedException {
//        browser.get("https://the-internet.herokuapp.com/abtest");
//
//        WebElement abTestText = browser.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
//        Assert.assertTrue(abTestText.isDisplayed(), "The text 'A/B Test Control' should be displayed on the page");
//
//        String actualText = abTestText.getText();
//        Assert.assertEquals(actualText, "A/B Test Control", "The text on the page should be 'A/B Test Control'.");
//    }
//
//    /**
//     * 2.
//     * This test opens the "Add/Remove Elements" page, adds 3 "Delete" buttons, and verifies their presence and visibility.
//     * It then removes all the "Delete" buttons and confirms that they are successfully deleted from the page.
//     */
//    @Test
//    public void addRemoveElementsTest() throws InterruptedException {
//        browser.get("https://the-internet.herokuapp.com/add_remove_elements/");
//
//        WebElement header = browser.findElement(By.xpath("//*[@id=\"content\"]/h3"));
//        Assert.assertEquals(header.getText(), "Add/Remove Elements", "The title of the page should be 'Add/Remove Elements'.");
//
//        WebElement addButton = browser.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
//        Assert.assertTrue(addButton.isDisplayed(), "The 'Add Element' button should be visible.");
//        for (int i = 0; i < 3; i++) {
//            addButton.click();
//        }
//
//        List<WebElement> deleteButtons = browser.findElements(By.cssSelector("#elements > button"));
//        Assert.assertEquals(deleteButtons.size(), 3, "There should be 3 delete buttons added.");
//
//        for (WebElement deleteButton : deleteButtons) {
//            Assert.assertTrue(deleteButton.isDisplayed(), "The 'Delete' button should be visible.");
//        }
//
//        for (WebElement deleteButton : deleteButtons) {
//            Assert.assertEquals(deleteButton.getText(), "Delete", "The text on the button should be 'Delete'.");
//        }
//
//        for (WebElement deleteButton : deleteButtons) {
//            deleteButton.click();
//        }
//
//        deleteButtons = browser.findElements(By.cssSelector("#elements > button"));
//        Assert.assertEquals(deleteButtons.size(), 0, "All delete buttons should be removed.");
//    }
//
//    /**
//     * 3.
//     * This test navigates to the "Checkboxes" page and ensures that all checkboxes are set to the "checked" position.
//     * It verifies that both checkboxes are selected and have the "checked" attribute properly set.
//     */
//    @Test
//    public void checkboxesSelectedTest() {
//        browser.get("https://the-internet.herokuapp.com/checkboxes");
//
//        WebElement header = browser.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
//        Assert.assertEquals(header.getText(), "Checkboxes", "The title of the page should be 'Checkboxes'.");
//
//        WebElement checkbox1 = browser.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(1)"));
//        WebElement checkbox2 = browser.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(3)"));
//
//        if (!checkbox1.isSelected()) {
//            checkbox1.click();
//        }
//
//        if (!checkbox2.isSelected()) {
//            checkbox2.click();
//        }
//
//        Assert.assertTrue(checkbox1.isSelected(), "The first checkbox should be selected.");
//        Assert.assertTrue(checkbox2.isSelected(), "The second checkbox should be selected.");
//
//        String checkbox1Attribute = checkbox1.getAttribute("checked");
//        String checkbox2Attribute = checkbox2.getAttribute("checked");
//        Assert.assertEquals(checkbox1Attribute, "true", "The 'checked' attribute must be set for the first checkbox.");
//        Assert.assertEquals(checkbox2Attribute, "true", "The 'checked' attribute must be set for the second checkbox.");
//    }
//
//    /**
//     * 4.
//     * This test navigates to the "Dropdown" page, selects "Option 2" from the dropdown list, and verifies that it is correctly selected.
//     * It also checks that the dropdown remains accessible after the selection is made.
//     */
//    @Test
//    public void dropdownSelectedTest() {
//        browser.get("https://the-internet.herokuapp.com/dropdown");
//
//        WebElement header = browser.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
//        Assert.assertEquals(header.getText(), "Dropdown List", "The title of the page should be 'Dropdown List'.");
//
//        WebElement dropdown = browser.findElement(By.cssSelector("#dropdown"));
//        Assert.assertTrue(dropdown.isDisplayed(), "The dropdown list should be displayed on the page.");
//
//        WebElement defaultOption = browser.findElement(By.xpath("//*[@id=\"dropdown\"]/option[@selected]"));
//        Assert.assertEquals(defaultOption.getText(), "Please select an option", "'Please select an option' should be selected by default.");
//
//        dropdown.click();
//        WebElement option2 = browser.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]"));
//        option2.click();
//
//        Assert.assertTrue(option2.isSelected(), "The option 'Option 2' must be selected.");
//        Assert.assertTrue(dropdown.isEnabled(), "The dropdown list should remain active after selecting the option.");
//    }
//
//    /**
//     * 5.
//     * This test navigates to the "Form Authentication" page, enters valid credentials, and verifies successful login.
//     * It then logs out of the system and confirms that the user is successfully logged out, with the login button becoming available again.
//     */
//    @Test
//    public void formAuthenticationTest() {
//        browser.get("https://the-internet.herokuapp.com/login");
//
//        WebElement header = browser.findElement(By.xpath("//*[@id=\"content\"]/div/h2"));
//        Assert.assertEquals(header.getText(), "Login Page", "The title of the page should be 'Login Page'.");
//
//        WebElement usernameField = browser.findElement(By.id("username"));
//        WebElement passwordField = browser.findElement(By.id("password"));
//        Assert.assertTrue(usernameField.isDisplayed(), "The login field must be displayed.");
//        Assert.assertTrue(passwordField.isDisplayed(), "The password field must be displayed.");
//
//        usernameField.sendKeys("tomsmith");
//        passwordField.sendKeys("SuperSecretPassword!");
//
//        WebElement loginButton = browser.findElement(By.cssSelector("#login > button"));
//        Assert.assertTrue(loginButton.isDisplayed(), "The login button should be displayed.");
//
//        loginButton.click();
//
//        WebElement successMessage = browser.findElement(By.cssSelector("#flash"));
//        Assert.assertTrue(successMessage.isDisplayed(), "A message about successful login should be displayed.");
//        Assert.assertTrue(successMessage.getText().contains("You logged into a secure area!"),
//                "The text of the message must contain 'You logged into a secure area!'.");
//
//        WebElement entryHeader = browser.findElement(By.xpath("//*[@id=\"content\"]/div/h2"));
//        Assert.assertEquals(entryHeader.getText(), "Secure Area", "The title of the page should be 'Secure Area'.");
//
//        WebElement logoutButton = browser.findElement(By.cssSelector("#content > div > a"));
//        Assert.assertTrue(logoutButton.isDisplayed(), "The 'Logout' button should be displayed after logging in.");
//        Assert.assertEquals(logoutButton.getText(), "Logout", "The text on the button should be 'Logout'.");
//
//        logoutButton.click();
//
//        WebElement logoutMessage = browser.findElement(By.cssSelector("#flash"));
//        Assert.assertTrue(logoutMessage.isDisplayed(), "A logout message should be displayed.");
//        Assert.assertTrue(logoutMessage.getText().contains("You logged out of the secure area!"),
//                "The text of the message must contain 'You logged out of the secure area!'.");
//
//        WebElement loginButtonAfterLogout = browser.findElement(By.cssSelector("#login > button"));
//        Assert.assertTrue(loginButtonAfterLogout.isDisplayed(), "The login button should be displayed after logging out.");
//    }
//
//    /**
//     * 6.
//     * This test navigates to the "Drag and Drop" page, drags element A to the position of element B, and verifies that they have swapped places.
//     * It also checks that both elements remain interactive after the drag-and-drop action.
//     */
//    @Test
//    public void dragAndDropTest() {
//        browser.get("https://the-internet.herokuapp.com/drag_and_drop");
//
//        WebElement header = browser.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
//        Assert.assertEquals(header.getText(), "Drag and Drop", "The title of the page should be 'Drag and Drop'.");
//
//        WebElement squareA = browser.findElement(By.id("column-a"));
//        WebElement squareB = browser.findElement(By.id("column-b"));
//
//        String initialTextA = squareA.getText();
//        String initialTextB = squareB.getText();
//        Assert.assertEquals(initialTextA, "A", "The initial text of element A should be 'A'.");
//        Assert.assertEquals(initialTextB, "B", "The initial text of element B should be 'B'.");
//
//        Actions actions = new Actions(browser);
//        actions.dragAndDrop(squareA, squareB).perform();
//
//        WebElement headerA = browser.findElement(By.xpath("//*[@id=\"column-a\"]"));
//        Assert.assertEquals(headerA.getText(), "B", "Element A must swap places with element B.");
//
//        Assert.assertTrue(squareA.isEnabled(), "Element A must remain active to interact.");
//        Assert.assertTrue(squareB.isEnabled(), "Element B must remain active to interact.");
//    }
//
//    /**
//     * 7.
//     * This test navigates to the "Horizontal Slider" page, moves the slider to a position different from 0, specifically to 3,
//     * and verifies that the slider's value has changed to the desired position.
//     * It also checks that the slider remains visible and interactive after the adjustment.
//     */
//    @Test
//    public void horizontalSliderMoveTest() {
//        browser.get("https://the-internet.herokuapp.com/horizontal_slider");
//
//        WebElement header = browser.findElement(By.xpath("//*[@id=\"content\"]/div/h3"));
//        Assert.assertEquals(header.getText(), "Horizontal Slider", "The title of the page should be 'Horizontal Slider'.");
//
//        WebElement slider = browser.findElement(By.cssSelector("#content > div > div > input[type=range]"));
//        WebElement rangeValue = browser.findElement(By.id("range"));
//
//        String initialValue = rangeValue.getText();
//        Assert.assertEquals(initialValue, "0", "Початкове значення слайдера має бути '0'.");
//
//        Actions actions = new Actions(browser);
//        while (!rangeValue.getText().equals("3")) {
//            actions.clickAndHold(slider).sendKeys(Keys.ARROW_RIGHT).release().perform();
//        }
//
//        String currentValue = rangeValue.getText();
//        Assert.assertEquals(currentValue, "3", "The value of the slider should be '3' after the moving.");
//
//        Assert.assertTrue(slider.isDisplayed(), "The slider should be displayed on the page.");
//        Assert.assertTrue(slider.isEnabled(), "The slider should be available for interaction.");
//    }
//}