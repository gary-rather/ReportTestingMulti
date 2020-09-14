package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class TravelerStatus extends TestBaseReports {

	@BeforeClass
	public void runBeforeClass(){
		System.out.println("Report TravelerStatus setTheTest: "  );
		super.setTheTest("TravelerStatus");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void travelerStatus(String tsPartnerSystemCode, String tsShowCosts, String tsDprtDateStart,
							   String tsDprtDateEnd, String tsTDYAsOfDate) throws InterruptedException {

		System.out.println("Report TravelerStatus setTheTest: "  );

		runBeforeClass();
		super.setUp();

		System.out.println("Try TravelerStatus");

		if (config.getProperty("reportRequested").equalsIgnoreCase("traveler status")
				|| this.getTheTest().equals("TravelerStatus")) {

			System.out.println("Try TravelerStatus 1");

			click("ts_reset_menu_xpath");
			click("ts_reset_to_default_xpath");

			click("ts_organization_field_xpath");
			click("ts_organization_all_selection_xpath");
			click("ts_organization_field_xpath");

			type("ts_partner_sys_code_xpath", tsPartnerSystemCode);

			click("ts_show_costs_dropdown_xpath");
			if(tsShowCosts.equalsIgnoreCase("Y")) {
				click("ts_show_costs_yes_xpath");
			} else if(tsShowCosts.equalsIgnoreCase("N")) {
				click("ts_show_costs_no_xpath");
			} else {
				throw new SkipException("invalid input - try again");
			}

			type("ts_dprt_date_start_xpath", tsDprtDateStart);
			type("ts_dprt_date_end_xpath", tsDprtDateEnd);
			type("ts_tdy_as_of_date_xpath", tsTDYAsOfDate);

			click("ts_run_report_xpath");

		} else {

			throw new SkipException("not running this report currently");

		}

	}

}
