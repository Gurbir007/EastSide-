package TestScript;

import org.testng.annotations.Test;

import Base.Basetest;
import pages.GenerateReport;

public class TestGenerateReport extends Basetest {
    
	@Test
	public void Report() throws InterruptedException {

		GenerateReport generatereport = new GenerateReport(driver);
		generatereport.GenReport("23-10-2025" , "23-10-2025");
		
		Thread.sleep(2000);

	}

}

