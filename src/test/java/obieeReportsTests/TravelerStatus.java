package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class TravelerStatus extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		System.out.println("Report TravelerStatus setTheTest: "  );
		super.setTheTest("TravelerStatus");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void travelerStatus(String tsOrganization, String tsPartnerSystemCode, String tsShowCosts,
							   String tsDprtDateStart, String tsDprtDateEnd, String tsTDYAsOfDate) {

		if (config.getProperty("reportRequested").equalsIgnoreCase("traveler status")
				|| this.getTheTest().equals("TravelerStatus")) {

			System.out.println("Try TravelerStatus 1");

			click("ts_reset_menu_xpath");
			click("ts_clear_all_data_xpath");

			type("ts_organization_xpath", tsOrganization);
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
