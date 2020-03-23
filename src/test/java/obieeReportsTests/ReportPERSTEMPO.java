package obieeReportsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.*;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

import java.util.List;

public class ReportPERSTEMPO extends TestBaseReports {

	@BeforeClass
	public void setTheTest(){
		log.debug("0 ====== Report ReportPERSTEMPO ======================================="  );
		super.setTheTest("ReportPERSTEMPO");
	}


	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void reportPERSTEMPO(String perOrganization, String perPerstempoCode, String perPaidDateStart, String perPaidDateEnd) throws Exception {

		if (this.getTheTest().equals("ReportPERSTEMPO")) {

            this.setUp();

			log.debug("Going into Miltary Information section");
			driver.findElement(By.xpath(OR.getProperty("military_reports"))).click();
			Actions action = new Actions(driver);

			log.debug("Testing PERSTEMPO Report");
			driver.findElement(By.xpath(OR.getProperty("perstempo"))).click();

			log.debug("Try ReportPERSTEMPO 1");

			click("per_reset_menu_xpath");
			click("per_clear_all_data_xpath");


			Thread.sleep(1000);
			//driver.findElement(By.xpath("//body")).click();


			type("per_organization_xpath", perOrganization);
			type("per_start_date_xpath", perPaidDateStart);
			type("per_end_date_xpath", perPaidDateEnd);
			//type("per_perstempo_code_xpath", perPerstempoCode);

			WebElement to = driver.findElement(By.xpath("//*[starts-with(@id,'saw_')][contains(@id,'_8_1')]"));
			to.click();

			action.moveToElement(to, to.getLocation().getX(), to.getLocation().getY());
			for (int i =0; i < 13 ;i++){
				to.sendKeys(Keys.ARROW_DOWN);
				Thread.sleep(200);
			}

			to.sendKeys(Keys.RETURN);
			driver.findElement(By.xpath("//body")).click();

			Thread.sleep(1000);

			//Thread.sleep(1000);

			click("per_run_report_xpath");
			Thread.sleep(1000);

			this.exportToCSV();
			this.status = true;
		} else {
			
			throw new SkipException("not running this report currently");
			
		}
		log.debug("Report ReportPERSTEMPO Complete ##########################");
	}
	
}