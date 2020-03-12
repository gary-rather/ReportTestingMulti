package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class AuditTrailGOVCCandEFT extends TestBaseReports {
	@BeforeClass
	public void runBeforeClass(){
		log.debug("0 ====== Report AuditTrailGOVCCandEFT ======================================="  );
		super.setTheTest("AuditTrailGOVCCandEFT");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void auditTrailGOVCCandEFT(String atgeChangePersonSSNPartial, String atgeMaskAccountNum,
			String atgeChangeDateStart, String atgeChangeDateEnd) {
        System.out.println("Try AuditTrailGOVCCandEFT");

		if (config.getProperty("reportRequested").equals("audit trail govcc eft data")
		    || this.getTheTest().equals("AuditTrailGOVCCandEFT")) {

			log.debug("Try AuditTrailGOVCCandEFT 1");
			click("atge_reset_menu_xpath");
			click("atge_clear_all_data_xpath");

			//type("atge_changed_person_ssn_prtl_xpath", atgeChangePersonSSNPartial);
			
			//lines 22-29: drop-down selection for Mask Account Number option (will not allow me to use the drop-down method from the test base)
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
