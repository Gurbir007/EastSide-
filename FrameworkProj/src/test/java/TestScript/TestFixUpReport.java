package TestScript;

import org.testng.annotations.Test;

import Base.Basetest;
import pages.FixUpReport;

public class TestFixUpReport extends Basetest{
	
	@Test
	public void FixupAnylysis() throws InterruptedException {
		 FixUpReport quotereport= new FixUpReport(driver);
		 quotereport.Quotereport("23-10-2025" , "23-10-2025" ,"Q123" ,"22-10-2025" ,"John" ,"Aus" , "Bergstrom" ,"Not good" , "test" , "31-10-2025");
		 

	}
	
}
