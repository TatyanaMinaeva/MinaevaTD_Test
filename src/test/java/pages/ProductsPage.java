package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    By pageTitle = By.cssSelector("*[class='app_logo']");
    By shoppingCart = By.id("shopping_cart_container");

    private static final String ADD_TO_CART_BUTTON_PATTERN =
            "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";

    // private static final String TEXT_PATTERN = "//*[text()='%s']";
    // private static final String DATA_TEST_PATTERN = "[data-test()='%s']";

    By cartBadge = By.xpath("//*[@data-test='shopping-cart-badge']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void products() {
        isPageLoaded();
        checkCart();
    }

    @Step("Находим название страницы Products")
    public boolean isPageLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        return driver.findElement(pageTitle).isDisplayed();
    }

    @Step("Находим иконку корзины")
    public boolean checkCart() {
        return driver.findElement(shoppingCart).isDisplayed();
    }

    public void addToCart(final String goodsName) {
        By addGoodsToCart = By.xpath(ADD_TO_CART_BUTTON_PATTERN.formatted(goodsName));
        driver.findElement(addGoodsToCart).click();
    }

    public String checkGoodsQuantity() {
        return driver.findElement(cartBadge).getText();
    }
}