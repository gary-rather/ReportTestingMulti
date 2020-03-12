package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class ReportFSA extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		System.out.println("Report ReportFSA setTheTest: "  );
		super.setTheTest("ReportFSA");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void reportFSA(String fsaDoctype, String fsaOrganization, String fsaApproveDateStart, String fsaApproveDateEnd) {
		
		if(config.getProperty("reportRequested").equals("fsa")
				|| this.getTheTest().equals("ReportFSA")) {

			System.out.println("Try ReportFSA 1");

			click("fsa_reset_menu_xpath");
			click("fsa_clear_all_data_xpath");
			
			type("fsa_organization_xpath", fsaOrganization);
			type("fsa_doctype_xpath", fsaDoctype);
			type("fsa_start_date_xpath", fsaApproveDateStart);
			type("fsa_end_date_xpath", fsaApproveDateEnd);
			
			click("fsa_run_report_xpath");
			
		} else {
			
			throw new SkipException("not running this report currently");
			
		}
		
	}

}