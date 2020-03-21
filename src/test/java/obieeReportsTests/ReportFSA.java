package obieeReportsTests;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class ReportFSA extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report ReportFSA ======================================="  );
		super.setTheTest("ReportFSA");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void reportFSA(String fsaDoctype, String fsaOrganization, String fsaApproveDateStart, String fsaApproveDateEnd) throws Exception {
		
		if(this.getTheTest().equals("ReportFSA")) {

			this.setUp();


			log.debug("Try ReportFSA 1");
			log.debug("Going into Miltary Information section");
			driver.findElement(By.xpath(OR.getProperty("military_reports"))).click();


			log.debug("Testing FSA Report");
			driver.findElement(By.xpath(OR.getProperty("fsa"))).click();

			click("fsa_reset_menu_xpath");
			click("fsa_clear_all_data_xpath");
			
			type("fsa_organization_xpath", fsaOrganization);
			type("fsa_doctype_xpath", fsaDoctype);
			type("fsa_start_date_xpath", fsaApproveDateStart);
			type("fsa_end_date_xpath", fsaApproveDateEnd);
			Thread.sleep(1000);
			click("fsa_run_report_xpath");
			Thread.sleep(1000);

			this.exportToCSV();
			
		} else {
			
			throw new SkipException("not running this report currently");
			
		}
		log.debug("Report ReportFSA Complete ##########################");
	}

}