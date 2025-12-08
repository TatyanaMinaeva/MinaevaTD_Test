package tests;

import enums.TitleNaming;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class ProductsTest extends BaseTest {

    @TmsLink("MinaevaTD_Test")
    @Owner("Tatyana tg@FancySmile")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Видимость названия страницы")
    public void visibilityLogo() {
        System.out.println("ProductsTest visprod is running in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(withAdminPermission());
        boolean isLogoPresent = productsPage.isPageLoaded(PRODUCTS.getDisplayName());
        assertTrue(isLogoPresent, "Логотип страницы не отображен");
    }

    @TmsLink("MinaevaTD_Test")
    @Owner("Tatyana tg@FancySmile")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Видимость иконки корзины")
    public void visibilityShoppingCart() {
        System.out.println("ProductsTest viscart is running in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(withAdminPermission());
        boolean isShoppingCartPresent = productsPage.checkCart();
        assertTrue(isShoppingCartPresent, "Иконка корзины не отображена");
    }

    @TmsLink("MinaevaTD_Test")
    @Owner("Tatyana tg@FancySmile")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Сравнение количества товара с отображением числа на корзине")
    public void checkGoodsAdded() {
        System.out.println("ProductsTest cart is running in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.isPageLoaded(PRODUCTS.getDisplayName());
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addToCart(1);
        assertEquals(productsPage.checkGoodsQuantity(), "3");
    }
}