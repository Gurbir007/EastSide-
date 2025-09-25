package TestScript;

import org.testng.annotations.Test;

		 

import Base.Basetest;
import pages.EstimatorPage;


public class TestEstimator extends Basetest {

    @Test
    public void testAddEstimator() throws InterruptedException {
   

        EstimatorPage estimatorPage = new EstimatorPage(driver);
        estimatorPage.goToAddEstimator();
        
        estimatorPage.addEstimator("Milan E", "Milan.doe@example.com", "9876543230", "111111111111Ab$","111111111111Ab$");

        System.out.println("✅ Estimator added successfully");
    }
}