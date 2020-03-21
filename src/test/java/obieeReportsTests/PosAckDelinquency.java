package obieeReportsTests;

import org.openqa.selenium.By;
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
			String padNumHrsDelinquent) throws Exception {
        log.debug("Try PosAckDelinquency");
		if (this.getTheTest().equals("PosAckDelinquency")) {

			this.setUp();
			
			log.debug("Try PosAckDelinquency 1");
			//click("pad_cont_to_report_id");

			driver.findElement(By.linkText("Transaction Monitoring Dashboard")).click();

			log.debug("Testing Pos Ack Delinquency Report");
			driver.findElement(By.linkText("Display the Pos Ack Delinquency report")).click();

            Thread.sleep(1000);
			click("pad_reset_menu_xpath");

			log.debug("Try PosAckDelinquency 3");
			click("pad_clear_all_data_xpath");

			log.debug("Try PosAckDelinquency 4");

			Thread.sleep(1000);
			type("pad_organization_xpath", padOrganization);

			Integer hrs = Float.valueOf(padNumHrsDelinquent).intValue();
			type("pad_num_hrs_delinquent_xpath", hrs.toString());


			type("pad_transaction_category_xpath", padTransactionCategory);



			log.debug("Try PosAckDelinquency Go");
			click("pad_run_report_xpath");

			Thread.sleep(1000);

			this.exportToCSV();

		} else {
			
			throw new SkipException("not running this report currently");
			
		}
		log.debug("Report PosAckDelinquency Complete ##########################");
	}
	
}