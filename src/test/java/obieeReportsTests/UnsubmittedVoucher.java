package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class UnsubmittedVoucher extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report UnsubmittedVoucher ======================================="  );
		super.setTheTest("UnsubmittedVoucher");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void unsubmittedVoucher(String uvOrganization, String uvRtrnDateStart, String uvRtrnDateEnd,
			String uvDaysSinceReturn) {
        System.out.println("Try UnsubmittedVoucher");
		if (config.getProperty("reportRequested").equals("unsubmitted voucher")
				|| this.getTheTest().equals("UnsubmittedVoucher")) {

			log.debug("Try UnsubmittedVoucher 1");

			click("uv_reset_menu_xpath");
			click("uv_clear_all_data_xpath");

			type("uv_organization_xpath", uvOrganization);
			type("uv_rtrn_date_start_xpath", uvRtrnDateStart);
			type("uv_rtrn_date_end_xpath", uvRtrnDateEnd);
			type("uv_days_since_return_xpath", uvDaysSinceReturn);

			click("uv_run_report_xpath");

		} else {

			throw new SkipException("not running this report currently");

		}

	}

}
