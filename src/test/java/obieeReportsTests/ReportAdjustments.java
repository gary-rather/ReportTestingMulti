package obieeReportsTests;

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
	public void reportAdjustments(String adjOrganization, String adjDoctype, String adjAdjustmentDateStart,
			String adjAdjustmentDateEnd, String adjTravelerLastName, String adjTravelerFirstName,
			String adjTravelerPartialSSN) {
            System.out.println("Try reportAdjustments");
		if (config.getProperty("reportRequested").equals("adjustments")
				|| this.getTheTest().equals("ReportAdjustments")) {

			log.debug("Try reportAdjustments 1");

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
			click("adj_run_report_xpath");

		} else {

			throw new SkipException("not running this report currently");

		}

	}

}
