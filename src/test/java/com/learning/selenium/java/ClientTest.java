package com.learning.selenium.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learning.selenium.java.pageobjects.CartPage;
import com.learning.selenium.java.pageobjects.CheckoutPage;
import com.learning.selenium.java.pageobjects.DashboardPage;
import com.learning.selenium.java.pageobjects.LoginPage;

import static org.testng.Assert.assertTrue;

public class ClientTest {
    private WebDriver driver;
    private final String username = "descript.linking@gmail.com";
    private final String password = System.getenv("RAHUL_PASSWORD");
    private final String country = "United States";
    private final String coupon = "rahulshettyacademy";

    @BeforeMethod
    public void initializeSelenium() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--window-size=1920,1080");
        driver = new ChromeDriver(options);
    }

    @Test
    public void registerAccountTest() {
        LoginPage login = new LoginPage(driver);
        login.goTo();
        login.startRegistration();
    }

    @Test
    public void buyAndCheckoutTest() {
        ClassLoader classLoader = ClientTest.class.getClassLoader();
        File config = new File(classLoader.getResource("config.json").getFile());
        String productName = null;

        try {
            FileInputStream fis = new FileInputStream(config);
            JSONTokener tokener = new JSONTokener(fis);
            JSONObject jsonObject = new JSONObject(tokener);
            productName = jsonObject.getString("productName");
        } catch (FileNotFoundException err) {
            System.err.println("Failed to load config.json");
            System.exit(1);
        }

        LoginPage login = new LoginPage(driver);
        login.goTo();
        login.validLogin(this.username, this.password);

        DashboardPage dashboard = new DashboardPage(driver);
        assertTrue(dashboard.addToCart(productName));
        dashboard.navigateToCart();

        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.getProductName().equals(productName));
        cartPage.checkout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        assertTrue(checkoutPage.getShippingEmail().equals(this.username));
        assertTrue(checkoutPage.getProductName().equals(productName));
        assertTrue(checkoutPage.getQuantity().contains("1"));

        assertTrue(checkoutPage.selectShippingCountry(this.country));

        checkoutPage.applyCoupon(this.coupon);
        assertTrue(checkoutPage.getCouponAppliedText().contains("Coupon Applied"));

        checkoutPage.placeOrder();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
