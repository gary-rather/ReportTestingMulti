package obieeReportsTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class PosAckDelinquency extends TestBaseReports {

	@BeforeClass
	public void runBeforeClass(){
		System.out.println("Report PosAckDelinquency setTheTest: "  );
		super.setTheTest("PosackDelinquency");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void posAckDelinquency(String padOrganization, String padNumHrsDelinquent,
								  String padTransactionCategory) throws InterruptedException {

		System.out.println("Report PosAckDelinquency setTheTest: "  );

		runBeforeClass();
		super.setUp();

		System.out.println("Try PosAckDelinquency");

		if (config.getProperty("reportRequested").equalsIgnoreCase("posack delinquency")
				|| this.getTheTest().equals("PosackDelinquency")) {

			System.out.println("Try PosAckDelinquency 1");
			//click("pad_cont_to_report_id");

			System.out.println("Try PosAckDelinquency 2");
			click("pad_reset_menu_xpath");

			System.out.println("Try PosAckDelinquency 3");
			click("pad_clear_all_data_xpath");

			System.out.println("Try PosAckDelinquency 4");

			type("pad_organization_xpath", padOrganization);

			Integer hrs = Float.valueOf(padNumHrsDelinquent).intValue();
			type("pad_num_hrs_delinquent_xpath", hrs.toString());

			type("pad_transaction_category_xpath", padTransactionCategory);

			System.out.println("Try PosAckDelinquency Go");
			click("pad_run_report_xpath");

		} else {
			
			throw new SkipException("not running this report currently");
			
		}

	}
	
}