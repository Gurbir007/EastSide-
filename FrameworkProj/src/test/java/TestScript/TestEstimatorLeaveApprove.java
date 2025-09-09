package TestScript;

import org.testng.annotations.Test;

import Base.Basetest;
import pages.EstimatorLeave;
import pages.EstimatorLeaveApprove;
import pages.LoginPage;

public class TestEstimatorLeaveApprove extends Basetest{	
	
	@Test
	public void testValidLogin() throws InterruptedException {
      

        EstimatorLeaveApprove estimatorleaveapprove = new  EstimatorLeaveApprove(driver);
        estimatorleaveapprove.UpdateLeaveRequest();
        
        System.out.println("✅ Leave has been Approved by admin");
    }

}
