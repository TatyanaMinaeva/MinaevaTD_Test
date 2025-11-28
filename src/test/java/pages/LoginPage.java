package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    @Step("Логинимся под кредами пользователя")
    public void login(final String userName, final String passwordName) {
        enterUserName(userName);
        enterPasswordName(passwordName);
        driver.findElement(loginButton).click();
    }

    @Step("Вносим логин")
    public void enterUserName(final String userName) {
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