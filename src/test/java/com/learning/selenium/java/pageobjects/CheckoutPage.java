package com.learning.selenium.java.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    private final By shippingEmail = By.cssSelector("[style='color: lightgray; font-weight: 600;']");
    private final By productName = By.cssSelector(".item__title");
    private final By productQuantity = By.cssSelector(".item__quantity");
    private final By shippingCountry = By.cssSelector("[placeholder='Select Country']");
    private final By couponText = By.cssSelector("[name='coupon']");
    private final By submitCoupon = By.cssSelector("button[type='submit']");
    private final By couponApplied = By.cssSelector(".mt-1.ng-star-inserted");
    private final By placeOrderButton = By.cssSelector(".btnn.action__submit.ng-star-inserted");
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getShippingEmail() {
        WebElement shippingEmailField = (new WebDriverWait(this.driver, Duration.ofSeconds(10))).until(
                ExpectedConditions.visibilityOfElementLocated(this.shippingEmail));
        return shippingEmailField.getText();
    }

    public String getProductName() {
        WebElement productNameField = (new WebDriverWait(this.driver, Duration.ofSeconds(10))).until(
                ExpectedConditions.visibilityOfElementLocated(this.productName));
        return productNameField.getText();
    }

    public String getQuantity() {
        WebElement productQuantityField = (new WebDriverWait(this.driver, Duration.ofSeconds(10))).until(
                ExpectedConditions.visibilityOfElementLocated(this.productQuantity));
        return productQuantityField.getText();
    }
}
