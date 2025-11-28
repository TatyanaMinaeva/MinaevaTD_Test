package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {

    @TmsLink("MinaevaTD_Test")
    @Owner("Tatyana tg@FancySmile")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Видимость названия страницы")
    public void visibilityLogo() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        boolean isLogoPresent = productsPage.isPageLoaded("Products");
        assertTrue(isLogoPresent, "Логотип страницы не отображен");
    }

    @TmsLink("MinaevaTD_Test")
    @Owner("Tatyana tg@FancySmile")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Видимость иконки корзины")
    public void visibilityShoppingCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        boolean isShoppingCartPresent = productsPage.checkCart();
        assertTrue(isShoppingCartPresent, "Иконка корзины не отображена");
    }

    @TmsLink("MinaevaTD_Test")
    @Owner("Tatyana tg@FancySmile")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Сравнение количества товара с отображением числа на корзине")
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageLoaded("Products");
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addToCart(1);
        assertEquals(productsPage.checkGoodsQuantity(), "3");
    }
}