package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class MilitaryLeave extends TestBaseReports {

	@BeforeClass
	public void runBeforeClass(){
		System.out.println("Report MilitaryLeave setTheTest: "  );
		super.setTheTest("MilitaryLeave");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void militaryLeave(String milDoctype, String milOrganization, String milApproveDateStart,
							  String milApproveDateEnd) throws InterruptedException {

		System.out.println("Report MilitaryLeave setTheTest: "  );

		runBeforeClass();
		super.setUp();

		System.out.println("Try MilitaryLeave");

		if (config.getProperty("reportRequested").equalsIgnoreCase("military leave")
				|| this.getTheTest().equals("MilitaryLeave")) {

			click("mil_reset_menu_xpath");
			click("mil_clear_all_data_xpath");

			type("mil_organization_xpath", milOrganization);
			type("mil_approve_date_start_xpath", milApproveDateStart);
			type("mil_approve_date_end_xpath", milApproveDateEnd);
			type("mil_doctype_xpath", milDoctype);
			
			click("mil_run_report_xpath");

		} else {
			
			throw new SkipException("not running this report currently");
			
		}

	}

}
