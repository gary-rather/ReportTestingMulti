package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class AuditTrailUserData extends TestBaseReports {

	@BeforeClass
	public void runBeforeClass(){
		log.debug("0 ====== Report AuditTrailUserData ======================================="  );
		super.setTheTest("AuditTrailUserData");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void auditTrailUserData(String atuChangePersonSSNPartial, String atuChangeDateStart, String atuChangeDateEnd) {
		System.out.println("Try auditTrailUserData");
		if (config.getProperty("reportRequested").equals("audit trail user data")
				|| this.getTheTest().equals("AuditTrailUserData")) {

			log.debug("Try auditTrailUserData 1");
			click("atu_reset_menu_xpath");
			click("atu_clear_all_data_xpath");
			
			type("atu_changed_person_ssn_prtl_xpath", atuChangePersonSSNPartial);
			type("atu_change_date_start_xpath", atuChangeDateStart); 
			type("atu_change_date_end_xpath", atuChangeDateEnd);
			
			click("atu_run_report_xpath");
			
		} else {
			
			throw new SkipException("not running this report currently");
			
		}
		
	}

}
