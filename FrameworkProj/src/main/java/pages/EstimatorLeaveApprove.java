package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EstimatorLeaveApprove {
	WebDriver driver;

    By estimatorMenu = By.xpath("//div[@role='button']"); 
    By LeaveRequest = By.xpath("//h6[text() = 'Leave Requests']");
    By EditLeave =    By.xpath("//table/tbody/tr[5]//button[@aria-label='Edit']");
    By ApproveLeave = By.xpath("//div[text() = 'Pending']");
    By Submit = By.xpath("//button[text() = 'Update Leave']");

    public EstimatorLeaveApprove(WebDriver driver) {
        this.driver = driver;
    }

    

	public void UpdateLeaveRequest() throws InterruptedException {
	
		   driver.findElement(estimatorMenu).click();
	        Thread.sleep(2000);
	        
	        driver.findElement(LeaveRequest).click();
	        Thread.sleep(1000);
	        
	        driver.findElement(EditLeave).click();
	        Thread.sleep(1000);
	        
	        driver.findElement(ApproveLeave).click();
	        Thread.sleep(1000);
	        
	        driver.findElement(By.xpath("//li[text() = 'Approved']")).click();
	        Thread.sleep(2000);
	        
	        driver.findElement(Submit).click();
	        Thread.sleep(2000);
	        
	}       
		
	}
