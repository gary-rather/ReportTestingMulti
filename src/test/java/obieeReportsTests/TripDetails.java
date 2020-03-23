package obieeReportsTests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

import java.util.concurrent.TimeUnit;

public class TripDetails extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report TripDetails ======================================="  );
		super.setTheTest("TripDetails");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void tripDetails(String tdDoctype, String tdDocstat, String tdNumDays, String tdStatusDateStart,
			String tdStatusDateEnd, String tdDprtDateStart, String tdDprtDateEnd, String tdRtrnDateStart,
			String tdRtrnDateEnd, String tdOrganization) throws Exception {

		if (this.getTheTest().equals("TripDetails")) {

			this.setUp();
			
			log.debug("Trip Details 1");


			driver.findElement(By.xpath(OR.getProperty("document_and_trip_details"))).click();
			Actions action = new Actions(driver);



			log.debug("Testing Trip Details Report");
			driver.findElement(By.xpath(OR.getProperty("trip_details"))).click();

			click("td_reset_menu_xpath");
			click("td_clear_all_data_xpath");
			Thread.sleep(1000);

			log.debug("Trip Details 2");
			type("td_doctype_xpath", tdDoctype);
			log.debug("Trip Details 3");


			type("td_docstat_xpath", tdDocstat);
			log.debug("Trip Details 4");
            type("td_num_days_xpath", tdNumDays);
			type("td_status_date_start_xpath", tdStatusDateStart);
			type("td_status_date_end_xpath", tdStatusDateEnd);
			type("td_dprt_date_start_xpath", tdDprtDateStart);
			type("td_dprt_date_end_xpath", tdDprtDateEnd);
			type("td_rtrn_date_start_xpath", tdRtrnDateStart);
			type("td_rtrn_date_end_xpath", tdRtrnDateEnd);
			type("td_organization_xpath", tdOrganization);

			Thread.sleep(1000);
			WebElement to = driver.findElement(By.xpath("//*[starts-with(@id,'saw_')][contains(@id,'_5_1')]"));
			to.click();

			action.moveToElement(to, to.getLocation().getX(), to.getLocation().getY());
			to.sendKeys(Keys.ARROW_DOWN);
			to.sendKeys(Keys.RETURN);
			driver.findElement(By.xpath("//body")).click();

			//type("td_num_days_xpath", tdNumDays);
			Thread.sleep(1000);
			click("td_run_report_xpath");
			Thread.sleep(1000);
			this.exportToCSV();
			this.status = true;
		} else {

			throw new SkipException("not running this report currently");

		}
		log.debug("Report TripDetails Complete ##########################");
	}

}
