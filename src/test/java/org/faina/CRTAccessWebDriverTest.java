package org.faina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class CRTAccessWebDriverTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "D:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(enabled = false)
    public void connectedRetailPageAccessibleByWebDriver() throws InterruptedException {
        driver.navigate().to("https://connected-retail.zalando.com/");

        String pageTitle = driver.getTitle();
        driver.wait(20000); //dostajemy stronę logowania
        assertTrue(pageTitle.contains("Sign In with"));
    }


    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
