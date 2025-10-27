package TestScript;

import org.testng.annotations.Test;



import Base.Basetest;
import pages.EstimatorLeave;





public class TestEstimatorLeave extends Basetest {
	
	
	  @Test
	  public void testValidLogin() throws InterruptedException {

	        
	        EstimatorLeave estimatorLeave = new EstimatorLeave(driver);
	        estimatorLeave.goToAddEstimatorLeave("23-10-2025", "27-10-2025");

	        System.out.println("✅ Leave has ben added ");
	    }
}
