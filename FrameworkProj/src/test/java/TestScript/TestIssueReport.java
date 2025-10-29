package TestScript;

import org.testng.annotations.Test;
import Base.Basetest;
import pages.IssueReport;

public class TestIssueReport extends Basetest {

	IssueReport ir;

	@Test
	public void fillIssueReportForm() throws InterruptedException {

		ir = new IssueReport(driver);

		ir.enterIssueReport("30-10-2025", "30-10-2025", "QOUTE-9876", "John", "Australia", "Aus", "9876543219", "15",
				"Wood damaged & broken", "JobRef98", "Replaced 2 panels", "500", "Worker-2");

		System.out.println("Issue Report Submitted Successfully ✅");
		
		Thread.sleep(1000);
	}
}
