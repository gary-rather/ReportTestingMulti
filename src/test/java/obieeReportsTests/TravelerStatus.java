package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TravelerStatus extends TestBaseReports {

	@BeforeClass
	public void runBeforeClass(){
		System.out.println("Report TravelerStatus setTheTest: "  );
		super.setTheTest("TravelerStatus");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void travelerStatus(String tsShowCosts, String tsDprtDateStart, String tsDprtDateEnd,
							   String tsTDYAsOfDate) throws InterruptedException {

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

			Thread.sleep(1000);
			click("ts_partner_system_field_xpath");
			click("ts_partner_system_all_selection_xpath");
			Thread.sleep(1000);
			click("ts_partner_system_all_selection_xpath");
			click("ts_partner_system_field_xpath");

			click("ts_show_costs_dropdown_xpath");
			if(tsShowCosts.equalsIgnoreCase("Yes")) {
				click("ts_show_costs_yes_xpath");
			} else if(tsShowCosts.equalsIgnoreCase("No")) {
				click("ts_show_costs_no_xpath");
			} else {
				throw new SkipException("invalid input - try again");
			}

			Thread.sleep(1000);
			type("ts_dprt_date_start_xpath", tsDprtDateStart);
			type("ts_dprt_date_end_xpath", tsDprtDateEnd);
			type("ts_tdy_as_of_date_xpath", tsTDYAsOfDate);

			Thread.sleep(1000);
			click("ts_run_report_xpath");

		} else {

			throw new SkipException("not running this report currently");

		}

	}

}
