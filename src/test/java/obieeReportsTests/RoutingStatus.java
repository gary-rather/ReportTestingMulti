package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class RoutingStatus extends TestBaseReports {

	@BeforeClass
	public void runBeforeClass(){
		System.out.println("Report RoutingStatus setTheTest: "  );
		super.setTheTest("RoutingStatus");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void routingStatus(String rtgPartnerSystem, String rtgDoctype,
							  String rtgNumDaysCurrStat) throws InterruptedException {

		System.out.println("Report RoutingStatus setTheTest: "  );

		runBeforeClass();
		super.setUp();

		System.out.println("Try RoutingStatus");

		if (config.getProperty("reportRequested").equalsIgnoreCase("routing status")
				|| this.getTheTest().equals("RoutingStatus")) {

			click("rtg_reset_menu_xpath");
			click("rtg_reset_to_default_xpath");

			System.out.println("Try RoutingStatus 2");
			click("rtg_organization_field_xpath");
			click("rtg_organization_all_selection_xpath");

			type("rtg_partner_sys_xpath", rtgPartnerSystem);
			type("rtg_doctype_xpath", rtgDoctype);

			System.out.println("Try RoutingStatus 3");
			type("rtg_days_in_stat_xpath", rtgNumDaysCurrStat);

			System.out.println("Try RoutingStatus 4");
			click("rtg_run_report_xpath");

		} else {

			throw new SkipException("not running this report currently");

		}
		
	}

}
