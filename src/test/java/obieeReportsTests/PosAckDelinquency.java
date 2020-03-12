package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class PosAckDelinquency extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report PosAckDelinquency ======================================="  );
		super.setTheTest("PosAckDelinquency");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void posAckDelinquency(String padTransactionCategory, String padOrganization,
			String padNumHrsDelinquent) {
        System.out.println("Try PosAckDelinquency");
		if (config.getProperty("reportRequested").equals("posack delinquency")
				|| this.getTheTest().equals("PosAckDelinquency")) {

			log.debug("Try PosAckDelinquency 1");
			//click("pad_cont_to_report_id");

			click("pad_reset_menu_xpath");

			System.out.println("Try PosAckDelinquency 3");
			click("pad_clear_all_data_xpath");

			System.out.println("Try PosAckDelinquency 4");

			Integer hrs = Float.valueOf(padNumHrsDelinquent).intValue();
			type("pad_num_hrs_delinquent_xpath", hrs.toString());

			type("pad_organization_xpath", padOrganization);
			type("pad_transaction_category_xpath", padTransactionCategory);



			System.out.println("Try PosAckDelinquency Go");
			click("pad_run_report_xpath");

		} else {
			
			throw new SkipException("not running this report currently");
			
		}

	}
	
}