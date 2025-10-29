package TestScript;

import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

import listeners.TestListener;
import pages.EstimatorPage;
import Base.Basetest;


@Listeners(TestListener.class)
public class TestEstimator extends Basetest {

    @Test
    public void testAddEstimator() throws InterruptedException {
   

        EstimatorPage estimatorPage = new EstimatorPage(driver);
        estimatorPage.goToAddEstimator();
        
        estimatorPage.addEstimator("jony", "jony.doe@example.com", "9876543238", "111111111111Ab$","111111111111Ab$");

        System.out.println("✅ Estimator added successfully");
    }
}