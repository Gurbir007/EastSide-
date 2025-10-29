package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenerateReport {
	
	WebDriver driver;
	WebDriverWait wait;

	By Report = By.xpath("//a[@role='button'][.//h6[normalize-space(.)='Reports']]");
	By ViewReport = By.xpath("//div[@role='button'][.//span[contains(text(), '📊 View / Generate Reports')]]");
	By FixUpreport = By.xpath("//div[@role='button'][.//span[normalize-space(text())='FixUp Analysis Report']]");
	
	By Fdate = By.xpath("//label[normalize-space(.)='From Date']/following::input[1]");
	By Todate = By.xpath("//label[normalize-space(.)='To Date']/following::input[1]");

	By bttn = By.xpath("//button[contains(.,'Generate Report')]");

	public GenerateReport(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	 
	public void GenReport(String FD , String TD) {
		
		wait.until(ExpectedConditions.elementToBeClickable(Report)).click();
		wait.until(ExpectedConditions.elementToBeClickable(ViewReport)).click();
		wait.until(ExpectedConditions.elementToBeClickable(FixUpreport)).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Fdate)).sendKeys(FD);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Todate)).sendKeys(TD);

		WebElement generateBtn = wait.until(ExpectedConditions.elementToBeClickable(bttn));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", generateBtn);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", generateBtn);
	}
}
