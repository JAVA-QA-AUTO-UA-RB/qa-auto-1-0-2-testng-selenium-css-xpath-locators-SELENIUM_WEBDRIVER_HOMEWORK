import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BasicSetupTest {

    public ChromeDriver browser;

    @BeforeSuite
    public void webdriverCommonSetup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setUp() {
        browser = new ChromeDriver();
    }


    @AfterClass
    public void tearDown() {
        browser.quit();
    }
}

