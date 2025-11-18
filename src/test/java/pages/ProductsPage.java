package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver browser;
    By logoLabel = By.cssSelector("*[class='app_logo']");
    By shoppingCart = By.id("shopping_cart_container");

    public ProductsPage(WebDriver browser) {
        this.browser = browser;
    }

    public void products() {
        checkLogoLabel();
        checkShoppingCart();
    }

    public boolean checkLogoLabel() {
        return browser.findElement(logoLabel).isDisplayed();
    }

    public boolean checkShoppingCart() {
        return browser.findElement(shoppingCart).isDisplayed();
    }
}
