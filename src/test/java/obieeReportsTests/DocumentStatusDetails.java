package obieeReportsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

import java.util.List;

public class DocumentStatusDetails extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report DocumentStatusDetails ======================================="  );
		super.setTheTest("DocumentStatusDetails");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void documentStatusDetails(String dsdDoctype, String dsdDocstat, String dsdDaysSinceStatChange,
			String dsdStatDateStart, String dsdStatDateEnd, String dsdDprtDateStart, String dsdDprtDateEnd,
			String dsdRtrnDateStart, String dsdRtrnDateEnd, String dsdAgency, String dsdOrganization) throws InterruptedException, Exception {

		if (this.getTheTest().equals("DocumentStatusDetails")) {

			this.setUp();

			log.debug("Going into Document & Trip Status section");
			log.debug("Going into Document & Trip Status section");
			driver.findElement(By.xpath(OR.getProperty("document_and_trip_status"))).click();

				log.debug("Testing Document Status Details Report");
				driver.findElement(By.xpath(OR.getProperty("document_status_details"))).click();


				log.debug("Try DocumentStatusDetails 1");

			click("dsd_reset_menu_xpath");
			click("dsd_clear_all_data_xpath");


			type("dsd_doctype_xpath", dsdDoctype);
			type("dsd_docstat_xpath", dsdDocstat);
			type("dsd_days_since_stat_change_xpath", dsdDaysSinceStatChange);



			log.debug("dsd_stat_date " + dsdStatDateStart);
			type("dsd_stat_date_start_xpath", dsdStatDateStart);


			log.debug("dsdStatDateEnd " + dsdStatDateEnd);
			type("dsd_stat_date_end_xpath", dsdStatDateEnd);

			log.debug("dsd_dprt_date " + dsdDprtDateStart);
			type("dsd_dprt_date_start_xpath", dsdDprtDateStart);

			log.debug("dsdDprtDateEnd " + dsdDprtDateEnd);
			type("dsd_dprt_date_end_xpath", dsdDprtDateEnd);


			log.debug("dsd_rtrn_date");
			type("dsd_rtrn_date_start_xpath", dsdRtrnDateStart);
			type("dsd_rtrn_date_end_xpath", dsdRtrnDateEnd);

			log.debug("dsd_agency_xpath");
			type("dsd_agency_xpath", dsdAgency);


			log.debug("dsd_organization_xpath");
			type("dsd_organization_xpath", dsdOrganization);

			Thread.sleep(2000);
			click("dsd_run_report_xpath");

			this.exportToCSV();
		} else {

			throw new SkipException("not running this report currently");

		}
		log.debug("Report DocumentStatusDetails Complete ##########################");
	}

}
