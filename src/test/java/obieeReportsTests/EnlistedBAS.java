package obieeReportsTests;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class EnlistedBAS extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report EnlistedBAS ======================================="  );
		super.setTheTest("EnlistedBAS");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void enlistedBAS(String ebasOrganization, String ebasDoctype, String ebasApproveDateStart, String ebasApproveDateEnd) throws Exception {
		
		if(this.getTheTest().equals("EnlistedBAS")) {

			this.setUp();

			log.debug("Going into Miltary Information section");
			driver.findElement(By.xpath(OR.getProperty("military_reports"))).click();


				log.debug("Testing Enslited BAS Report");
				driver.findElement(By.xpath(OR.getProperty("enlisted_bas"))).click();

				log.debug("Try EnlistedBAS 1");

			click("ebas_reset_menu_xpath");
			click("ebas_clear_all_data_xpath");
			
			type("ebas_organization_xpath", ebasOrganization);
			type("ebas_doctype_xpath", ebasDoctype);
			type("ebas_start_date_xpath", ebasApproveDateStart);
			type("ebas_end_date_xpath", ebasApproveDateEnd);
			Thread.sleep(1000);
			click("ebas_run_report_xpath");
			Thread.sleep(1000);

			this.exportToCSV();
		} else {
			
			throw new SkipException("not running this report currently");
			
		}
		log.debug("Report EnlistedBAS Complete ##########################");
	}
	
}