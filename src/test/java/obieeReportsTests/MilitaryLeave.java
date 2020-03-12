package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class MilitaryLeave extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report MilitaryLeave ======================================="  );
		super.setTheTest("MilitaryLeave");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void militaryLeave(String milDoctype, String milOrganization, String milApproveDateStart, String milApproveDateEnd) {

		if (config.getProperty("reportRequested").equals("military leave")
				|| this.getTheTest().equals("MilitaryLeave")) {

			log.debug("Try MilitaryLeave 1");

			click("mil_reset_menu_xpath");
			click("mil_clear_all_data_xpath");
			
			type("mil_doctype_xpath", milDoctype);
			type("mil_organization_xpath", milOrganization);
			type("mil_start_date_xpath", milApproveDateStart);
			type("mil_end_date_xpath", milApproveDateEnd);
			
			click("mil_run_report_xpath");

		} else {
			
			throw new SkipException("not running this report currently");
			
		}

	}

}
