package pages;

import org.openqa.selenium.By;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class EstimatorLeave {
	WebDriver driver;
	
	    By emailField = By.id("email-login");
	    By passwordField = By.name("password");
	    By loginButton = By.xpath("//button[contains(text(),'Login')]");
	    By estimatorMenu = By.xpath("//div[@role='button']"); 
	    By LeaveRequest = By.xpath("//h6[text() = 'Leave Requests']");
	    By AddLeave = By.xpath("//button[text() = '+ Add Leave']");
	    By LeaveDD = By.xpath("//div[contains(@class , 'MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl css-vak1gp')]");
	    By DateFrom = By.xpath("//input[@type = 'date']");
	    By DateTo = By.id("LeaveTo");
	    By SaveLeave = By.xpath("//button[text() = 'Submit']");
	    
	    	

	    public EstimatorLeave(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void login(String email, String password) throws InterruptedException {
	        driver.findElement(emailField).sendKeys(email);
	        Thread.sleep(1000);
	        driver.findElement(passwordField).sendKeys(password);
	        Thread.sleep(1000);
	        driver.findElement(loginButton).click();
	        Thread.sleep(1000);
	        
	        
	    }

		public void goToAddEstimatorLeave() throws InterruptedException {
			
		    driver.findElement(estimatorMenu).click();
	        Thread.sleep(1000);
	        
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        Thread.sleep(1000);
	        
	        driver.findElement(LeaveRequest).click();
	        Thread.sleep(1000);
	        
	        driver.findElement(AddLeave).click();
	        Thread.sleep(1000);
	        
	        driver.findElement(LeaveDD).click();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//li[text() = 'Sick Leave']")).click();
	        Thread.sleep(1000);
	        
	        driver.findElement(DateFrom).sendKeys("07-09-2025");
	        Thread.sleep(1000);
	        
	        driver.findElement(DateTo).sendKeys("09-09-2025");
	        Thread.sleep(1000);
	        
	        driver.findElement(SaveLeave).click();
	        Thread.sleep(2000);
	        
		}
}

