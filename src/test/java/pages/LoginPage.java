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
    public void open() {
        driver.get(BASE_URL);
    }

    public void open(String url) {
        driver.get(BASE_URL + url);
    }

    @Step("Логинимся под кредами пользователя логин = {user.email}, пароль = ******")
    public void login(User user) {
        enterUserName(user.getEmail());
        enterPasswordName(user.getPassword());
        driver.findElement(loginButton).click();
    }

    public void login(String user, String pass) {
        enterLoginName(user);
        enterPasswordName(pass);
        driver.findElement(loginButton).click();
    }

    @Step("Вносим логин")
    public void enterUserName(final String userName) {
        driver.findElement(userField).sendKeys(userName);
    }

    public void enterLoginName(final String userName) {
        driver.findElement(userField).sendKeys(userName);
    }

    @Step("Вносим пароль")
    public void enterPasswordName(final String passwordName) {
        driver.findElement(passwordField).sendKeys(passwordName);
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