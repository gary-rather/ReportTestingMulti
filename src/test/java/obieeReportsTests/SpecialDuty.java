package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class SpecialDuty extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report SpecialDuty ======================================="  );
		super.setTheTest("SpecialDuty");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void specialDuty(String sdDoctype, String sdOrganization, String sdStartDate, String sdEndDate) {
		
		if (config.getProperty("reportRequested").equals("special duty")
				|| this.getTheTest().equals("SpecialDuty")) {

			log.debug("Try SpecialDuty 1");

			click("sd_reset_menu_xpath");
			click("sd_clear_all_data_xpath");
			
			type("sd_doctype_xpath", sdDoctype);
			type("sd_organization_xpath", sdOrganization);
			type("sd_start_date_xpath", sdStartDate);
			type("sd_end_date_xpath", sdEndDate);
			
			click("sd_run_report_xpath");

		} else {
			
			throw new SkipException("not running this report currently");
			
		}
		
	}
	
}