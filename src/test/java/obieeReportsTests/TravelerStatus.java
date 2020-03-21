package obieeReportsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

import java.util.List;

public class TravelerStatus extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report TravelerStatus ======================================="  );
		super.setTheTest("TravelerStatus");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void travelerStatus(String tsOrganization, String tsDprtDateStart, String tsDprtDateEnd,
			String tsTDYAsOfDate) throws Exception {

		if (this.getTheTest().equals("TravelerStatus")) {

			this.setUp();
			log.debug("Try TravelerStatus 1");

			driver.findElement(By.xpath(OR.getProperty("document_and_trip_status"))).click();
			Actions action = new Actions(driver);

			log.debug("Testing Trip Status Details Report");
			driver.findElement(By.xpath(OR.getProperty("traveler_status"))).click();
			Thread.sleep(3000);
			click("ts_reset_menu_xpath");
			click("ts_clear_all_data_xpath");
			//click("ts_reset_default_xpath");
			Thread.sleep(1000);
			log.debug("Try TravelerStatus 2");

			type("ts_organization_xpath", tsOrganization);

			// driver.findElement(By.xpath("//body")).click();

			Thread.sleep(2000);
			log.debug("Try TravelerStatus 3");
			type("ts_dprt_date_start_xpath", tsDprtDateStart);

			Thread.sleep(1000);
			log.debug("Try TravelerStatus 4");
			type("ts_dprt_date_end_xpath", tsDprtDateEnd);

			Thread.sleep(1000);
			log.debug("Try TravelerStatus 5");
			type("ts_tdy_as_of_date_xpath", tsTDYAsOfDate);

			Thread.sleep(1000);
			log.debug("Try TravelerStatus 6");
			//type("ts_show_costs_xpath","Y");
			WebElement to = driver.findElement(By.xpath("//*[starts-with(@id,'saw_')][contains(@id,'_5_1')]"));
			to.click();

			action.moveToElement(to, to.getLocation().getX(), to.getLocation().getY());
			to.sendKeys(Keys.ARROW_DOWN);
			to.sendKeys(Keys.RETURN);
			driver.findElement(By.xpath("//body")).click();
			log.debug("Try TravelerStatus 7");

			Thread.sleep(1000);
			log.debug("Try TravelerStatus 00");
			List<WebElement> wes = driver.findElements(By.xpath("//*[starts-with(@id,'saw_')][contains(@id,'_')]"));
			int i = 0;
			for (WebElement we:wes ){
				log.debug(i++ + " WE " + we.getText() + " id " + we.getAttribute("id") + " value " + we.getAttribute("value")
						+ " tag " + we.getTagName()
						+ " isdisplay " +  we.isDisplayed());

			}

			Thread.sleep(1000);
			click("ts_run_report_xpath");
			Thread.sleep(1000);

			this.exportToCSV();

		} else {

			throw new SkipException("not running this report currently");

		}
		log.debug("Report TravelerStatus Complete ##########################");
	}

}
