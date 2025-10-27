package TestScript;

import org.testng.annotations.Test;

import Base.Basetest;
import pages.DeliveryReport;

public class TestDeliveryReport extends Basetest {
    
	@Test
	public void createDelreport() {
		
		DeliveryReport deliverreport = new DeliveryReport(driver);
		deliverreport.ExtraDelreport("27-10-2025", "Q1234", "Austrlia" , "aus" ,"screw", "Not good");
		
		
		
	}
}
