package listeners;

import java.lang.reflect.Method;

import com.aventstack.extentreports.Status;
import reports.ExtentManager;
import reports.ExtentTestManager;
import utils.EmailUtil;
import utils.LoggerUtil;
import utils.ScreenshotUtil;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import java.io.File;

public class TestListener implements ITestListener, ISuiteListener {

    private static final Logger log = LoggerUtil.getLogger(TestListener.class);
    private static final ExtentReports extent = ExtentManager.getExtentReports();

    @Override
    public void onStart(ISuite suite) {
        log.info("Suite started: " + suite.getName());

        // Ensure reports folder exists
        File reportFolder = new File(System.getProperty("user.dir") + "/reports");
        if (!reportFolder.exists()) {
            reportFolder.mkdirs();
        }

        // Ensure screenshots folder exists
        File screenshotFolder = new File(System.getProperty("user.dir") + "/screenshots");
        if (!screenshotFolder.exists()) {
            screenshotFolder.mkdirs();
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        log.info("Suite finished: " + suite.getName());
        extent.flush();

        // Send email after suite finishes
        try {
            String reportPath = System.getProperty("user.dir") + "/reports/AutomationReport.html";
            EmailUtil.sendReport(reportPath);
        } catch (Exception e) {
            log.error("Error sending report via email: " + e.getMessage());
        }
    }

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
            // Grab driver from test instance if it has getDriver()
            Object currentClass = result.getInstance();
            Method m = currentClass.getClass().getMethod("getDriver");
            WebDriver driver = (WebDriver) m.invoke(currentClass);

            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, testName);
            if (screenshotPath != null) {
                test.addScreenCaptureFromPath(screenshotPath);
            }
        } catch (NoSuchMethodException nsme) {
            log.warn("Test class does not expose getDriver() method. Screenshot not attached.");
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

    // unused but required
    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}

    private String getTestName(ITestResult result) {
        return result.getMethod().getMethodName() != null ? result.getMethod().getMethodName() : result.getName();
    }
}
