package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    // By pageTitle = By.cssSelector("*[class='app_logo']");
    By shoppingCart = By.id("shopping_cart_container");

    private static final String ADD_TO_CART_BUTTON_PATTERN =
            "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    // private static final String DATA_TEST_PATTERN = "[data-test()='%s']";

    By cartBadge = By.xpath("//*[@data-test='shopping-cart-badge']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Находим иконку корзины")
    public boolean checkCart() {
        return driver.findElement(shoppingCart).isDisplayed();
    }

    @Step("Добавление товаров в корзину")
    public ProductsPage addToCart(final String goodsName) {
        By addGoodsToCart = By.xpath(ADD_TO_CART_BUTTON_PATTERN.formatted(goodsName));
        driver.findElement(addGoodsToCart).click();
        return this;
    }

    @Step("Добавление товаров в корзину")
    public ProductsPage addToCart(final int goodsOrder) {
        driver.findElements(By.xpath(TEXT_LOCATOR_PATTERN.formatted("Add to cart"))).get(goodsOrder).click();
        return this;
    }

    @Step("Сравнение количества товаров в корзине")
    public String checkGoodsQuantity() {
        return driver.findElement(cartBadge).getText();
    }

    @Step("Переход на страницу корзины")
    public ProductsPage switchToCart() {
        driver.findElement(cartBadge).click();
        return this;
    }
}