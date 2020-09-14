package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class SpecialDuty extends TestBaseReports {

	@BeforeClass
	public void runBeforeClass(){
		System.out.println("Report SpecialDuty setTheTest: "  );
		super.setTheTest("SpecialDuty");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void specialDuty(String sdDoctype, String sdOrganization, String sdSpecialDutyDateStart,
							String sdSpecialDutyDateEnd) throws InterruptedException {

		System.out.println("Report OCONUS setTheTest: "  );

		runBeforeClass();
		super.setUp();

		System.out.println("Try SpecialDuty 1");

		if (config.getProperty("reportRequested").equalsIgnoreCase("special duty")
				|| this.getTheTest().equals("SpecialDuty")) {

			click("sd_reset_menu_xpath");
			click("sd_clear_all_data_xpath");

			type("sd_organization_xpath", sdOrganization);
			type("sd_special_duty_date_start_xpath", sdSpecialDutyDateStart);
			type("sd_special_duty_date_end_xpath", sdSpecialDutyDateEnd);
			type("sd_doctype_xpath", sdDoctype);
			
			click("sd_run_report_xpath");

		} else {
			
			throw new SkipException("not running this report currently");
			
		}
		
	}
	
}