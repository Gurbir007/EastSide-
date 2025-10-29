package pages;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FixUpReport {

	WebDriver driver;
	By Report = (By.xpath("//a[@role='button'][.//h6[normalize-space(.)='Reports']]"));
	By EnterReport = By.xpath("//div[@role='button'][.//span[contains(text(), 'Enter / Insert Report Data')]]");
	By FixUpreport = By.xpath("//div[@role='button'][.//span[normalize-space(text())='FixUp Analysis Report']]");
	By ComplaintDate = By.name("dateOfComplaint");
	By Foremandate = By.name("givenToForeman");
	By QNum = By.name("quoteNumber");
	By jobdate = By.name("dateOfJob");
	By customer = By.name("customer");
	By Addres = By.name("address");
	By subhurb = By.name("suburb");
	By paid = By.name("paid");
	By fencer = By.id("mui-component-select-fencers");
	By code = By.id("mui-component-select-code");
	By Atfault = By.id("mui-component-select-atFault");
	By Description = By.xpath("//textarea[@name='description' and not(@aria-hidden)]");
	By ActionToken = By.name("actionTaken");
	By Fixupdate = By.xpath("//input[@type='date' and @name='fixUpDate']");
	By Completed = By.name("completed");
	By Save = By.xpath("//button[contains(text(), 'Save')]");
	
	
	  public FixUpReport(WebDriver driver) {
	        this.driver = driver;
	    }
	  
	  public void Quotereport(String ComD , String ForD , String Qnumber, String JobDa , String Cus , String Add , String Sub , String Des , String Fixdate , String Actokn) throws InterruptedException {
		  
		  driver.findElement(Report).click();
		  Thread.sleep(1000);
		  driver.findElement(EnterReport).click();
		  Thread.sleep(1000);
		  driver.findElement(FixUpreport).click();
		  Thread.sleep(1000);
		  driver.findElement(ComplaintDate).sendKeys(ComD);
		  Thread.sleep(1000);
		  driver.findElement(Foremandate).sendKeys(ForD);
		  Thread.sleep(1000);
		  driver.findElement(QNum).sendKeys(Qnumber);
		  Thread.sleep(1000);
		  driver.findElement(jobdate).sendKeys(JobDa);
		  Thread.sleep(1000);
		  driver.findElement(customer).sendKeys(Cus);
		  Thread.sleep(1000);
		  driver.findElement(Addres).sendKeys(Add);
		  Thread.sleep(1000);
		  driver.findElement(subhurb).sendKeys(Sub);
		  Thread.sleep(1000);
		  driver.findElement(paid).click();
		  Thread.sleep(1000);
		  
		  driver.findElement(fencer).click();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		  List<WebElement> options = wait.until(
	    	        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']/li")));

	    	options.get(0).click();
	    	options.get(1).click();
	    	driver.findElement(By.xpath("//body")).click();
	    	Thread.sleep(1000);
	    	
	    	driver.findElement(code).click();
	    	 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
			  List<WebElement> options1 = wait1.until(
		    	        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']/li"))
		    	);

		    	options1.get(1).click();
		    	Thread.sleep(1000);
	    	
		    	
		     driver.findElement(Atfault).click();	
		     WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(30));
			  List<WebElement> options11 = wait11.until(
		    	        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']/li"))
		    	);

		    	options11.get(1).click();
		    	Thread.sleep(1000);
		    	
		    	
		    	driver.findElement(Description).sendKeys(Des);
		    	Thread.sleep(1000);
		    	
		    	driver.findElement(ActionToken).sendKeys(Actokn);
		    	Thread.sleep(1000);
		    	
		    	
		    	driver.findElement(Fixupdate).sendKeys(Fixdate);
		    	Thread.sleep(1000);
		    	
		    	driver.findElement(Completed).click();
		    	Thread.sleep(1000);
		    	

		    	
		    	driver.findElement(Save).click();
		    	Thread.sleep(1000);	  
		  
	  }
}