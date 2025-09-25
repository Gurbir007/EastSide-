package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.ConfigReader;

public class ExtentManager {
    private static ExtentReports extent;

    public synchronized static ExtentReports getExtentReports() {
        if (extent == null) {
            String reportPath = ConfigReader.get("report.path");
            if (reportPath == null || reportPath.isEmpty()) reportPath = "./test-output/reports/ExtentReport.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setDocumentTitle("Automation Test Report");
            spark.config().setReportName("Regression Suite");
            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("User", System.getProperty("user.name"));
        }
        return extent;
    }
}
