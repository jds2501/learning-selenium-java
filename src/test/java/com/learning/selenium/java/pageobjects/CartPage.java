package com.learning.selenium.java.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private final By productNameText = By.cssSelector(".cartSection h3");
    private final By checkoutButton = By.xpath("//button[text()='Checkout']");
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        WebElement productName = (new WebDriverWait(this.driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(this.productNameText)));
        return productName.getText();
    }

    public void checkout() {
        this.driver.findElement(this.checkoutButton).click();
    }
}
