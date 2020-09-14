package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class ReportPERSTEMPO extends TestBaseReports {

	@BeforeClass
	public void runBeforeClass(){
		System.out.println("Report ReportPERSTEMPO setTheTest: "  );
		super.setTheTest("ReportPERSTEMPO");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void reportPERSTEMPO(String perPerstempoCode, String perPaidDateStart,
								String perPaidDateEnd) throws InterruptedException {

		System.out.println("Report PERSTEMPO setTheTest: "  );

		runBeforeClass();
		super.setUp();

		System.out.println("Try ReportPERSTEMPO");

		if (config.getProperty("reportRequested").equalsIgnoreCase("perstempo")
				|| this.getTheTest().equals("ReportPERSTEMPO")) {

			click("per_reset_menu_xpath");
			click("per_reset_to_default_xpath");
			
			click("per_organization_field_xpath");
			click("per_organization_all_selection_xpath");

			type("per_paid_date_start_xpath", perPaidDateStart);
			type("per_paid_date_end_xpath", perPaidDateEnd);
			
			click("per_run_report_xpath");

		} else {
			
			throw new SkipException("not running this report currently");
			
		}

	}
	
}