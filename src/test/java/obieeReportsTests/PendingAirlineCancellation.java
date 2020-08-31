package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class PendingAirlineCancellation extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		System.out.println("Report PendingAirlineCancellation setTheTest: "  );
		super.setTheTest("PendingAirlineCancellation");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void pendingAirlineCancellation(String pacHrsToDprtStart, String pacHrsToDprtEnd, String pacAgencyCode, String pacOrgCode) {
        System.out.println("Try PendingAirlineCancellation");
		if (config.getProperty("reportRequested").equals("pending airline cancellation")
				|| this.getTheTest().equals("PendingAirlineCancellation")) {

			System.out.println("Try PendingAirlineCancellation 1");

			click("pac_reset_menu_xpath");
			click("pac_clear_all_data_xpath");

			System.out.println("Try PendingAirlineCancellation 2");
			type("pac_hrs_to_dprt_start_xpath", pacHrsToDprtStart);
			type("pac_hrs_to_dprt_end_xpath", pacHrsToDprtEnd);
			type("pac_agency_code_xpath", pacAgencyCode);
			type("pac_org_code_xpath", pacOrgCode);

			System.out.println("Try PendingAirlineCancellation 3");
			click("pac_run_report_xpath");

		} else {

			throw new SkipException("not running this report currently");

		}

	}

}
