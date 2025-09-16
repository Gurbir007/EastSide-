package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ScheduleAppointment {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By schedule = By.xpath("//h6[normalize-space()='Schedules']");
    By findEstimator = By.xpath("//button[contains(text(),'Find Estimators')]");
    By selectZone = By.xpath("//div[@role='combobox']");
    By numberOfFence = By.xpath("//input[@type='number']");
    By search = By.xpath("//button[text()='Search']");
    By assignEstimator = By.xpath("(//button[normalize-space()='Assign Estimator'])[5]");
    By CLientName = By.xpath("//legend/span[text()='Client Name']/ancestor::div[contains(@class,'MuiInputBase-root')]//div[@role='combobox']");
    By ClientAddress = By.xpath("//legend/span[text()='Client Address']/ancestor::div[contains(@class,'MuiInputBase-root')]//div[@role='combobox']");
    By Assign = By.xpath("//button[text()='Assign']");

    public ScheduleAppointment(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void scheduleAppoint(String zone, String NOF, String clientName, String clientAddress) throws InterruptedException {
    	
    	
    	driver.findElement(schedule).click();
    	Thread.sleep(2000);
    	driver.findElement(findEstimator).click();
    	Thread.sleep(2000);
    	
    	
    	driver.findElement(selectZone).click();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	List<WebElement> options = wait.until(
    	        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li"))
    	);

    	options.get(2).click();
    	Thread.sleep(1000);
    	
    	
    	driver.findElement(numberOfFence).sendKeys(NOF);
    	Thread.sleep(1000);
    	
    	driver.findElement(search).click();
    	Thread.sleep(1000);
    	
    	
    	driver.findElement(assignEstimator).click();
    	Thread.sleep(1000);
    	
    	driver.findElement(CLientName).click();
    	Thread.sleep(2000);
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
    	List<WebElement> options1 = wait1.until(
    	        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li"))
    	);

    	options1.get(33).click();
    	Thread.sleep(2000);
    	
    	
    	driver.findElement(ClientAddress).click();
    	WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(30));
    	List<WebElement> options11 = wait11.until(
    	        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li"))
    	);

    	options11.get(1).click();
    	Thread.sleep(2000);
    	
    	driver.findElement(Assign).click();
    	Thread.sleep(3000);
    	
    	
    	
    	WebElement scrollContainer = driver.findElement(By.xpath("//div[contains(@class,'MuiBox-root')]/div[contains(@class,'MuiTableContainer-root')]"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = 0;", scrollContainer);
    	Thread.sleep(500);
    	    Thread.sleep(3000);

    }
}
