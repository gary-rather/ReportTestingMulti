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
	public void runBeforeClass(){
		System.out.println("Report DocumentStatusDetails setTheTest: "  );
		super.setTheTest("DocumentStatusDetails");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void documentStatusDetails(String dsdDoctype, String dsdDocstat)
			throws InterruptedException {

		System.out.println("Report DocumentStatusDetails setTheTest: "  );

		runBeforeClass();
		super.setUp();

		System.out.println("Try DocumentStatusDetails");

		if (config.getProperty("reportRequested").equalsIgnoreCase("document status details")
				|| this.getTheTest().equals("DocumentStatusDetails")) {

			click("dsd_reset_menu_xpath");
			click("dsd_reset_to_default_xpath");

			click("dsd_organization_field_xpath");
			click("dsd_organization_all_selection_xpath");

			type("dsd_doctype_xpath", dsdDoctype);
			type("dsd_docstat_xpath", dsdDocstat);

			click("dsd_run_report_xpath");

		} else {

			throw new SkipException("not running this report currently");

		}

	}

}
