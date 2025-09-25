package reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
    private static Map<String, ExtentTest> extentTestMap = new HashMap<>();

    public static synchronized ExtentTest getTest(String name) {
        return extentTestMap.get(name);
    }

    public static synchronized void startTest(String name, ExtentTest test) {
        extentTestMap.put(name, test);
    }

    public static synchronized void removeTest(String name) {
        extentTestMap.remove(name);
    }
}

