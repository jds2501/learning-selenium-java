package com.learning.selenium.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learning.selenium.java.pageobjects.HomePage;

public class HomeTest {
    private WebDriver driver;

    @BeforeMethod
    public void initialize() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--window-size=1920,1080");
        driver = new ChromeDriver(options);
    }

    @Test
    public void loadAboutUsInDropDownMenu() {
        HomePage home = new HomePage(driver);
        home.goTo();
        home.openAboutUs();
    }
}
