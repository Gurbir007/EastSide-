package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;

public class Basetest {
    protected WebDriver driver;

    @BeforeSuite
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://eastsidefencing-staging-web.s3-website-ap-southeast-2.amazonaws.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("esf.admin.001@torrantal.asia", "111111111111Ab$");

    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
