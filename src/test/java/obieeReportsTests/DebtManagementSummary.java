package obieeReportsTests;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class DebtManagementSummary extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report DebtManagementSummary ======================================="  );
		super.setTheTest("DebtManagementSummary");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void debtManagementSummary(String dmsOrganization) throws Exception {

		if (this.getTheTest().equals("DebtManagementSummary")) {

			this.setUp();

			log.debug("Going into Debt Management section ");
			driver.findElement(By.xpath(OR.getProperty("debt_management"))).click();
			Thread.sleep(500);

			log.debug("Testing Debt Management Summary Report");
			driver.findElement(By.xpath(OR.getProperty("debt_management_summary"))).click();

			Thread.sleep(1000);
			click("dms_reset_menu_xpath");
			click("dms_clear_all_date_xpath");
			Thread.sleep(1000);

			type("dms_organization_xpath", dmsOrganization);
			// Need to click somwhere to get the Apply to show
			driver.findElement(By.xpath("//body")).click();
			Thread.sleep(1000);
			click("dms_run_report_xpath");
			Thread.sleep(1000);

			this.exportToCSV();
			this.status = true;
		} else {
			
			throw new SkipException("not running this report currently");

		}
		log.debug("Report DebtManagementHistory Complete ##########################");
	}

}