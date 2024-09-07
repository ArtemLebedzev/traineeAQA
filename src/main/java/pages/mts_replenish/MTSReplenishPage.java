package pages.mts_replenish;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;
import org.junit.jupiter.api.*;

public class MTSReplenishPage extends BasePage {
    public MTSReplenishPage(WebDriver driver) {
        super(driver);
    }

    //АХТУНГ, Переменные ниже будут использованы в другом пакете, но и показаны для примера (про KISS Pattern помню)
    private final By phoneInputLocator = By.id("connection-phone");
    private final By sumInputLocator = By.id("connection-sum");
    private final By emailInputLocator = By.id("connection-email");
    private final By continueButtonLocator = By.xpath("//button[text()='Продолжить']");
    private final By frameLocator = By.cssSelector("iframe");

    public MTSReplenishPage checkTitle() {
        Assertions.assertEquals("Онлайн пополнение\nбез комиссии", driver
                .findElement(By.xpath("//h2[text()='Онлайн пополнение ']"))
                .getText());
        return this;
    }

    public MTSReplenishPage checkPaySystemsAppearing(){
        Assertions.assertTrue(waitElementIsVisibility(By.className("pay__partners")) != null);
        return this;
    }

    public MTSReplenishPage checkIsLinkClickable() {
        WebElement textLink = waitElementIsClickable(By.xpath("//a[text()='Подробнее о сервисе']"));
        Assertions.assertTrue(textLink != null);
        textLink.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(driver.getCurrentUrl(),
                "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/");

        return this;
    }

    public MTSReplenishPage toFillFormAndClick(){
        WebElement inputPhone = driver.findElement(phoneInputLocator);
        WebElement inputSum = driver.findElement(sumInputLocator);
        WebElement inputEmail = driver.findElement(emailInputLocator);
        WebElement button = driver.findElement(continueButtonLocator);
        inputPhone.sendKeys("297777777");
        inputSum.sendKeys("499.99");
        inputEmail.sendKeys("artem180420044@gmail.com");
        button.click();
        return this;
    }

    public MTSReplenishPage checkFrameIsAppearing(){
        Assertions.assertTrue(waitElementIsPresence(frameLocator) != null);
        return this;
    }

    public MTSReplenishPage checkPlaceholders(){
        Assertions.assertEquals("Номер телефона",driver
                .findElement(By.xpath("//input[@placeholder='Номер телефона']"))
                .getAttribute("placeholder"));
        Assertions.assertEquals("Сумма",driver
                .findElement(By.xpath("//input[@placeholder='Сумма']"))
                .getAttribute("placeholder"));
        Assertions.assertEquals("E-mail для отправки чека",driver
                .findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"))
                .getAttribute("placeholder"));
        Assertions.assertEquals("Номер абонента",driver
                .findElement(By.xpath("//input[@placeholder='Номер абонента']"))
                .getAttribute("placeholder"));
        Assertions.assertEquals("Номер счета на 44",driver
                .findElement(By.xpath("//input[@placeholder='Номер счета на 44']"))
                .getAttribute("placeholder"));
        Assertions.assertEquals("Номер счета на 2073",driver
                .findElement(By.xpath("//input[@placeholder='Номер счета на 2073']"))
                .getAttribute("placeholder"));
        return this;

    }
}
