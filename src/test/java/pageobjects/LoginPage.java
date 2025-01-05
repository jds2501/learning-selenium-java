package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {

    private final String url = "https://rahulshettyacademy.com/client";
    private final By signInButton = By.id("login");
    private final By userEmailTextField = By.id("userEmail");
    private final By passwordTextField = By.id("userPassword");
    private final By postLoginCardBody = By.className("card-body");
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        this.driver.get(this.url);
    }

    public void validLogin(String username, String password) {
        (driver.findElement(this.userEmailTextField)).sendKeys(username);
        (driver.findElement(this.passwordTextField)).sendKeys(password);
        (driver.findElement(this.signInButton)).click();

        (new WebDriverWait(this.driver, Duration.ofSeconds(10))).until(
                ExpectedConditions.visibilityOfElementLocated(this.postLoginCardBody));
    }
}
