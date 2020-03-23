package obieeReportsTests;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class ReportOCONUS extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report ReportOCONUS ======================================="  );
		super.setTheTest("ReportOCONUS");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void reportOCONUS(String ocOrganization, String ocDoctype, String ocCivMilIndicator,
			String ocApproveDateStart, String ocApproveDateEnd) throws Exception  {
        System.out.println("Try ReportOCONUS");
		if (this.getTheTest().equals("ReportOCONUS")) {

			this.setUp();

			log.debug("Try ReportOCONUS 1");
			log.debug("Going into Miltary Information section");
			driver.findElement(By.xpath(OR.getProperty("military_reports"))).click();


			log.debug("Testing OCONUS Report");
			driver.findElement(By.xpath(OR.getProperty("oconus"))).click();

			click("oc_reset_menu_xpath");
			click("oc_clear_all_data_xpath");
            Thread.sleep(1000);
			type("oc_organization_xpath", ocOrganization);
			type("oc_doctype_xpath", ocDoctype);
			type("oc_civ_mil_ind_xpath", ocCivMilIndicator);
			type("oc_start_date_xpath", ocApproveDateStart);
			type("oc_end_date_xpath", ocApproveDateEnd);
			Thread.sleep(1000);
			click("oc_run_report_xpath");
			Thread.sleep(1000);

			this.exportToCSV();
			this.status = true;
		} else {

			throw new SkipException("not running this report currently");

		}
		log.debug("Report ReportOCONUS Complete ##########################");
	}

}