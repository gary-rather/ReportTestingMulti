package obieeReportsTests;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class ConstructedTravel extends TestBaseReports {

	@BeforeClass
	public void runBeforeClass(){
		log.debug("0 ====== Report ConstructedTravel ======================================="  );
		super.setTheTest("ConstructedTravel");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void constructedTravel(String ctDoctype, String ctOrganization, String ctApproveDateStart,
			String ctApproveDateEnd) throws Exception {
		System.out.println("Try constructedTravel");
		if (config.getProperty("reportRequested").equals("constructed travel")
				|| this.getTheTest().equals("ConstructedTravel")) {

			super.setUp();
			log.debug("Going into Document & Trip Details section");
			driver.findElement(By.xpath(OR.getProperty("document_and_trip_details"))).click();
            Thread.sleep(500);
			log.debug("Testing Constructed Travel Repor 0");
			driver.findElement(By.xpath(OR.getProperty("constructed_travel"))).click();
			Thread.sleep(500);

			log.debug("Testing Constructed Travel Report 1");
			click("ct_reset_menu_xpath");
			click("ct_clear_all_data_xpath");
			Thread.sleep(500);
			type("ct_organization_xpath", ctOrganization);
			type("ct_doctype_xpath", ctDoctype);
			type("ct_approve_date_start_xpath", ctApproveDateStart);
			type("ct_approve_date_end_xpath", ctApproveDateEnd);
			Thread.sleep(500);
			log.debug("Testing Constructed Travel Report 8");
			click("ct_run_report_xpath");
			Thread.sleep(3200);

			this.exportToCSV();
		} else {
			
			throw new SkipException("not running this report currently");

		}
		log.debug("Report ConstructedTravel Complete ##########################");

	}

}
