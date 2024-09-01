import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


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
        driver.manage().timeouts().pageLoadTimeout(10000,
                TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(5000,
                TimeUnit.MILLISECONDS);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
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
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Подробнее о сервисе']")));
        }, "The link did not become clickable within the timeout period.");
    }
}
