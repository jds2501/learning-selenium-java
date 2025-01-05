
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.LoginPage;

public class SampleTest {
    private WebDriver driver;

    @Before
    public void initializeSelenium() {
        driver = new ChromeDriver();
    }

    @Test
    public void loadGoogle() {
        LoginPage login = new LoginPage(driver);
        login.goTo();
        login.validLogin("descript.linking@gmail.com", "Lindy123$");
    }

    @After
    public void cleanUp() {
        // driver.quit();
    }
}
