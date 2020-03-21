package obieeReportsTests;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class RoutingStatus extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report RoutingStatus ======================================="  );
		super.setTheTest("RoutingStatus");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void routingStatus(String rtgOrganization, String rtgDoctype, String rtgAoSSN, String rtgNumDaysCurrStat) throws Exception{
		log.debug("Try RoutingStatus");
		if (this.getTheTest().equals("RoutingStatus")) {

			this.setUp();
			log.debug("Try RoutingStatus 1");

			log.debug("Going into Document & Trip Status section");
			driver.findElement(By.xpath(OR.getProperty("document_and_trip_status"))).click();


			log.debug("Testing Document Status Details Report");
			driver.findElement(By.xpath(OR.getProperty("routing_status"))).click();

			Thread.sleep(1000);
			click("rtg_reset_menu_xpath");
			Thread.sleep(1000);
			click("rtg_clear_all_data_xpath");
			Thread.sleep(1000);
			log.debug("Try RoutingStatus 2");
			//type("rtg_organization_xpath", rtgOrganization);

			Thread.sleep(1000);
			log.debug("Try RoutingStatus 3");
			//type("rtg_doctype_xpath", rtgDoctype);
			Thread.sleep(1000);
			log.debug("Try RoutingStatus 4");
			//type("rtg_ao_ssn_xpath", rtgAoSSN);
			log.debug("Try RoutingStatus 5");
			//type("rtg_num_days_curr_stat_xpath", rtgNumDaysCurrStat);

			log.debug("Try RoutingStatus 6");
			Thread.sleep(1000);
			click("rtg_run_report_xpath");
			Thread.sleep(1000);
			this.exportToCSV();

		} else {

			throw new SkipException("not running this report currently");

		}
		log.debug("Report RoutingStatus ##########################");
	}

}
