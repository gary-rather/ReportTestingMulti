package obieeReportsTests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class CompleteTravelerInfo extends TestBaseReports {
	public static Logger log = Logger.getLogger("CompleteTravelerInfo");

	@BeforeClass
	public void runBeforeClass(){
		log.debug("0 ====== Report CompleteTravelerInfo ======================================="  );
		super.setTheTest("CompleteTravelerInfo");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void completeTravelerInfo(String ctiSetOrganization, String ctiSetNextTravelDateStart,
			String ctiSetNextTravelDateEnd, String ctiSetShowFullSSN, String ctiSetShowOnlyTravelersOnTDY) throws InterruptedException {
       runBeforeClass();

		log.debug("Report CompleteTravelerInfo: " + this.getTheTest() );
		super.setUp();


		if (this.getTheTest().equals("CompleteTravelerInfo") ) {

			log.debug("Try completeTravelerInfo 0");
			WebElement ti = driver.findElement(By.xpath("//span[text()[contains(.,'Traveler & User Information Dashboard')]]"));
			ti.click();

			Thread.sleep(500);
			log.debug("Try completeTravelerInfo 1");
			driver.findElement(By.xpath(OR.getProperty("complete_traveler_info"))).click();
			Thread.sleep(500);
			log.debug("Try completeTravelerInfo 2");
			click("cti_set_reset_menu_xpath");
			click("cti_set_clear_all_data_xpath");

			type("cti_set_organization_xpath", ctiSetOrganization);
			log.debug("Try completeTravelerInfo 2");
			log.debug("Try completeTravelerInfo 2");
			// lines 25-31: drop-down selection for Show Full SSN option (will not allow me to use the drop-down method from the test base)
			if (ctiSetShowFullSSN.equalsIgnoreCase("Y")) {
				click("cti_set_show_full_ssn_xpath");
			} else if (ctiSetShowFullSSN.equalsIgnoreCase("N")) {
				click("cti_set_show_partial_ssn_xpath");
			} else {
				throw new SkipException("invalid input - try again");
			}
			log.debug("Try completeTravelerInfo 3");
			// lines 34-40: drop-down selection for Show Only Travelers On TDY option (will not allow me to use the drop-down method from the test base)
			if (ctiSetShowOnlyTravelersOnTDY.equalsIgnoreCase("Y")) {
				click("cti_set_only_tdy_travelers_xpath");
			} else if (ctiSetShowOnlyTravelersOnTDY.equalsIgnoreCase("N")) {
				click("cti_set_show_all_traveler_xpath");
			} else {
				throw new SkipException("invalid input - try again");
			}
			log.debug("Try completeTravelerInfo 4");
			type("cti_set_next_travel_date_start_xpath", ctiSetNextTravelDateStart);
			type("cti_set_next_travel_date_end_xpath", ctiSetNextTravelDateEnd);
			click("cti_set_run_report_xpath");

			WebDriverWait wait=new WebDriverWait(driver,60);



			//WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("ur xpath here")));

		} else {

			throw new SkipException("not running this report currently");

		}
        log.debug("Report CompleteTravlerInfo Complete ##########################");
	}

}
