package org.faina.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AllOrdersPage extends OrderPage {

    public AllOrdersPage(WebDriver driver, WebDriver.Timeouts timeouts) {
        super(driver, timeouts);
    }

    void clickSearchButton(String searchIDOrder) throws InterruptedException {
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.xpath("//input[@aria-label]"));
        search.sendKeys(searchIDOrder);
    }

    public void clickViewHistoryButton() {
        WebElement viewHistButton = driver.findElement(By.xpath("//div[@class='order-card-wrapper']//button[contains(@class,'order_history_button')]"));
        viewHistButton.click();
    }

    public void clickReturnButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement buttonClass = driver.findElement(By.xpath("//button[@class='order-line__return-button v-btn v-btn--flat v-btn--outline v-btn--depressed theme--light return--text']"));
        buttonClass.click();
    }

    public void returnReason(String returnReason) throws InterruptedException {
        Thread.sleep(2000);
        WebElement doesntSuite = driver.findElement(By.xpath("//div[@class='v-card v-sheet theme--light']//div[contains(text(),'" + returnReason + "')]"));
        doesntSuite.click();

    }

    String readEANfromSectionOrder(String ean) throws InterruptedException {
        System.out.println(ean);
        Thread.sleep(2000);
        List<WebElement> eanList = driver.findElements(By.xpath("//section/div/div/section/div[@class='order-line__article-ean']"));
        int eanElementOnOrderList = 1;
        for (WebElement el : eanList
        ) {
            System.out.println("wydruk: " + el.getText());
            if (ean.equals(el.getText())) {
                System.out.println("found element on the list at the position " + eanElementOnOrderList);
                WebElement hereClickToMarkReturned = driver.findElement(By.xpath("//section[" + eanElementOnOrderList + "]/div/div/section/div[@class='order-line__article-ean']/following::button[1]"));
                hereClickToMarkReturned.click();
                WebElement doesntSuite = driver.findElement(By.xpath("//section[" + eanElementOnOrderList + "]/div/div/section/div[@class='order-line__article-ean']/preceding::div[@class='v-list__tile__title' and contains(text(),'2. Too big')][" + eanElementOnOrderList + "]"));
                doesntSuite.click();
            }
            eanElementOnOrderList++;
        }
        return ean;
    }

    public void clickCancel() throws InterruptedException {
        Thread.sleep(2000);
        WebElement cancelButton = driver.findElement(By.xpath("//button//div[@class='v-btn__content' and contains(text(),'Cancel')]"));
        cancelButton.click();
    }
}
