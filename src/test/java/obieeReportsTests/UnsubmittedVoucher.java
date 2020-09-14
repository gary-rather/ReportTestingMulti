package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class UnsubmittedVoucher extends TestBaseReports {

	@BeforeClass
	public void runBeforeClass(){
		System.out.println("Report UnsubmittedVoucher setTheTest: "  );
		super.setTheTest("UnsubmittedVoucher");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void unsubmittedVoucher(String uvPartnerSystemCode, String uvRtrnDateStart,
								   String uvRtrnDateEnd, String uvDaysSinceReturn) throws InterruptedException {

		System.out.println("Report UnsubmittedVoucher setTheTest: "  );

		runBeforeClass();
		super.setUp();

		System.out.println("Try UnsubmittedVoucher");

		if (config.getProperty("reportRequested").equalsIgnoreCase("unsubmitted voucher")
				|| this.getTheTest().equals("UnsubmittedVoucher")) {

			System.out.println("Try UnsubmittedVoucher 1");

			click("uv_reset_menu_xpath");
			click("uv_reset_to_default_xpath");

			click("uv_organization_field_xpath");
			click("uv_organization_all_selection_xpath");

			type("uv_partner_sys_code_xpath", uvPartnerSystemCode);
			type("uv_rtrn_date_start_xpath", uvRtrnDateStart);
			type("uv_rtrn_date_end_xpath", uvRtrnDateEnd);
			type("uv_days_since_return_xpath", uvDaysSinceReturn);

			click("uv_run_report_xpath");

		} else {

			throw new SkipException("not running this report currently");

		}

	}

}
