import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomeworkTest {

    /*    public static class Counter {
        private static int count = 0;

        public static void increment() {
            count++;
        }
    }

    public static class FindMistakes {
        public double divide(int a, int b) {
            return (double) a / b;
        }

        public boolean isAdmin(String role) {
            return role.equals("ADMIN");
        }
    }*/

    @Test
    public void locatorSearchOnlineStores() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cdek.ru/ru/");
        boolean onlineStores = driver.findElement(By.cssSelector("a[to='/ru/online-stores/']")).isDisplayed();
        assertTrue(onlineStores, "Объект Онлайн-Магазинам не найден");
        driver.quit();
    }

    @Test
    public void locatorSearchInputField() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cdek.ru/ru/");
        boolean inputField = driver.findElement(By.xpath("//div[text()='Куда'] /ancestor::label")).isDisplayed();
        assertTrue(inputField, "Объект ПолеВводаКуда не найден");
        driver.quit();
    }

    @Test
    public void locatorSearchOnlinePayment() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cdek.ru/ru/");
        boolean onlinePayment = driver.findElement(By.xpath("//button[text()='онлайн-оплата']")).isDisplayed();
        assertTrue(onlinePayment, "Объект ОнлайнОплата не найден");
        driver.quit();
    }
}