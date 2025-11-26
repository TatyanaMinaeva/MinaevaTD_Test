package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @TmsLink("MinaevaTD_Test")
    @Owner("Tatyana tg@FancySmile")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Проверка текста ошибки входы заблокированного пользователя")
    public void incorrectLogin() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertTrue(loginPage.isErrorMsgAppear(), "Сообщение об ошибке не появляется");
        assertEquals(loginPage.errorMsgText(), "Epic sadface: Sorry, this user has been locked out.",
                "Сообщение об ошибке не верное");
    }

    @TmsLink("MinaevaTD_Test")
    @Owner("Tatyana tg@FancySmile")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Проверка корректного логина")
    public void correctLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        boolean isLogoPresent = productsPage.isPageLoaded();
        assertTrue(isLogoPresent, "Заголовок страницы не отображен");
    }
}