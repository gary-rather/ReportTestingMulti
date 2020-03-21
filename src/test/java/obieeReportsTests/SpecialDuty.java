package obieeReportsTests;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class SpecialDuty extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report SpecialDuty ======================================="  );
		super.setTheTest("SpecialDuty");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void specialDuty(String sdDoctype, String sdOrganization, String sdStartDate, String sdEndDate) throws Exception {
		
		if (this.getTheTest().equals("SpecialDuty")) {

			this.setUp();
			log.debug("Try SpecialDuty 1");
			driver.findElement(By.xpath(OR.getProperty("military_reports"))).click();


			log.debug("Testing Special Duty Report");
			driver.findElement(By.xpath(OR.getProperty("special_duty"))).click();
			Thread.sleep(1000);
			click("sd_reset_menu_xpath");
			click("sd_clear_all_data_xpath");
			Thread.sleep(1000);
			type("sd_doctype_xpath", sdDoctype);
			type("sd_organization_xpath", sdOrganization);
			type("sd_start_date_xpath", sdStartDate);
			type("sd_end_date_xpath", sdEndDate);
			Thread.sleep(1000);
			click("sd_run_report_xpath");
			Thread.sleep(1000);
			this.exportToCSV();

		} else {
			
			throw new SkipException("not running this report currently");
			
		}
		log.debug("Report specialDuty Complete ##########################");
	}
	
}