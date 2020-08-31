package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class DebtManagementHistory extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		System.out.println("Report DebtManagementHistory setTheTest: "  );
		super.setTheTest("DebtManagementHistory");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void debtManagementHistory(String dmhOrganization) {
		System.out.println("Try debtManagementHistory");
		if (config.getProperty("reportRequested").equals("debt management history")
				|| this.getTheTest().equals("DebtManagementHistory")) {

			System.out.println("Try DebtManagementHistory 1");

			click("dmh_reset_menu_xpath");
			click("dmh_clear_all_date_xpath");
			type("dmh_organization_xpath", dmhOrganization);
			click("dmh_run_report_xpath");

		} else {
			
			throw new SkipException("not running this report currently");

		}
		
	}

}
