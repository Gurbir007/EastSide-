package listeners;

import java.lang.reflect.Method;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.*;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import reports.ExtentManager;
import reports.ExtentTestManager;
import utils.EmailUtil;
import utils.LoggerUtil;
import utils.ScreenshotUtil;
import org.apache.logging.log4j.Logger;

public class TestListener implements ITestListener, ISuiteListener {

    private static final Logger log = LoggerUtil.getLogger(TestListener.class);
    private static final ExtentReports extent = ExtentManager.getExtentReports();

    // ---------------- Suite level ----------------
    @Override
    public void onStart(ISuite suite) {
        log.info("Suite started: " + suite.getName());

        // Ensure reports folder exists
        File reportFolder = new File(System.getProperty("user.dir") + "/reports");
        if (!reportFolder.exists()) reportFolder.mkdirs();

        // Ensure screenshots folder exists
        File screenshotFolder = new File(System.getProperty("user.dir") + "/screenshots");
        if (!screenshotFolder.exists()) screenshotFolder.mkdirs();
    }

    @Override
    public void onFinish(ISuite suite) {
        // Flush ExtentReports
        extent.flush();
        log.info("Suite finished: " + suite.getName());

        // Send email after suite finishes
        try {
            String reportPath = utils.ConfigReader.get("report.path"); // use config path
            EmailUtil.sendReport(reportPath);
        } catch (Exception e) {
            log.error("❌ Error sending report via email: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ---------------- Test level ----------------
    @Override
    public void onTestStart(ITestResult result) {
        String testName = getTestName(result);
        ExtentTest test = extent.createTest(testName);
        ExtentTestManager.startTest(testName, test);
        log.info("Test started: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = getTestName(result);
        ExtentTestManager.getTest(testName).log(Status.PASS, "✅ Test Passed");
        log.info("Test passed: " + testName);
        ExtentTestManager.removeTest(testName);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = getTestName(result);
        ExtentTest test = ExtentTestManager.getTest(testName);
        test.log(Status.FAIL, result.getThrowable());
        log.error("Test failed: " + testName, result.getThrowable());

        try {
            // Grab driver from test instance if getDriver() exists
            Object currentClass = result.getInstance();
            Method m = currentClass.getClass().getMethod("getDriver");
            WebDriver driver = (WebDriver) m.invoke(currentClass);

            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, testName);
            if (screenshotPath != null) {
                test.addScreenCaptureFromPath(screenshotPath);
            }
        } catch (NoSuchMethodException nsme) {
            log.warn("Test class does not expose getDriver() method. Screenshot skipped.");
        } catch (Exception e) {
            log.error("Error taking screenshot: " + e.getMessage());
        }

        ExtentTestManager.removeTest(testName);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = getTestName(result);
        ExtentTestManager.getTest(testName).log(Status.SKIP, "⚠ Test Skipped");
        log.info("Test skipped: " + testName);
        ExtentTestManager.removeTest(testName);
    }

    // ---------------- Unused required overrides ----------------
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}

    // ---------------- Helper ----------------
    private String getTestName(ITestResult result) {
        return result.getMethod().getMethodName() != null ? result.getMethod().getMethodName() : result.getName();
    }
}