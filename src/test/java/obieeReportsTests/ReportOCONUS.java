package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class ReportOCONUS extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		System.out.println("Report ReportOCONUS setTheTest: "  );
		super.setTheTest("ReportOCONUS");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void reportOCONUS(String ocOrganization, String ocDoctype, String ocCivMilIndicator,
			String ocApproveDateStart, String ocApproveDateEnd) {
        System.out.println("Try ReportOCONUS");
		if (config.getProperty("reportRequested").equals("oconus")
				|| this.getTheTest().equals("ReportOCONUS")) {

			System.out.println("Try ReportOCONUS 1");

			click("oc_reset_menu_xpath");
			click("oc_clear_all_data_xpath");

			type("oc_organization_xpath", ocOrganization);
			type("oc_doctype_xpath", ocDoctype);
			type("oc_civ_mil_ind_xpath", ocCivMilIndicator);
			type("oc_start_date_xpath", ocApproveDateStart);
			type("oc_end_date_xpath", ocApproveDateEnd);

			click("oc_run_report_xpath");

		} else {

			throw new SkipException("not running this report currently");

		}

	}

}