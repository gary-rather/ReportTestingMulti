package obieeReportsTests;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class ExpenseReportByCategory extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report ExpenseReportByCategory ======================================="  );
		super.setTheTest("ExpenseReportByCategory");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void expenseReportByCategory(String ercOrganization, String ercDoctype, String ercApproveDateStart,
			String ercApproveDateEnd, String ercLOA) throws Exception {

		if (this.getTheTest().equals("ExpenseReportByCategory")) {

			this.setUp();

			log.debug("Try ExpenseReportByCategory 1");
			log.debug("Going into Trip Expenses & Transactions section");
			driver.findElement(By.xpath(OR.getProperty("trip_expenses_and_transactions"))).click();


			log.debug("Testing Expense By Category Report");
			driver.findElement(By.xpath(OR.getProperty("expense_by_category"))).click();


			click("erc_reset_menu_xpath");
			click("erc_clear_all_data_xpath");
			Thread.sleep(1000);
			type("erc_organization_xpath", ercOrganization);
			type("erc_doctype_xpath", ercDoctype);
			type("erc_approve_date_start_xpath", ercApproveDateStart);
			type("erc_approve_date_end_xpath", ercApproveDateEnd);
			type("erc_LOA_xpath", ercLOA);

			click("erc_run_report_xpath");
			Thread.sleep(2000);

			this.exportToCSV();

		} else {

			throw new SkipException("not running this report currently");

		}
		log.debug("Report ExpenseReportByCategory Complete ##########################");
	}

}