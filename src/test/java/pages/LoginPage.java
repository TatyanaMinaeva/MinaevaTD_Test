package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
   WebDriver browser;
   By loginField = By.cssSelector("input[id='user-name']");
   By passwordField = By.id("password");
   By loginButton = By.xpath("//input[@type='submit']");

   public LoginPage(WebDriver browser) {
       this.browser = browser;
   }

   public void open() {
   browser.get("https://www.saucedemo.com/");
   }

   public void login(String login, String password) {
       fillInLoginField(login);
       fillInPasswordField(password);
       browser.findElement(loginButton).click();
   }

   public void fillInLoginField(String login) {
       browser.findElement(loginField).sendKeys(login);
   }

   public void fillInPasswordField(String password) {
       browser.findElement(passwordField).sendKeys(password);
    }
}