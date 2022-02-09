package org.faina;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Chrome WebDriverTest
 */
public class WebDriverTest {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "D:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void chromeWebDriverTest() {
        driver.navigate().to("https://duckduckgo.com/");

        driver.findElement(By.id("search_form_input_homepage")).sendKeys("JavaStart");
        driver.findElement(By.id("search_form_input_homepage")).submit();
        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("JavaStart"));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
