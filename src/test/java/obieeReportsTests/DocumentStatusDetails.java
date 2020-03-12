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
		System.out.println("Report DocumentStatusDetails setTheTest: "  );
		super.setTheTest("DocumentStatusDetails");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void documentStatusDetails(String dsdDoctype, String dsdDocstat, String dsdDaysSinceStatChange,
			String dsdStatDateStart, String dsdStatDateEnd, String dsdDprtDateStart, String dsdDprtDateEnd,
			String dsdRtrnDateStart, String dsdRtrnDateEnd, String dsdAgency, String dsdOrganization) throws InterruptedException {

		if (config.getProperty("reportRequested").equals("document status details")
				|| this.getTheTest().equals("DocumentStatusDetails")) {

			System.out.println("Try DocumentStatusDetails 1");

			click("dsd_reset_menu_xpath");
			click("dsd_clear_all_data_xpath");

			//List<WebElement> l1 = driver.findElements(By.xpath("//*[starts-with(@id,'saw_')][contains(@id,'_3_1_dropdownIcon')]"));
            //l1.get(0).click();


			//List<WebElement> l2 = driver.findElements(By.xpath("//*[starts-with(@id,'saw_')][contains(@id,'_3_1')]"));
			//l1.get(0).getAttribute("name");
			//for(WebElement we : l2) {
			//	System.out.println("List of elements " + we.getTagName() + " " + we.getAttribute("ID"));
			//}
			//List<WebElement> l3 = driver.findElements(By.xpath("//*[starts-with(@id,'saw_')][contains(@id,'_5_1')]"));
			//l1.get(0).getAttribute("name");

			//for(WebElement we : l3) {
			//	System.out.println("List of elements " + we.getTagName() + " " + we.getAttribute("ID"));
			//}


			type("dsd_doctype_xpath", dsdDoctype);
			type("dsd_docstat_xpath", dsdDocstat);
			type("dsd_days_since_stat_change_xpath", dsdDaysSinceStatChange);



			System.out.println("dsd_stat_date " + dsdStatDateStart);
			type("dsd_stat_date_start_xpath", dsdStatDateStart);


			System.out.println("dsdStatDateEnd " + dsdStatDateEnd);
			type("dsd_stat_date_end_xpath", dsdStatDateEnd);

			System.out.println("dsd_dprt_date " + dsdDprtDateStart);
			type("dsd_dprt_date_start_xpath", dsdDprtDateStart);

			System.out.println("dsdDprtDateEnd " + dsdDprtDateEnd);
			type("dsd_dprt_date_end_xpath", dsdDprtDateEnd);


			System.out.println("dsd_rtrn_date");
			type("dsd_rtrn_date_start_xpath", dsdRtrnDateStart);
			type("dsd_rtrn_date_end_xpath", dsdRtrnDateEnd);

			System.out.println("dsd_agency_xpath");
			type("dsd_agency_xpath", dsdAgency);


			System.out.println("dsd_organization_xpath");
			type("dsd_organization_xpath", dsdOrganization);

			Thread.sleep(2000);
			click("dsd_run_report_xpath");

		} else {

			throw new SkipException("not running this report currently");

		}

	}

}
