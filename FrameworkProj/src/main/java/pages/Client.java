package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Client {
	WebDriver driver;
	WebDriverWait wait;
	

	
	By clinet = By.xpath("//a[@href='/clients']");
	By Addclient = By.xpath("//button[normalize-space()='Add New Client']");
	
//	Client Deatils
	By Fullname = By.id("name");
	By Email = By.id("email");
	By BillingAddres = By.name("billingAddress");
	By Phone = By.id("phone");
		
//	Secondary address
	By Name = By.id("secondaryContacts.0.name");
	By SecEMail = By.id("secondaryContacts.0.email");
	By SecondaryAddres = By.name("secondaryContacts.0.address");
	By SecondaryPhone = By.id("secondaryContacts.0.phone");
	
//	Job address
	
	By Tittle = By.id("jobAddresses.0.title");
	By JobAddress = By.name("jobAddresses.0.address");
	By Save = By.xpath("//button[text() = 'Save']");
	
	
	 public Client(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	        
	 public void openClientForm() {
	        wait.until(ExpectedConditions.elementToBeClickable(clinet)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(Addclient)).click();
	    }
	        public void AddNewClient(String name, String email, String billingaddres, String number ) throws InterruptedException {
	        	
	        	driver.findElement(Fullname).sendKeys(name);
	        	Thread.sleep(2000);
	        	driver.findElement(Email).sendKeys(email);
	        	Thread.sleep(2000);
	        	
	        	driver.findElement(BillingAddres).click();
	        	driver.findElement(BillingAddres).sendKeys(billingaddres);
	        	
	        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        	List<WebElement> options = wait.until(
	        	        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li"))
	        	);

	        	// 4th option (index 3)
	        	options.get(3).click();
	        	
	        	driver.findElement(Phone).sendKeys(number);
	        }
	        
	        public void SecondarAddres(String name2, String email2, String address2, String nuber2) throws InterruptedException {
	        	
	        	driver.findElement(Name).sendKeys(name2);
	        	Thread.sleep(2000);
	        	driver.findElement(SecEMail).sendKeys(email2);
	        	Thread.sleep(2000);
	        	
	        	driver.findElement(SecondaryAddres).click();
	        	driver.findElement(SecondaryAddres).sendKeys(address2);
	        	
	        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        	List<WebElement> options = wait.until(
	        	        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li"))
	        	);

	        	// 4th option (index 3)
	        	options.get(3).click();
	        	driver.findElement(SecondaryPhone).sendKeys(nuber2);
	        
	        	
	        }
	        public void Jobdetail(String tille, String jobaddress) throws InterruptedException {
	        	
	        	driver.findElement(Tittle).sendKeys(tille);
	        	Thread.sleep(2000);
	        	
	        	driver.findElement(JobAddress).click();
	        	driver.findElement(JobAddress).sendKeys(jobaddress);
	        	
	        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        	List<WebElement> options = wait.until(
	        	        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li"))
	        	);

	        	// 4th option (index 3)
	        	options.get(3).click();
	        	driver.findElement(Save).click();
	        
	        	
	        }

}



