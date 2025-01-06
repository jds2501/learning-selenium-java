package com.learning.selenium.java;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.learning.selenium.java.pageobjects.DashboardPage;
import com.learning.selenium.java.pageobjects.LoginPage;

public class SeleniumPracticeTest {
    private WebDriver driver;

    @Before
    public void initializeSelenium() {
        driver = new ChromeDriver();
    }

    @Test
    public void seleniumPracticeTest() {
        LoginPage login = new LoginPage(driver);
        login.goTo();
        login.validLogin("descript.linking@gmail.com", "Lindy123$");

        DashboardPage dashboard = new DashboardPage(driver);
        assertTrue(dashboard.addToCart("IPHONE 13 PRO"));
        dashboard.navigateToCart();
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
