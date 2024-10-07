package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    // Locators
    By firstProductAddToCartButton = By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']");
    By cartButton = By.className("shopping_cart_link");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void addFirstProductToCart() {
        driver.findElement(firstProductAddToCartButton).click();
    }

    public void goToCart() {
        driver.findElement(cartButton).click();
    }
}
