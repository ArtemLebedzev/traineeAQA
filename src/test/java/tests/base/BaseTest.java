package tests.base;

import common.CommonActions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import pages.base.BasePage;
import pages.mts_replenish.MTSReplenishPage;
import pages.mts_replenish_frame.MTSReplenishFramePage;

import static constants.Constants.ConfigVariable.*;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected MTSReplenishPage mtsReplenishPage = new MTSReplenishPage(driver);
    protected MTSReplenishFramePage mtsReplenishFramePage = new MTSReplenishFramePage(driver);

    @BeforeEach
    public void loadPageAndAcceptCookie(){
        basePage.openPage(DEFAULT_PAGE);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        basePage.acceptCookies();
    }

    @BeforeEach
    public void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.localStorage.clear(); window.sessionStorage.clear();");
        }
    }

    @AfterEach
    public void closePage() {
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
