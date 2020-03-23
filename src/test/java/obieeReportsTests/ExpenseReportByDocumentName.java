package obieeReportsTests;

import org.openqa.selenium.By;
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
	public void expenseReportByDocumentName(String erdnOrganization, String erdnApproveDateStart, String erdnApproveDateEnd) throws Exception {

		if (this.getTheTest().equals("ExpenseReportByDocumentName")) {
			this.setUp();

			log.debug("Try ExpenseReportByDocumentName 1");
			log.debug("Going into Trip Expenses & Transactions section");
			driver.findElement(By.xpath(OR.getProperty("trip_expenses_and_transactions"))).click();

			log.debug("Testing Expense By Document Name Report");
			driver.findElement(By.xpath(OR.getProperty("expense_by_document_name"))).click();

			Thread.sleep(1000);
			click("erc_reset_menu_xpath");
			click("erc_clear_all_data_xpath");
			Thread.sleep(1000);
			type("erdn_organization_xpath", erdnOrganization);
			type("erdn_approve_date_start_xpath", erdnApproveDateStart);
			type("erdn_approved_date_end_xpath", erdnApproveDateEnd);
			Thread.sleep(1000);
			click("erdn_run_report_xpath");
			Thread.sleep(1000);

			this.exportToCSV();
			this.status = true;
		} else {
			
			throw new SkipException("not running this report currently");
			
		}
		log.debug("Report ExpenseReportByDocumentName Complete ##########################");
	}

}