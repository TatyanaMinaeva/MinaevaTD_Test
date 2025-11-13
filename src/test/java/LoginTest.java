import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest {

    //открыть браузер
    //вводим название сайта

    @Test
    public void incorrectLogin() {
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.cssSelector("input[id='user-name']")).sendKeys("locked_out_user");
        browser.findElement(By.id("password")).sendKeys("secret_sauce");
        browser.findElement(By.xpath("//input[@type='submit']")).click();
        String errorText = browser.findElement(By.cssSelector("*[data-test='error']")).getText();
        assertEquals(errorText, "Epic sadface: Sorry, this user has been locked out.",
                "Сообщение об ошибке не верное");
        browser.quit();



    }
}




/*    public String getErrorMsg() {

        return "";
    }*/
//browser.findElement(By.cssSelector("input[id='user-name']"));
//browser.findElement(By.id("user-name"));