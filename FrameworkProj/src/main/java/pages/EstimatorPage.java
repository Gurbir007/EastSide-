package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

	public class EstimatorPage {
	    WebDriver driver;

	    By estimatorMenu = By.xpath("//div[@role='button']"); 	
	    By addEstimatorLink = By.xpath("//a[@href='/users/estimators']");
	    By AddEsti = By.xpath("//button[text() = '+ Add Estimator']");
	    
	    By Fullname = By.name("Name");    
	    By emailField = By.name("Email");  
	    By phoneField = By.name("Phone"); 
	    By Password = By.name("Password");
	    By Conpassword = By.name("ConfirmPassword");
	    By workingDays = By.xpath("//input[@type = 'checkbox']");   
	    By Zones = By.xpath("//input[contains(@class ,'PrivateSwitchBase-input css-1m9pwf3')]");
	    By timeDropdown = By.xpath("//div[contains(@class ,'MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-d0nyjk')]");        
	    By saveButton = By.xpath("//button[@type='submit']");

	    public EstimatorPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void goToAddEstimator() throws InterruptedException {
	        driver.findElement(estimatorMenu).click();
	        Thread.sleep(2000);
	        driver.findElement(addEstimatorLink).click();
	        Thread.sleep(2000);
	        driver.findElement(AddEsti).click();
	        Thread.sleep(2000);
	        
	    }

	    public void addEstimator(String name, String email, String phone , String Pass, String Confpass) throws InterruptedException {
	        driver.findElement(Fullname).sendKeys(name);
	        Thread.sleep(1000);
	        
	        driver.findElement(emailField).sendKeys(email);
	        Thread.sleep(1000);
	        
	        driver.findElement(phoneField).sendKeys(phone);
	        Thread.sleep(1000);
	        
	        driver.findElement(Password).sendKeys(Pass);
	        Thread.sleep(1000);
	        
	        driver.findElement(Conpassword).sendKeys(Confpass);
	        Thread.sleep(1000);
	        
	        driver.findElement(workingDays).click();
	        Thread.sleep(1000);


	        driver.findElement(Zones).click();
	        Thread.sleep(1000);
	        
	        
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        Thread.sleep(2000);


	        driver.findElement(timeDropdown).click();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//li[@data-value='08:00 am']")).click();
	        Thread.sleep(1000);

	        driver.findElement(saveButton).click();
	        Thread.sleep(5000);
	    }
	 
	
	

}
