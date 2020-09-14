package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class ReportAdjustments extends TestBaseReports {

	@BeforeClass
	public void runBeforeClass(){
		System.out.println("Report ReportAdjustments setTheTest: "  );
		super.setTheTest("ReportAdjustments");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void reportAdjustments(String adjOrganization, String adjDoctype, String adjAdjustmentDateStart,
			String adjAdjustmentDateEnd, String adjTravelerLastName, String adjTravelerFirstName,
			String adjTravelerPartialSSN) throws InterruptedException {

		System.out.println("Report Adjustments setTheTest: "  );

		runBeforeClass();
		super.setUp();

		System.out.println("Try reportAdjustments");

		if (config.getProperty("reportRequested").equalsIgnoreCase("adjustments")
				|| this.getTheTest().equals("ReportAdjustments")) {

			click("adj_reset_menu_xpath");
			click("adj_clear_all_data_xpath");

			System.out.println("Try reportAdjustments 2");
			type("adj_organization_xpath", adjOrganization);
			type("adj_doctype_xpath", adjDoctype);
			type("adj_adjustment_date_start_xpath", adjAdjustmentDateStart);
			type("adj_adjustment_date_end_xpath", adjAdjustmentDateEnd);

			System.out.println("Try reportAdjustments 3");
			type("adj_traveler_last_name_xpath", adjTravelerLastName);
			type("adj_traveler_first_name_xpath", adjTravelerFirstName);
			type("adj_traveler_partial_ssn_xpath", adjTravelerPartialSSN);

			System.out.println("Try reportAdjustments 4");
			click("adj_run_report_xpath");

		} else {

			throw new SkipException("not running this report currently");

		}

	}

}
