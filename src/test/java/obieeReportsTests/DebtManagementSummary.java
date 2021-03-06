package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class DebtManagementSummary extends TestBaseReports {

	@BeforeClass
	public void runBeforeClass(){
		System.out.println("Report DebtManagementSummary setTheTest: "  );
		super.setTheTest("DebtManagementSummary");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void debtManagementSummary(String dmsOrganization) throws InterruptedException {

		System.out.println("Report DebtManagementSummary setTheTest: "  );

		runBeforeClass();
		super.setUp();

		System.out.println("Try DebtManagementSummary");

		if (config.getProperty("reportRequested").equalsIgnoreCase("debt management summary")
				|| this.getTheTest().equals("DebtManagementSummary")) {

			System.out.println("Try DebtManagementSummary 1");

			click("dms_reset_menu_xpath");
			click("dms_clear_all_date_xpath");
			type("dms_organization_xpath", dmsOrganization);
			click("dms_run_report_xpath");

		} else {
			
			throw new SkipException("not running this report currently");

		}

	}

}