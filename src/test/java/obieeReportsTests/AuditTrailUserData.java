package obieeReportsTests;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class AuditTrailUserData extends TestBaseReports {

	@BeforeClass
	public void runBeforeClass(){
		log.debug("0 ====== Report AuditTrailUserData ======================================="  );
		super.setTheTest("AuditTrailUserData");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void auditTrailUserData(String atuChangePersonSSNPartial, String atuChangeDateStart, String atuChangeDateEnd) throws Exception {
		System.out.println("Try auditTrailUserData");
		if (config.getProperty("reportRequested").equals("audit trail user data")
				|| this.getTheTest().equals("AuditTrailUserData")) {

			super.setUp();;


			driver.findElement(By.xpath(OR.getProperty("traveler_and_user_info"))).click();
			log.debug("Try Traveler and User Info 1");
			Thread.sleep(500);

			System.out.println("Going into Audit Trail reports");
			driver.findElement(By.xpath(OR.getProperty("audit_trail_all_reports"))).click();

			log.debug("Testing Audit Trail user Data Report");
			driver.findElement(By.xpath(OR.getProperty("audit_trail_user_data"))).click();
			Thread.sleep(500);
			log.debug("Try auditTrailUserData 1");
			click("atu_reset_menu_xpath");
			click("atu_clear_all_data_xpath");
			Thread.sleep(500);
			type("atu_changed_person_ssn_prtl_xpath", atuChangePersonSSNPartial);
			type("atu_change_date_start_xpath", atuChangeDateStart); 
			type("atu_change_date_end_xpath", atuChangeDateEnd);
			Thread.sleep(500);
			
			click("atu_run_report_xpath");
			Thread.sleep(500);
			this.exportToCSV();
		} else {
			
			throw new SkipException("not running this report currently");
			
		}
		
	}

}
