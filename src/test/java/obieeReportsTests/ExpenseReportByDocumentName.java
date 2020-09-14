package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class ExpenseReportByDocumentName extends TestBaseReports {

	@BeforeClass
	public void runBeforeClass(){
		System.out.println("Report ExpenseReportByDocumentName setTheTest: "  );
		super.setTheTest("ExpenseReportByDocumentName");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void expenseReportByDocumentName(String erdnOrganization, String erdnApproveDateStart,
											String erdnApproveDateEnd) throws InterruptedException {

		System.out.println("Report ExpenseReportByDocumentName setTheTest: "  );

		runBeforeClass();
		super.setUp();

		System.out.println("Try ExpenseReportByDocumentName");

		if (config.getProperty("reportRequested").equalsIgnoreCase("expense report by document name")
				|| this.getTheTest().equals("ExpenseReportByDocumentName")) {

			click("erdn_reset_menu_xpath");
			click("erdn_clear_all_data_xpath");
			
			type("erdn_organization_xpath", erdnOrganization);
			type("erdn_approve_date_start_xpath", erdnApproveDateStart);
			type("erdn_approved_date_end_xpath", erdnApproveDateEnd);
			
			click("erdn_run_report_xpath");

		} else {
			
			throw new SkipException("not running this report currently");
			
		}

	}

}