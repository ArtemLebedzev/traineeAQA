package pages.mts_replenish_frame;

import methods.Methods;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class MTSReplenishFramePage extends BasePage {
    public MTSReplenishFramePage(WebDriver driver) {
        super(driver);
    }

    private final By phoneInputLocator = By.id("connection-phone");
    private final By sumInputLocator = By.id("connection-sum");
    private final By continueButtonLocator = By.xpath("//button[text()='Продолжить']");
    private final By frameLocator = By.cssSelector("iframe");

    private final String phoneNumber = "297777777";
    private final String sum = Methods.formatNumber("499.9");

    public MTSReplenishFramePage toFillFormAndClick(){
        WebElement inputPhone = driver.findElement(phoneInputLocator);
        WebElement inputSum = driver.findElement(sumInputLocator);
        WebElement button = driver.findElement(continueButtonLocator);
        inputPhone.sendKeys(phoneNumber);
        inputSum.sendKeys(sum);
        waitElementIsClickable(continueButtonLocator);
        button.click();
        return this;
    }

    public MTSReplenishFramePage waitForFrameAndSwitchToIt() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.switchTo().frame(waitElementIsPresence(frameLocator));
        return this;
    }

    /*Использую thread чтоб элемент точно загрузился, ибо из-за интернета или чего-то другого (сам не доразобрался) часто
    вылетает ошибка, что нет такого элемента*/
    public MTSReplenishFramePage checkSumInFrame(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement frameSum = waitElementIsPresence(By.xpath("//span[contains(text(), 'BYN')]"));
        Assertions.assertEquals(frameSum.getText(), (sum +  " BYN").replace(",", "."));
        return this;
    }

    public MTSReplenishFramePage checkFramePhoneNumber(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String text = waitElementIsPresence(By.xpath("//span[contains(text(),':')]")).getText();
        String framePhoneNumber = text.substring(text.indexOf("3"));
        Assertions.assertEquals(framePhoneNumber,"375" + phoneNumber);
        return this;
    }

    public MTSReplenishFramePage checkFramePlaceholders(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals("Номер карты", driver
                .findElement(By.xpath("//label[text()='Номер карты']"))
                .getText());
        Assertions.assertEquals("Срок действия", driver
                .findElement(By.xpath("//label[text()='Срок действия']"))
                .getText());
        Assertions.assertEquals("CVC", driver
                .findElement(By.xpath("//label[text()='CVC']"))
                .getText());
        Assertions.assertEquals("Имя держателя (как на карте)", driver
                .findElement(By.xpath("//label[text()='Имя держателя (как на карте)']"))
                .getText());
        return this;
    }

    public MTSReplenishFramePage checkFramePartnersList(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertTrue(waitElementIsVisibility(By.
                xpath("//div[@class='icons-container ng-tns-c46-1']")) != null);
        return this;
    }

    public MTSReplenishFramePage checkSumInButtonFrame(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement frameSumInButton = waitElementIsPresence(By
                .xpath("//button[@class='colored disabled']"));
        Assertions.assertEquals(frameSumInButton.getText(),
                ("Оплатить " + sum +  " BYN").replace(",", "."));
        //Или нужно вырезать цену как в методе выше?
        return this;
    }
}
