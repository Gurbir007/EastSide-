package TestScript;

import org.testng.annotations.Test;


import Base.Basetest;
import pages.EstimatorLeave;
import pages.LoginPage;



public class TestEstimatorLeave extends Basetest {
	
	
	  @Test
	  public void testValidLogin() throws InterruptedException {
	        LoginPage loginPage = new LoginPage(driver);

	        loginPage.login("Lisa.doe@example.com", "111111111111Ab$");
	        Thread.sleep(2000);
	        
	        EstimatorLeave estimatorLeave = new EstimatorLeave(driver);
	        estimatorLeave.goToAddEstimatorLeave();

	        System.out.println("✅ Leave has ben added ");
	    }
}
