package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class EnlistedBAS extends TestBaseReports {

	@BeforeClass
	public void runBeforeClass(){
		System.out.println("Report EnlistedBAS setTheTest: "  );
		super.setTheTest("EnlistedBAS");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void enlistedBAS(String ebasOrganization, String ebasDoctype, String ebasApproveDateStart,
							String ebasApproveDateEnd) throws InterruptedException {

		System.out.println("Report EnlistedBAS setTheTest: "  );

		runBeforeClass();
		super.setUp();

		System.out.println("Try EnlistedBAS");

		if(config.getProperty("reportRequested").equalsIgnoreCase("enlisted bas")
				|| this.getTheTest().equals("EnlistedBAS")) {

			System.out.println("Try EnlistedBAS 1");

			click("ebas_reset_menu_xpath");
			click("ebas_clear_all_data_xpath");
			
			type("ebas_organization_xpath", ebasOrganization);
			type("ebas_doctype_xpath", ebasDoctype);
			type("ebas_approve_date_start_xpath", ebasApproveDateStart);
			type("ebas_approve_date_end_xpath", ebasApproveDateEnd);
			
			click("ebas_run_report_xpath");
			
		} else {
			
			throw new SkipException("not running this report currently");
			
		}
		
	}
	
}