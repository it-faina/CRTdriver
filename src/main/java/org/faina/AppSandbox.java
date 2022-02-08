package org.faina;

import org.faina.configuration.ConfigProperties;
import org.faina.configuration.Configurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Connected Retail web driver services DEMO
 */
public class AppSandbox {

    public static void main(String[] args) {
//        WebDriver driver;
//        System.out.println("Web Driver was started");
//        System.setProperty("webdriver.chrome.driver", "D:/drivers/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.navigate().to("https://duckduckgo.com/");
//
//        driver.findElement(By.id("search_form_input_homepage")).sendKeys("JavaStart");
//        driver.findElement(By.id("search_form_input_homepage")).submit();
//
//        String pageTitle = driver.getTitle();
//        System.out.println(pageTitle);
//        driver.close();
//        driver.quit();

        System.out.println(Configurator.getWebdriverDir());
        System.out.println(Configurator.getImplicytyWait());


    }
}
