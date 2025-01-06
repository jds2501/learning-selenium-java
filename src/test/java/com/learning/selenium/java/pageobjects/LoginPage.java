package com.learning.selenium.java.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final String url = "https://rahulshettyacademy.com/client";
    private final By signInButton = By.id("login");
    private final By userEmailTextField = By.id("userEmail");
    private final By passwordTextField = By.id("userPassword");
    private final By startRegister = By.className("btn1");
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        this.driver.get(this.url);
    }

    public void startRegistration() {
        this.driver.findElement(this.startRegister).click();
    }

    public void validLogin(String username, String password) {
        (driver.findElement(this.userEmailTextField)).sendKeys(username);
        (driver.findElement(this.passwordTextField)).sendKeys(password);
        (driver.findElement(this.signInButton)).click();
    }
}
