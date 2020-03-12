package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class DebtManagementSummary extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report DebtManagementSummary ======================================="  );
		super.setTheTest("DebtManagementSummary");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void debtManagementSummary(String dmsOrganization) {

		if (config.getProperty("reportRequested").equals("debt management summary")
				|| this.getTheTest().equals("DebtManagementSummary")) {

			log.debug("Try DebtManagementSummary 1");

			click("dms_reset_menu_xpath");
			click("dms_clear_all_date_xpath");
			type("dms_organization_xpath", dmsOrganization);
			click("dms_run_report_xpath");

		} else {
			
			throw new SkipException("not running this report currently");

		}

	}

}