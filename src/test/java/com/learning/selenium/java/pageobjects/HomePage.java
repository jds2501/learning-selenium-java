package com.learning.selenium.java.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final String url = "https://rahulshettyacademy.com/";
    private final By menuDropDown = By.cssSelector("div[class='nav-outer clearfix'] a[class='dropdown-toggle']");
    private final By aboutUs = By.cssSelector("li[class='dropdown open']  a[href='about-my-mission']");
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        this.driver.get(url);
    }

    public void openAboutUs() {
        WebElement dropdownAvailable = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(
                ExpectedConditions.visibilityOfElementLocated(menuDropDown));
        dropdownAvailable.click();

        WebElement aboutUsAvailable = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(
                ExpectedConditions.visibilityOfElementLocated(aboutUs));
        aboutUsAvailable.click();
    }
}
