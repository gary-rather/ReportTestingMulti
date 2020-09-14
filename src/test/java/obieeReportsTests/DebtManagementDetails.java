package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class DebtManagementDetails extends TestBaseReports {

	@BeforeClass
	public void runBeforeClass(){
		System.out.println("Report DebtManagementDetails setTheTest: "  );
		super.setTheTest("DebtManagementDetails");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void debtManagementDetails(String dmdOrganization) throws InterruptedException {

		System.out.println("Report DebtManagementDetails setTheTest: "  );

		runBeforeClass();
		super.setUp();

		System.out.println("Try DebtManagementDetails");

		if (config.getProperty("reportRequested").equalsIgnoreCase("debt management details")
				|| this.getTheTest().equals("DebtManagementDetails")) {

			System.out.println("Try DebtManagementDetails 1");

			click("dmd_reset_menu_xpath");
			click("dmd_clear_all_date_xpath");
			type("dmd_organization_xpath", dmdOrganization);
			click("dmd_run_report_xpath");

		} else {
			
			throw new SkipException("not running this report currently");

		}
		
	}

}
