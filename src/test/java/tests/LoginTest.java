package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;
import user.UserFactory;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class LoginTest extends BaseTest {

    @DataProvider(name = "invalidData")
    public Object[][] loginData() {
        return new Object[][]{
                /*{PropertyReader.getProperty("saucedemo.locked_user"),
                        PropertyReader.getProperty("saucedemo.password"),
                        "Epic sadface: Sorry, this user has been locked out."},*/
                {UserFactory.withLockedUserPermission(),
                        "Epic sadface: Sorry, this user has been locked out."},
                {UserFactory.withUsernameOnly(""),
                        "Epic sadface: Username is required"},
                {UserFactory.withPasswordOnly(""),
                        "Epic sadface: Password is required"},
                {new User("Locked_out_user", "secret_sauce"),
                        "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @TmsLink("MinaevaTD_Test")
    @Owner("Tatyana tg@FancySmile")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Проверка некорректного логина", dataProvider = "invalidData")
    public void incorrectLogin(User user, String errorMsg) {
        System.out.println("LoginTest inc is running in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(user);
        assertTrue(loginPage.isErrorMsgAppear(), "Сообщение об ошибке не появляется");
        assertEquals(loginPage.errorMsgText(), errorMsg);
    }

    @Epic("Создание лида")
    @Feature("Создание с карточки клиента")
    @Story("Пангинация")
    @TmsLink("MinaevaTD_Test")              // ссылка на ТК
    @Issue("MinaevaTD_Test")                // ссылка на тикет
    @Owner("Tatyana tg@FancySmile")         // имя и контакты автора теста
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Проверка корректного логина")
    public void correctLogin() {
        System.out.println("LoginTest corr is running in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(withAdminPermission());
        assertTrue(productsPage.isPageLoaded(PRODUCTS.getDisplayName()), "Заголовок страницы не отображен");
    }
}