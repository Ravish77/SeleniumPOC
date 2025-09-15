
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SeleniumPOC {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.google.com");
            driver.manage().window().maximize();

            // ✅ Add Explicit Wait for search box
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='q']"))
            );

            searchBox.sendKeys("Spring Boot Selenium Example");
            searchBox.sendKeys(Keys.RETURN);

            Thread.sleep(3000); // just to observe results
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
