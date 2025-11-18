package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

    //открыть браузер
    //вводим название сайта

    @Test
    public void incorrectLogin() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        String errorText = browser.findElement(By.cssSelector("*[data-test='error']")).getText();
        assertEquals(errorText, "Epic sadface: Sorry, this user has been locked out.",
                "Сообщение об ошибке не верное");
    }

   @Test
   public void correctLogin() {
       loginPage.open();
       loginPage.login("standard_user", "secret_sauce");
       boolean isTitlePresent = browser.findElement(By.cssSelector("[data-test='title']")).isDisplayed();
       assertTrue(isTitlePresent,"Заголовок страницы не отображен");
   }
}
