package obieeReportsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

import java.util.List;

public class DebtSummaryByMonth extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report DebtSummaryByMonth ======================================="  );
		super.setTheTest("DebtSummaryByMonth");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void debtSummaryByMonth(String dsbmRunReportBy, String dsbmServiceName, String dsbmSiteName, String dsbmOrganization) throws Exception {
        System.out.println("Try DebtSummaryByMonth");
		if (this.getTheTest().equals("DebtSummaryByMonth")) {

            this.setUp();

			log.debug("Going into Debt Management section");
			driver.findElement(By.xpath(OR.getProperty("debt_management"))).click();
			Actions action = new Actions(driver);

			log.debug("Testing Debt Summary By Month Report");
			driver.findElement(By.xpath(OR.getProperty("debt_summary_by_month"))).click();
			log.debug("Testing Debt Summary By Month Report 1");
			Thread.sleep(1000);
			click("dsbm_reset_menu_xpath");
			click("dsbm_clear_all_data_xpath");
			Thread.sleep(1000);

			log.debug("Testing Debt Summary By Month Report 2");
			// lines 19-27: radio button selection for Run Report By (cannot figure out how to code a radio button method in the test base)
			if (dsbmRunReportBy.equalsIgnoreCase("Service Name")) {
				log.debug("Testing Debt Summary By Month Report 3a");
				click("dsbm_report_by_service_name_xpath");
			} else if (dsbmRunReportBy.equalsIgnoreCase("Site Name")) {
				log.debug("Testing Debt Summary By Month Report 3b");
				click("dsbm_report_by_site_name_xpath");
			} else if (dsbmRunReportBy.equalsIgnoreCase("Organization")) {
				log.debug("Testing Debt Summary By Month Report 3c");
				String xp = OR.getProperty("dms_organization_xpath");
				driver.findElement(By.xpath(xp)).click();
				//click("dsbm_report_by_org_name_xpath");
			} else {
				throw new SkipException("invalid input - try again");
			}
			log.debug("Testing Debt Summary By Month Report 4");
			click("dsbm_run_selection_xpath");
			Thread.sleep(1000);

			// lines 33-40: insert service name, site name, or organization name based on radio button selection above
			// these elements were found to be non-interactable
			if (dsbmRunReportBy.equalsIgnoreCase("Service Name")) {
				log.debug("Testing Debt Summary By Month Report 4a");
				type("dsbm_service_name_xpath", dsbmServiceName);
			} else if (dsbmRunReportBy.equalsIgnoreCase("Site Name")) {
				log.debug("Testing Debt Summary By Month Report 4b");
				type("dsbm_site_name_xpath", dsbmSiteName);
			} else {
				log.debug("Testing Debt Summary By Month Report 4c");
				type("dsbm_org_name_xpath", dsbmOrganization);
				driver.findElement(By.xpath("//body")).click();
			}
			Thread.sleep(1000);
			log.debug("Testing Debt Summary By Month Report Run");
			String xp1 = OR.getProperty("dsbm_run_complete_report_xpath");
			//driver.findElement(By.xpath(xp1)).click();
			List<WebElement> ls = driver.findElements(By.xpath(xp1));
			int i = 0;
			for (WebElement one: ls ){

				action.moveToElement(one, one.getLocation().getX(), one.getLocation().getY());
				log.debug("WE " + one.getText() + " " + one.getLocation());
				if (i++ > 0)one.click();
			}

			//click("dsbm_run_complete_report_xpath");

			Thread.sleep(1000);
		} else {
			
			throw new SkipException("not running this report currently");
			
		}
		log.debug("Report DebtSummaryByMonth Complete ##########################");
	}

}
