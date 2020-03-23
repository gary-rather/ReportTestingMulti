package obieeReportsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class AuditTrailPersonData extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report AuditTrailPersonData ======================================="  );
		super.setTheTest("AuditTrailPersonData");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void auditTrailPersonData(String atpChangePersonSSNPartial, String atpChangeDateStart,
			String atpChangeDateEnd) throws Exception{
		log.debug("Report AuditTrailPersonData: " + this.getTheTest() );
		log.debug("Report AuditTrailPersonData: " + config.getProperty("reportRequested"));

		super.setUp();

		if (config.getProperty("reportRequested").equals("audit trail person data")
				|| this.getTheTest().equals("AuditTrailPersonData")) {

		driver.findElement(By.xpath(OR.getProperty("traveler_and_user_info"))).click();
		log.debug("Try Traveler and User Info 1");
		Thread.sleep(500);

		System.out.println("Going into Audit Trail reports");
		driver.findElement(By.xpath(OR.getProperty("audit_trail_all_reports"))).click();

		log.debug("Testing Audit Trail Traveler Data Report");
		driver.findElement(By.xpath(OR.getProperty("audit_trail_person_data"))).click();

			Thread.sleep(500);
			log.debug("Try auditTrailPersonData 1");
			click("atp_reset_menu_xpath");
			click("atp_clear_all_data_xpath");
			Thread.sleep(500);

			type("atp_changed_person_ssn_prtl_xpath", atpChangePersonSSNPartial);
			type("atp_change_date_start_xpath", atpChangeDateStart);
			type("atp_change_date_end_xpath", atpChangeDateEnd);

			Thread.sleep(500);
			System.out.println("Try auditTrailPersonData 3");
			click("atp_run_report_xpath");

			this.exportToCSV();
			this.status = true;
		} else {

			throw new SkipException("not running this report currently");

		}
		log.debug("Leaving "+ this.theTest);
	}

}
