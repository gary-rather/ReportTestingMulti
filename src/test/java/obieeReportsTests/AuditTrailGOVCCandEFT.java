package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class AuditTrailGOVCCandEFT extends TestBaseReports {
	@BeforeClass
	public void runBeforeClass(){
		log.debug("2 ====== Report AuditTrailGOVCCandEFT ======================================="  );
		super.setTheTest("AuditTrailGOVCCandEFT");
		log.debug("this.getTheTest(): "  +  this.getTheTest());
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void auditTrailGOVCCandEFT(String atgeChangePersonSSNPartial, String atgeMaskAccountNum,
			String atgeChangeDateStart, String atgeChangeDateEnd) {
        System.out.println("Try AuditTrailGOVCCandEFT");

		if (config.getProperty("reportRequested").equalsIgnoreCase("audit trail govcc eft data")
		    || this.getTheTest().equals("AuditTrailGOVCCandEFT")) {

			System.out.println("Try AuditTrailGOVCCandEFT 1");
			click("atge_reset_menu_xpath");
			click("atge_clear_all_data_xpath");

			type("atge_changed_person_ssn_prtl_xpath", atgeChangePersonSSNPartial);

			click("atge_mask_account_num_dropdown_xpath");
			if(atgeMaskAccountNum.equalsIgnoreCase("Y")) {
				click("atge_mask_account_num_yes_xpath");
			} else if(atgeMaskAccountNum.equalsIgnoreCase("N")) {
				click("atge_mask_account_num_no_xpath");
			} else {
				throw new SkipException("invalid input - try again");
			}
			
			type("atge_change_date_start_xpath", atgeChangeDateStart);
			type("atge_change_date_end_xpath", atgeChangeDateEnd);

			click("atge_run_report_xpath");

		} else {

			throw new SkipException("not running this report currently");

		}

	}

}
