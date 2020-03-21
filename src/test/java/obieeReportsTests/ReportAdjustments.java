package obieeReportsTests;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class ReportAdjustments extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report ReportAdjustments ======================================="  );
		super.setTheTest("ReportAdjustments");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void reportAdjustments(String adjOrganization,
								  String adjDoctype,
								  String adjAdjustmentDateStart,
								  String adjAdjustmentDateEnd,
								  String adjTravelerLastName,
								  String adjTravelerFirstName,
			                      String adjTravelerPartialSSN) throws Exception {
            System.out.println("Try reportAdjustments");
		if (this.getTheTest().equals("ReportAdjustments")) {

			this.setUp();

			log.debug("Try reportAdjustments 1");
			log.debug("Going into Document & Trip Details section");
			driver.findElement(By.xpath(OR.getProperty("document_and_trip_details"))).click();


				log.debug("Testing Adjustments Report");
				driver.findElement(By.xpath(OR.getProperty("adjustments"))).click();

				Thread.sleep(1000);
				click("adj_reset_menu_xpath");
			click("adj_clear_all_data_xpath");

			System.out.println("Try reportAdjustments 2");
			type("adj_organization_xpath", adjOrganization);
			type("adj_doctype_xpath", adjDoctype);
			type("adj_adjustment_date_start_xpath", adjAdjustmentDateStart);

			System.out.println("Try reportAdjustments 3");
			type("adj_adjustment_date_end_xpath", adjAdjustmentDateEnd);
			type("adj_traveler_last_name_xpath", adjTravelerLastName);
			type("adj_traveler_first_name_xpath", adjTravelerFirstName);
			type("adj_traveler_partial_ssn_xpath", adjTravelerPartialSSN);

			System.out.println("Try reportAdjustments 5");
			Thread.sleep(1000);
			click("adj_run_report_xpath");

			Thread.sleep(1000);

			this.exportToCSV();

		} else {

			throw new SkipException("not running this report currently");

		}
		log.debug("Report ReportAdjustments Complete ##########################");
	}

}
