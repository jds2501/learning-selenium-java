import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {
    private WebDriver driver;

    @Before
    public void initializeSelenium() {
        driver = new ChromeDriver();
    }

    @Test
    public void loadGoogle() {
        driver.get("https://www.google.com");
        assertEquals("Google", driver.getTitle());
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
