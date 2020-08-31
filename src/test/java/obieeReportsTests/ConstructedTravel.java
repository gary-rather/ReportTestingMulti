package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class ConstructedTravel extends TestBaseReports {

	@BeforeClass
	public void runBeforeClass(){
		log.debug("2 ====== Report ConstructedTravel ======================================="  );
		super.setTheTest("ConstructedTravel");
		log.debug("this.getTheTest(): "  +  this.getTheTest());
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void constructedTravel(String ctDoctype, String ctOrganization, String ctApproveDateStart,
			String ctApproveDateEnd) {
		System.out.println("Try constructedTravel");
		if (config.getProperty("reportRequested").equals("constructed travel")
				|| this.getTheTest().equals("ConstructedTravel")) {

			System.out.println("Try ConstructedTravel 1");
			click("ct_reset_menu_xpath");
			click("ct_clear_all_data_xpath");

			type("ct_organization_xpath", ctOrganization);
			type("ct_doctype_xpath", ctDoctype);
			type("ct_approve_date_start_xpath", ctApproveDateStart);
			type("ct_approve_date_end_xpath", ctApproveDateEnd);

			click("ct_run_report_xpath");

		} else {
			
			throw new SkipException("not running this report currently");

		}

	}

}
