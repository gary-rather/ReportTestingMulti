package obieeReportsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		System.out.println("Report TripDetails setTheTest: "  );
		super.setTheTest("TripDetails");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void tripDetails(String tdDoctype, String tdDocstat, String tdNumDays, String tdStatusDateStart,
			String tdStatusDateEnd, String tdDprtDateStart, String tdDprtDateEnd, String tdRtrnDateStart,
			String tdRtrnDateEnd, String tdOrganization) {

		if (config.getProperty("reportRequested").equals("trip details")
				|| this.getTheTest().equals("TripDetails")) {

            System.out.println("Trip Details 1");
			click("td_reset_menu_xpath");
			click("td_clear_all_data_xpath");

			System.out.println("Trip Details 2");
			type("td_doctype_xpath", tdDoctype);
			System.out.println("Trip Details 3");


			type("td_docstat_xpath", tdDocstat);
			System.out.println("Trip Details 4");
            type("td_num_days_xpath", tdNumDays);
			type("td_status_date_start_xpath", tdStatusDateStart);
			type("td_status_date_end_xpath", tdStatusDateEnd);
			type("td_dprt_date_start_xpath", tdDprtDateStart);
			type("td_dprt_date_end_xpath", tdDprtDateEnd);
			type("td_rtrn_date_start_xpath", tdRtrnDateStart);
			type("td_rtrn_date_end_xpath", tdRtrnDateEnd);
			type("td_organization_xpath", tdOrganization);

			click("td_run_report_xpath");
			System.out.println("Trip Details End");
		} else {

			throw new SkipException("not running this report currently");

		}

	}

}
