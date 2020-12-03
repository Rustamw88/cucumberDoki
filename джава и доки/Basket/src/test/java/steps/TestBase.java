package steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
    String SITE_URL = "https://www.ozon.ru/";
    WebDriver driver;


    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void finish() {
        driver.quit();
    }
}
