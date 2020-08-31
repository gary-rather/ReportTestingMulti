package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class ReportPERSTEMPO extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		System.out.println("Report ReportPERSTEMPO setTheTest: "  );
		super.setTheTest("ReportPERSTEMPO");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void reportPERSTEMPO(String perOrganization, String perPerstempoCode, String perPaidDateStart, String perPaidDateEnd) {

		if (config.getProperty("reportRequested").equals("perstempo")
				|| this.getTheTest().equals("ReportPERSTEMPO")) {

			System.out.println("Try ReportPERSTEMPO 1");

			click("per_reset_menu_xpath");
			click("per_clear_all_data_xpath");
			
			type("per_organization_xpath", perOrganization);
			type("per_perstempo_code_xpath", perPerstempoCode);
			type("per_start_date_xpath", perPaidDateStart);
			type("per_end_date_xpath", perPaidDateEnd);
			
			click("per_run_report_xpath");

		} else {
			
			throw new SkipException("not running this report currently");
			
		}

	}
	
}