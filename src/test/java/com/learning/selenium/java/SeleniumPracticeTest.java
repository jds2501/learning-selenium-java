package com.learning.selenium.java;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.learning.selenium.java.pageobjects.CartPage;
import com.learning.selenium.java.pageobjects.CheckoutPage;
import com.learning.selenium.java.pageobjects.DashboardPage;
import com.learning.selenium.java.pageobjects.LoginPage;

public class SeleniumPracticeTest {
    private WebDriver driver;
    private final String productName = "IPHONE 13 PRO";
    private final String username = "descript.linking@gmail.com";
    private final String password = "Lindy123$";
    private final String country = "United States";
    private final String coupon = "rahulshettyacademy";

    @Before
    public void initializeSelenium() {
        driver = new ChromeDriver();
    }

    @Test
    public void seleniumPracticeTest() {
        LoginPage login = new LoginPage(driver);
        login.goTo();
        login.validLogin(this.username, this.password);

        DashboardPage dashboard = new DashboardPage(driver);
        assertTrue(dashboard.addToCart(this.productName));
        dashboard.navigateToCart();

        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.getProductName().equals(this.productName));
        cartPage.checkout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        assertTrue(checkoutPage.getShippingEmail().equals(this.username));
        assertTrue(checkoutPage.getProductName().equals(this.productName));
        assertTrue(checkoutPage.getQuantity().contains("1"));

        assertTrue(checkoutPage.selectShippingCountry(this.country));

        checkoutPage.applyCoupon(this.coupon);
        assertTrue(checkoutPage.getCouponAppliedText().contains("Coupon Applied"));

        checkoutPage.placeOrder();
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
