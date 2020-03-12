package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class EnlistedBAS extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		System.out.println("Report EnlistedBAS setTheTest: "  );
		super.setTheTest("EnlistedBAS");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void enlistedBAS(String ebasOrganization, String ebasDoctype, String ebasApproveDateStart, String ebasApproveDateEnd) {
		
		if(config.getProperty("reportRequested").equals("enlisted bas")
				|| this.getTheTest().equals("EnlistedBAS")) {

			System.out.println("Try EnlistedBAS 1");

			click("ebas_reset_menu_xpath");
			click("ebas_clear_all_data_xpath");
			
			type("ebas_organization_xpath", ebasOrganization);
			type("ebas_doctype_xpath", ebasDoctype);
			type("ebas_start_date_xpath", ebasApproveDateStart);
			type("ebas_end_date_xpath", ebasApproveDateEnd);
			
			click("ebas_run_report_xpath");
			
		} else {
			
			throw new SkipException("not running this report currently");
			
		}
		
	}
	
}