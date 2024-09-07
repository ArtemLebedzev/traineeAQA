package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static constants.Constants.ConfigVariable.PLATFORM_AND_BROWSER;
import static constants.Constants.TimeoutVariable.*;

public class CommonActions {
    public static WebDriver createDriver(){
        WebDriver driver = null;

        switch(PLATFORM_AND_BROWSER){
            case "win_chrome":
                System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                throw new RuntimeException("The environment variable(s) is(are) incorrect");
        }
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_WAIT));
        //driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(SET_SCRIPTS_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        return driver;
    }
}
