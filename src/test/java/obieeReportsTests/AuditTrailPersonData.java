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
		System.out.println("Report AuditTrailPersonData setTheTest: "  );
		super.setTheTest("AuditTrailPersonData");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void auditTrailPersonData(String atpChangePersonSSNPartial, String atpChangeDateStart,
			String atpChangeDateEnd) {
		System.out.println("Report AuditTrailPersonData: " + this.getTheTest() );
		System.out.println("Report AuditTrailPersonData: " + config.getProperty("reportRequested"));
		log.debug("Going into Traveler & User Information section");
		WebElement ti = driver.findElement(By.xpath("//span[text()[contains(.,'Traveler & User Information Dashboard')]]"));
		ti.click();

		System.out.println("Going into Audit Trail reports");
		driver.findElement(By.xpath(OR.getProperty("audit_trail_all_reports"))).click();

		log.debug("Testing Audit Trail Traveler Data Report");
		driver.findElement(By.xpath(OR.getProperty("audit_trail_person_data"))).click();

		System.out.println("Try auditTrailPersonData");
		if (config.getProperty("reportRequested").equals("audit trail person data")
				|| this.getTheTest().equals("AuditTrailPersonData")) {

			System.out.println("Try auditTrailPersonData 1");
			click("atp_reset_menu_xpath");
			click("atp_clear_all_data_xpath");

			System.out.println("Try auditTrailPersonData 2");
			type("atp_changed_person_ssn_prtl_xpath", atpChangePersonSSNPartial);
			type("atp_change_date_start_xpath", atpChangeDateStart);
			type("atp_change_date_end_xpath", atpChangeDateEnd);

			System.out.println("Try auditTrailPersonData 3");
			click("atp_run_report_xpath");

		} else {

			throw new SkipException("not running this report currently");

		}

	}

}
