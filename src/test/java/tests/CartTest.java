package tests;

import enums.TitleNaming;
import org.testng.annotations.Test;

import static enums.TitleNaming.CARTS;
import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class CartTest extends BaseTest {
    @Test(description = "Сравнение количества товара с отображением числа на корзине")
    public void checkGoodsInCart() {
        System.out.println("CartTest cart is running in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.isPageLoaded(PRODUCTS.getDisplayName());
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addToCart(1);
        assertEquals(productsPage.checkGoodsQuantity(), "3");
        // loginPage.open("cart.html");     // переход на страницу корзины по ссылке
        productsPage.switchToCart();        // переход на страницу корзины по клику на иконку
        cartPage.isPageLoaded(CARTS.getDisplayName());
        System.out.println(cartPage.getProductsNames() + "!!!!!!!!!!!!!!!!");       // вывод в печать в коде не оставляем

        assertEquals(cartPage.getProductsNames().size(), 3);
        assertFalse(cartPage.getProductsNames().isEmpty());
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Bolt T-Shirt"));
    }
}