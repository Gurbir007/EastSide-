package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EstimatorLeave {
    WebDriver driver;
    WebDriverWait wait;

    By estimatorMenu = By.xpath("//div[@role='button']");
    By LeaveRequest = By.xpath("//h6[text() = 'Leave Requests']");
    By AddLeave = By.xpath("//button[text() = '+ Add Leave']");
    By LeaveDD = By.xpath("//div[contains(@class , 'MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl css-vak1gp')]");
    By DateFrom = By.xpath("//input[@type = 'date']");
    By DateTo = By.id("LeaveTo");
    By SaveLeave = By.xpath("//button[text() = 'Submit']");
    By SickLeaveOption = By.xpath("//li[text() = 'Sick Leave']");

    public EstimatorLeave(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public void goToAddEstimatorLeave(String fromDate, String toDate) {
        wait.until(ExpectedConditions.elementToBeClickable(estimatorMenu)).click();

        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        wait.until(ExpectedConditions.elementToBeClickable(LeaveRequest)).click();
        wait.until(ExpectedConditions.elementToBeClickable(AddLeave)).click();

        WebElement leaveDropdown = wait.until(ExpectedConditions.elementToBeClickable(LeaveDD));
        leaveDropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(SickLeaveOption)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(DateFrom)).sendKeys(fromDate);
        wait.until(ExpectedConditions.visibilityOfElementLocated(DateTo)).sendKeys(toDate);

        wait.until(ExpectedConditions.elementToBeClickable(SaveLeave)).click();
    }
}
