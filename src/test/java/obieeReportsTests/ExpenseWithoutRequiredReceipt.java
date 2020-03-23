package obieeReportsTests;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class ExpenseWithoutRequiredReceipt extends TestBaseReports {

    @BeforeClass
    public void setTheTest() {
        log.debug("0 ====== Report ExpenseWithoutRequiredReceipt =======================================");
        super.setTheTest("ExpenseWithoutRequiredReceipt");
    }


    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void expenseWithoutRequiredReceipt(String ewrrDoctype, String ewrrOrganization, String ewrrApproveDateStart,
                                              String ewrrApproveDateEnd) throws Exception {

        if (this.getTheTest().equals("ExpenseWithoutRequiredReceipt")) {

            this.setUp();

            log.debug("Try ExpenseWithoutRequiredReceipt 1");
            log.debug("Going into Trip Expenses & Transactions section");
            driver.findElement(By.xpath(OR.getProperty("trip_expenses_and_transactions"))).click();

			Thread.sleep(1000);
            log.debug("Testing Expense Without Required Receipt Report");
            driver.findElement(By.xpath(OR.getProperty("expense_without_receipt"))).click();

            Thread.sleep(1000);
            click("ewrr_reset_menu_xpath");
            click("ewrr_clear_all_data_xpath");


			Thread.sleep(1000);
            log.debug("Try ExpenseWithoutRequiredReceipt 2");
			type("ewrr_organization_xpath", ewrrOrganization);
            Thread.sleep(1000);
			type("ewrr_approve_date_start_xpath", ewrrApproveDateStart);
			Thread.sleep(1000);
			type("ewrr_approve_date_end_xpath", ewrrApproveDateEnd);
			Thread.sleep(1000);
            log.debug("Try ExpenseWithoutRequiredReceipt 3");
			type("ewrr_doctype_xpath", ewrrDoctype);
			// Need to click somwhere to get the Apply to show
			//driver.findElement(By.xpath("//body")).click();

			Thread.sleep(1000);
            log.debug("Try ExpenseWithoutRequiredReceipt 4");
            click("ewrr_run_report_xpath");
            Thread.sleep(1000);

            log.debug("Try ExpenseWithoutRequiredReceipt 5");
            this.exportToCSV();
            this.status = true;
        } else {

            throw new SkipException("not running this report currently");

        }
        log.debug("Report expenseWithoutRequiredReceipt Complete ##########################");
    }

}