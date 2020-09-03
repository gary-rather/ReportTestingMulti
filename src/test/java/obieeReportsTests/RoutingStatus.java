package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class RoutingStatus extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		System.out.println("Report RoutingStatus setTheTest: "  );
		super.setTheTest("RoutingStatus");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void routingStatus(String rtgOrganization, String rtgDoctype, String rtgPartnerSystem,
							  String rtgNumDaysCurrStat) {

		System.out.println("Try RoutingStatus");
		if (config.getProperty("reportRequested").equalsIgnoreCase("routing status")
				|| this.getTheTest().equals("RoutingStatus")) {

			System.out.println("Try RoutingStatus 1");

			click("rtg_reset_menu_xpath");
			click("rtg_clear_all_data_xpath");

			System.out.println("Try RoutingStatus 2");
			type("rtg_organization_xpath", rtgOrganization);
			type("rtg_partner_sys_xpath", rtgPartnerSystem);
			type("rtg_doctype_xpath", rtgDoctype);

			System.out.println("Try RoutingStatus 3");
			click("rtg_ao_ssn_field_xpath");
			click("rtg_ao_ssn_all_selection_xpath");
			type("rtg_days_in_stat_xpath", rtgNumDaysCurrStat);

			System.out.println("Try RoutingStatus 4");
			click("rtg_run_report_xpath");

		} else {

			throw new SkipException("not running this report currently");

		}
		
	}

}
