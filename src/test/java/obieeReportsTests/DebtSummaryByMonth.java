package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class DebtSummaryByMonth extends TestBaseReports {

	@BeforeClass
	public void runBeforeClass(){
		System.out.println("Report DebtSummaryByMonth setTheTest: "  );
		super.setTheTest("DebtSummaryByMonth");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void debtSummaryByMonth(String dsbmRunReportBy, String dsbmServiceName, String dsbmSiteName,
								   String dsbmOrganization) throws InterruptedException {

		System.out.println("Report DebtSummaryByMonth setTheTest: "  );

		runBeforeClass();
		super.setUp();

        System.out.println("Try DebtSummaryByMonth");

		if (config.getProperty("reportRequested").equalsIgnoreCase("debt summary by month")
				|| this.getTheTest().equals("DebtSummaryByMonth")) {

			System.out.println("Try DebtSummaryByMonth 1");

			click("dsbm_reset_menu_xpath");
			click("dsbm_clear_all_data_xpath");

			// lines 19-27: radio button selection for Run Report By (cannot figure out how to code a radio button method in the test base)
			if (dsbmRunReportBy.equalsIgnoreCase("Service Name")) {
				click("dsbm_report_by_service_name_xpath");
			} else if (dsbmRunReportBy.equalsIgnoreCase("Site Name")) {
				click("dsbm_report_by_site_name_xpath");
			} else if (dsbmRunReportBy.equalsIgnoreCase("Organization")) {
				click("dsbm_report_by_org_name_xpath");
			} else {
				throw new SkipException("invalid input - try again");
			}
			System.out.println("Try DebtSummaryByMonth 2");
			click("dsbm_run_selection_xpath");
			
			// lines 33-40: insert service name, site name, or organization name based on radio button selection above
			// these elements were found to be non-interactable
			if (dsbmRunReportBy.equalsIgnoreCase("Service Name")) {
				type("dsbm_service_name_xpath", dsbmServiceName);
			} else if (dsbmRunReportBy.equalsIgnoreCase("Site Name")) {
				type("dsbm_site_name_xpath", dsbmSiteName);
			} else {
				type("dsbm_org_name_xpath", dsbmOrganization);
			}

			click("dsbm_month_field_xpath");
			click("dsbm_month_all_selection_xpath");

			click("dsbm_run_complete_report_xpath");
			
		} else {
			
			throw new SkipException("not running this report currently");
			
		}

	}

}
