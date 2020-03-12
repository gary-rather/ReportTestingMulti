package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class TravelerStatus extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report TravelerStatus ======================================="  );
		super.setTheTest("TravelerStatus");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void travelerStatus(String tsOrganization, String tsDprtDateStart, String tsDprtDateEnd,
			String tsTDYAsOfDate) {

		if (config.getProperty("reportRequested").equals("traveler status")
				|| this.getTheTest().equals("TravelerStatus")) {

			log.debug("Try TravelerStatus 1");

			click("ts_reset_menu_xpath");
			click("ts_clear_all_data_xpath");

			type("ts_organization_xpath", tsOrganization);
			type("ts_dprt_date_start_xpath", tsDprtDateStart);
			type("ts_dprt_date_end_xpath", tsDprtDateEnd);
			type("ts_tdy_as_of_date_xpath", tsTDYAsOfDate);

			click("ts_run_report_xpath");

		} else {

			throw new SkipException("not running this report currently");

		}

	}

}
