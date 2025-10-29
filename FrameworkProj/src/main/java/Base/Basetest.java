package Base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.LoginPage;
import reports.ExtentManager;
import reports.ExtentTestManager;
import utils.ScreenshotUtil;

import java.time.Duration;

public class Basetest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;

    @BeforeSuite
    public void setUp() throws InterruptedException {
       
        extent = ExtentManager.getExtentReports();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://eastsidefencing-staging-web.s3-website-ap-southeast-2.amazonaws.com/login");

      
        LoginPage loginPage = new LoginPage(driver);

      
        String activeUser = "admin";

        switch (activeUser.toLowerCase()) {
            case "admin":
                loginPage.login("esf.admin.001@torrantal.asia", "111111111111Ab$");
                System.out.println("✅ Logged in as ADMIN");
                break;

            case "estimator":
                loginPage.login("salt.E@yopmail.com", "salt.E@yopmail.com1");
                System.out.println("✅ Logged in as ESTIMATOR");
                break;

            case "user2":
                loginPage.login("user2@demo.com", "User2@123");
                System.out.println("✅ Logged in as USER2");
                break;

            default:
                System.out.println("⚠️ Invalid user type selected. Please check 'activeUser' value!");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(ITestResult result) {
        String testName = result.getMethod().getMethodName();

       
        test = ExtentTestManager.getTest(testName);
        if (test == null) {
            test = extent.createTest(testName);
            ExtentTestManager.startTest(testName, test);
        }

        try {
          
            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, testName);

          
            if (result.getStatus() == ITestResult.SUCCESS) {
                test.log(Status.PASS, "Test Passed ✅");
            } else if (result.getStatus() == ITestResult.FAILURE) {
                test.log(Status.FAIL, "Test Failed ❌: " + result.getThrowable());
            } else if (result.getStatus() == ITestResult.SKIP) {
                test.log(Status.SKIP, "Test Skipped ⚠️");
            }

            
            test.addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {
            System.err.println("⚠️ Screenshot/Reporting failed: " + e.getMessage());
        }
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) driver.quit();
        if (extent != null) extent.flush(); // Write report to file
    }
}
