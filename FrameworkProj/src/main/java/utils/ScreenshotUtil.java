package utils;

import java.io.File;

import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String testName) {
        try {
            String dir = ConfigReader.get("screenshot.dir");
            if (dir == null || dir.isEmpty()) dir = "./screenshots/";
            Path folder = Path.of(dir);
            if (!Files.exists(folder)) {
                Files.createDirectories(folder);
            }
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
            String fileName = testName + "_" + timestamp + ".png";
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path target = folder.resolve(fileName);
            Files.copy(src.toPath(), target);
            return target.toAbsolutePath().toString();
        }catch (Exception e) {
            System.err.println("Screenshot failed for test: " + testName + " - " + e.getMessage());
            e.printStackTrace();
            return null;
        }

}
}