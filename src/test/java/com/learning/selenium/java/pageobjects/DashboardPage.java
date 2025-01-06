package com.learning.selenium.java.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private final By productsBody = By.className("card-body");
    private final By productsBodyText = By.cssSelector(".card-body b");
    private final By cart = By.cssSelector("[routerlink='/dashboard/cart']");
    private final By buyProduct = By.cssSelector("[style='float: right;']");
    private final By buySpinner = By.className("ngx-spinner-overlay");
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean addToCart(String productName) {
        List<WebElement> productBodies = (new WebDriverWait(this.driver, Duration.ofSeconds(10))).until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(this.productsBody));

        List<WebElement> productsText = this.driver.findElements(this.productsBodyText);
        int targetProductIndex = -1;

        for (int i = 0; i < productsText.size() && targetProductIndex == -1; i++) {
            String productText = productsText.get(i).getText();

            if (productText.equals(productName)) {
                targetProductIndex = i;
            }
        }

        if (targetProductIndex != -1) {
            productBodies.get(targetProductIndex).findElement(this.buyProduct).click();
            (new WebDriverWait(this.driver, Duration.ofSeconds(10))).until(
                    ExpectedConditions.visibilityOfElementLocated(this.buySpinner));
            (new WebDriverWait(this.driver, Duration.ofSeconds(10))).until(
                    ExpectedConditions.invisibilityOfElementLocated(this.buySpinner));
        }

        return targetProductIndex != -1;
    }

    public void navigateToCart() {
        this.driver.findElement(this.cart).click();
    }
}
