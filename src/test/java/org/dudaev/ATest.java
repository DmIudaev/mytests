package org.dudaev;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ATest {

        private static WebDriver driver;

        @BeforeClass
        public static void setup() {
            System.setProperty("webdriver.chrome.driver", "C://WebDriver//chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://mail.ru");
        }
        @Test
        public void userLogin() {
            WebElement loginField = driver.findElement(By.id("mailbox:login"));
            loginField.sendKeys("dmitry_guap");
            WebElement passwordField = driver.findElement(By.id("mailbox:password"));
            passwordField.sendKeys("deaf_omega");
            //WebElement loginButton = driver.findElement(By.xpath("//button[text()='Войти']"));
            WebElement loginButton = driver.findElement(By.id("mailbox:submit"));
            loginButton.click();
            WebElement profileUser = driver.findElement(By.id("PH_user-email"));
            String mailUser = profileUser.getText();
            Assert.assertEquals("dmitry_guap@mail.ru", mailUser);
        }
        @AfterClass
        public static void tearDown() {
            WebElement menuUser = driver.findElement(By.cssSelector(".login-button__menu-icon"));
            menuUser.click();
            WebElement logoutButton = driver.findElement(By.id("login__logout"));
            logoutButton.click();
            driver.quit();
        }
}
