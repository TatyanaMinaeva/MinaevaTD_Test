package tests;

import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.LoginPage;
import pages.ProductsPage;
import utils.TestListener;

import java.time.Duration;

@Listeners({AllureTestNg.class, TestListener.class})
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeMethod
    public void setup(ITestContext context) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");   // развернуть окно
        options.addArguments("--guest");
        // options.addArguments("--window-size=1920,1080");
        // options.addArguments("--headless");    // тесты проходят в фоновом режиме без графического отбражения

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        context.setAttribute("driver", driver);
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}