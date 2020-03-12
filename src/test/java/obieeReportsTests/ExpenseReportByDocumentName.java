package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class ExpenseReportByDocumentName extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report ExpenseReportByDocumentName ======================================="  );
		super.setTheTest("ExpenseReportByDocumentName");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void expenseReportByDocumentName(String erdnOrganization, String erdnApproveDateStart, String erdnApproveDateEnd) {

		if (config.getProperty("reportRequested").equals("expense report by document name")
				|| this.getTheTest().equals("ExpenseReportByDocumentName")) {

			log.debug("Try ExpenseReportByDocumentName 1");

			click("erc_reset_menu_xpath");
			click("erc_clear_all_data_xpath");
			
			type("erdn_organization_xpath", erdnOrganization);
			type("erdn_approve_date_start_xpath", erdnApproveDateStart);
			type("erdn_approved_date_end_xpath", erdnApproveDateEnd);
			
			click("erdn_run_report_xpath");

		} else {
			
			throw new SkipException("not running this report currently");
			
		}

	}

}