package com.learning.selenium.java;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.learning.selenium.java.pageobjects.HomePage;

public class HomeTest {
    private WebDriver driver;

    @Before
    public void initialize() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--window-size=1920,1080");
        driver = new ChromeDriver();
    }

    @Test
    public void loadAboutUsInDropDownMenu() {
        HomePage home = new HomePage(driver);
        home.goTo();
        home.openAboutUs();
    }
}
