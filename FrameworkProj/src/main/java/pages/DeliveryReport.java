package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeliveryReport {

	WebDriver driver;
    WebDriver Wait;
        
    
    By Report = (By.xpath("//a[@role='button'][.//h6[normalize-space(.)='Reports']]"));
    By EnterReport = By.xpath("//div[@role='button'][.//span[contains(text(), 'Enter / Insert Report Data')]]");
	By Extradel = By.xpath("//div[@role='button'][.//span[normalize-space(text())='Extra Delivery Report']]");
	
	By date=By.name("date");
	By QuoteNo = By.name("quoteNumber");
	By Address = By.name("address");
	By Subhurb = By.name("suburb");
//	By MatreailRe = By.id("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-l4dq4o' and @id = ':r49:']");
//	By AddMaterail = By.xpath("//button[contains(normalize-space(.),'➕ Add Material')]");
	By checkbox = By.name("auslattDeliver");
	By code = By.id("mui-component-select-code");
	By reason = By.name("reason");
	By save = By.xpath("//button[contains(normalize-space(.),'Save')]");

	public DeliveryReport(WebDriver driver) {
		this.driver = driver;

	}
	
	public void ExtraDelreport(String Dt , String QNo , String Add , String sub , String Mreq , String RS) {
		
		
		driver.findElement(Report).click();
		driver.findElement(EnterReport).click();
		driver.findElement(Extradel).click();
		
		driver.findElement(date).sendKeys(Dt);
		driver.findElement(QuoteNo).sendKeys(QNo);
		driver.findElement(Address).sendKeys(Add);
		driver.findElement(Subhurb).sendKeys(sub);
//		driver.findElement(MatreailRe).sendKeys(Mreq);
//		driver.findElement(AddMaterail).click();
		
		driver.findElement(checkbox).click();
		
		driver.findElement(code).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  List<WebElement> options = wait.until(
	    	        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']/li"))
	    	);

	    	options.get(1).click();
	    	
	    driver.findElement(reason).sendKeys(RS);
	    driver.findElement(save).click();	
		
		
	}
}