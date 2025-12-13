package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {
    By userField = By.cssSelector("input[id='user-name']");
    By passwordField = By.id("password");
    By loginButton = By.xpath("//input[@type='submit']");
    By error = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открываем соответствующее приложение")
    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    public LoginPage open(String url) {
        driver.get(BASE_URL + url);
        return this;
    }

    @Step("Логинимся под кредами пользователя логин = {user.email}, пароль = ******")
    public LoginPage login(User user) {
        enterUserName(user.getEmail());
        enterPasswordName(user.getPassword());
        driver.findElement(loginButton).click();
        return this;
    }

    public LoginPage login(String user, String pass) {
        enterLoginName(user);
        enterPasswordName(pass);
        driver.findElement(loginButton).click();
        return this;
    }

    @Step("Вносим логин")
    public LoginPage enterUserName(final String userName) {
        driver.findElement(userField).sendKeys(userName);
        return this;
    }

    public LoginPage enterLoginName(final String userName) {
        driver.findElement(userField).sendKeys(userName);
        return this;
    }

    @Step("Вносим пароль")
    public LoginPage enterPasswordName(final String passwordName) {
        driver.findElement(passwordField).sendKeys(passwordName);
        return this;
    }

    @Step("Проверяем появление сообщения об ошибки")
    public boolean isErrorMsgAppear() {
        return driver.findElement(error).isDisplayed();
    }

    @Step("Проверяем текст ошибки")
    public String errorMsgText() {
        return driver.findElement(error).getText();
    }
}