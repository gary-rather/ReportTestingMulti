package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class ExpenseReportByCategory extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		System.out.println("Report ExpenseReportByCategory setTheTest: "  );
		super.setTheTest("ExpenseReportByCategory");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void expenseReportByCategory(String ercOrganization, String ercDoctype, String ercApproveDateStart,
			String ercApproveDateEnd, String ercLOA) {

		if (config.getProperty("reportRequested").equalsIgnoreCase("expense report by category")
				|| this.getTheTest().equals("ExpenseReportByCategory")) {

			System.out.println("Try ExpenseReportByCategory 1");

			click("erc_reset_menu_xpath");
			click("erc_clear_all_data_xpath");

			type("erc_organization_xpath", ercOrganization);
			type("erc_doctype_xpath", ercDoctype);
			type("erc_approve_date_start_xpath", ercApproveDateStart);
			type("erc_approve_date_end_xpath", ercApproveDateEnd);
			type("erc_LOA_xpath", ercLOA);

			click("erc_run_report_xpath");

		} else {

			throw new SkipException("not running this report currently");

		}

	}

}