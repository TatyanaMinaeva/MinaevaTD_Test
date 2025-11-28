package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @DataProvider(name = "invalidData")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"locked_out_user", "", "Epic sadface: Password is required"},
                {"Locked_out_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @TmsLink("MinaevaTD_Test")
    @Owner("Tatyana tg@FancySmile")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Проверка текста ошибки некорректного входа", dataProvider = "invalidData")
    public void incorrectLogin(String user, String password, String errorMsg) {
        loginPage.open();
        loginPage.login(user, password);
        assertTrue(loginPage.isErrorMsgAppear(), "Сообщение об ошибке не появляется");
        assertEquals(loginPage.errorMsgText(), errorMsg);
    }

    @TmsLink("MinaevaTD_Test")
    @Owner("Tatyana tg@FancySmile")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Проверка корректного логина")
    public void correctLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageLoaded("Products"), "Заголовок страницы не отображен");
    }
}