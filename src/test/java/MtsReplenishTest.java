import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;

public class MtsReplenishTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(20));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void testTitle() {
        driver.get("https://www.mts.by/");
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        WebElement element = driver.findElement(By.xpath("//h2[text()='Онлайн пополнение ']"));
        String actualTitle = element.getText();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testPaySystemsAppeared() {
        driver.get("https://www.mts.by/");
        List<WebElement> elements = driver.findElements(By.className("pay__partners"));
        Assertions.assertTrue(elements.size() > 0);
    }

    @Test
    public void testIsLinkClickable(){
        driver.get("https://www.mts.by/");
        Assertions.assertDoesNotThrow(() -> {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Подробнее о сервисе']")));
        }, "The link did not become clickable within the timeout period.");
    }

    @Test
    public void testIsButtonClickable() {
        driver.get("https://www.mts.by/");

        try {
            WebElement cookieButton = driver.findElement(By.xpath("//button[text()='Принять']"));
            if (cookieButton.isDisplayed()) {
                cookieButton.click();
            }
        } catch (NoSuchElementException e) {
        }

        WebElement inputPhone = driver.findElement(By.id("connection-phone"));
        WebElement inputSum = driver.findElement(By.id("connection-sum"));
        WebElement inputEmail = driver.findElement(By.id("connection-email"));
        WebElement button = driver.findElement(By.xpath("//button[text()='Продолжить']"));

        inputPhone.sendKeys("297777777");
        inputSum.sendKeys("499.99");
        inputEmail.sendKeys("artem180420044@gmail.com");
        button.click();

        Assertions.assertDoesNotThrow(() -> {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe")));
        });
    }
}
