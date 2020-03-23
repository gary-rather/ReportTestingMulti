package obieeReportsTests;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class UnsubmittedVoucher extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report UnsubmittedVoucher ======================================="  );
		super.setTheTest("UnsubmittedVoucher");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void unsubmittedVoucher(String uvOrganization, String uvRtrnDateStart, String uvRtrnDateEnd,
			String uvDaysSinceReturn) throws Exception {
        System.out.println("Try UnsubmittedVoucher");
		if (this.getTheTest().equals("UnsubmittedVoucher")) {

			this.setUp();
			log.debug("Try UnsubmittedVoucher 1");

			log.debug("Going into Document & Trip Status section");
			driver.findElement(By.xpath(OR.getProperty("document_and_trip_status"))).click();


			log.debug("Testing Unsubmitted Voucher Report");
			driver.findElement(By.xpath(OR.getProperty("unsubmitted_voucher"))).click();

            Thread.sleep(1000);
			click("uv_reset_menu_xpath");
			click("uv_clear_all_data_xpath");
			Thread.sleep(1000);
			log.debug("Try UnsubmittedVoucher 2");
			type("uv_organization_xpath", uvOrganization);
			type("uv_rtrn_date_start_xpath", uvRtrnDateStart);
			type("uv_rtrn_date_end_xpath", uvRtrnDateEnd);

			log.debug("Try UnsubmittedVoucher 3");
			Thread.sleep(1000);
			type("uv_days_since_return_xpath", uvDaysSinceReturn);
			Thread.sleep(1000);
			click("uv_run_report_xpath");
			Thread.sleep(1000);

			this.exportToCSV();
			this.status = true;
		} else {

			throw new SkipException("not running this report currently");

		}
		log.debug("Report UnsubmittedVoucher Complete ##########################");
	}

}
