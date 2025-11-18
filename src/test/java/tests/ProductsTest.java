package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest{

    @Test
    public void visibilityLogo() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.products();
        boolean isLogoPresent = productsPage.checkLogoLabel();
        assertTrue(isLogoPresent,"Логотип страницы не отображен");
    }

    @Test
    public void visibilityShoppingCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.products();
        boolean isShoppingCartPresent = productsPage.checkShoppingCart();
        assertTrue(isShoppingCartPresent,"Иконки корзины не отображена");
    }
}