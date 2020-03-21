package obieeReportsTests;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class PendingAirlineCancellation extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report PendingAirlineCancellation ======================================="  );
		super.setTheTest("PendingAirlineCancellation");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void pendingAirlineCancellation(String pacHrsToDprtStart, String pacHrsToDprtEnd, String pacAgencyCode, String pacOrgCode) throws Exception {
		log.debug("Try PendingAirlineCancellation");
		if (this.getTheTest().equals("PendingAirlineCancellation")) {

			this.setUp();

			log.debug("Try PendingAirlineCancellation 1");
			log.debug("Going into Document & Trip Status section");
			driver.findElement(By.xpath(OR.getProperty("document_and_trip_status"))).click();

				log.debug("Testing Pending Airline Cancellation Report");
				driver.findElement(By.xpath(OR.getProperty("pending_airline_cancellation"))).click();


			click("pac_reset_menu_xpath");
			click("pac_clear_all_data_xpath");

			Thread.sleep(1000);
			log.debug("Try PendingAirlineCancellation 2");
			type("pac_hrs_to_dprt_start_xpath", pacHrsToDprtStart);
			type("pac_hrs_to_dprt_end_xpath", pacHrsToDprtEnd);
			type("pac_agency_code_xpath", pacAgencyCode);
			type("pac_org_code_xpath", pacOrgCode);

			Thread.sleep(1000);
			log.debug("Try PendingAirlineCancellation 3");
			click("pac_run_report_xpath");

			Thread.sleep(2000);
			this.exportToCSV();

		} else {

			throw new SkipException("not running this report currently");

		}
		log.debug("Report PendingAirlineCancellation Complete ##########################");
	}

}
