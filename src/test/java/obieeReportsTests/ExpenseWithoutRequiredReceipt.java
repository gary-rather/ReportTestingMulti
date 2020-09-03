package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class ExpenseWithoutRequiredReceipt extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		System.out.println("Report ExpenseWithoutRequiredReceipt setTheTest: "  );
		super.setTheTest("ExpenseWithoutRequiredReceipt");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void expenseWithoutRequiredReceipt(String ewrrOrganization, String ewrrDoctype,
											  String ewrrApproveDateStart, String ewrrApproveDateEnd) {

		if (config.getProperty("reportRequested").equalsIgnoreCase("expense without required receipt")
				|| this.getTheTest().equals("ExpenseWithoutRequiredReceipt")) {

			System.out.println("Try ExpenseWithoutRequiredReceipt 1");

			click("ewrr_reset_menu_xpath");
			click("ewrr_clear_all_data_xpath");

			type("ewrr_organization_xpath", ewrrOrganization);
			type("ewrr_doctype_xpath", ewrrDoctype);
			type("ewrr_approve_date_start_xpath", ewrrApproveDateStart);
			type("ewrr_approve_date_end_xpath", ewrrApproveDateEnd);
			
			click("ewrr_run_report_xpath");

		} else {

			throw new SkipException("not running this report currently");

		}

	}

}