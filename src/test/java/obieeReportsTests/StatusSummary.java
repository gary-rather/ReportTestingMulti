package obieeReportsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

import java.util.List;

public class StatusSummary extends TestBaseReports {

	@BeforeClass
	public void runBeforeClass(){
		log.debug("0 ====== Report StatusSummary ======================================="  );
		super.setTheTest("StatusSummary");
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void statusSummary(String ssumDoctype, String ssumDocstat, String ssumNumDays, String ssumStatDateStart,
			String ssumStatDateEnd, String ssumDprtDateStart, String ssumDprtDateEnd, String ssumRtrnDateStart,
			String ssumRtrnDateEnd, String ssumOrganization) throws InterruptedException {
        System.out.println("Try StatusSummary");

		super.setUp();
		if (config.getProperty("reportRequested").equals("status summary")
				|| this.getTheTest().equals("StatusSummary")) {

			log.debug("Try StatusSummary 1");

			driver.findElement(By.xpath(OR.getProperty("document_and_trip_status"))).click();
			log.debug("Testing Status Summary Report");
			driver.findElement(By.xpath(OR.getProperty("status_summary"))).click();
			Thread.sleep(1000);
			click("ssum_reset_menu_xpath");
			click("ssum_reset_default_xpath");

			type("ssum_doctype_xpath", ssumDoctype);
			Thread.sleep(500);
            type("ssum_num_days_xpath", ssumNumDays);
			Thread.sleep(1500);
			type("ssum_docstat_xpath", ssumDocstat);
			Thread.sleep(500);


			System.out.println("Try StatusSummary 2");

			//type("ssum_stat_date_start_xpath", ssumStatDateStart);

			Thread.sleep(1000);
			//type("ssum_stat_end_date_xpath", ssumStatDateEnd);
			//type("ssum_dprt_start_date_xpath", ssumDprtDateStart);
			//type("ssum_dprt_end_date_xpath", ssumDprtDateEnd);
			//type("ssum_rtrn_start_date_xpath", ssumRtrnDateStart);
			//type("ssum_rtrn_end_date_xpath", ssumRtrnDateEnd);
			//type("ssum_organization_xpath", ssumOrganization);

			Thread.sleep(500);
			System.out.println("Status Summary Go");
			click("ssum_run_report_xpath");
			WebElement ex=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Export")));
			List<WebElement> l1 = driver.findElements(By.linkText("Export"))  ;
			log.debug("Data Element size "  + l1.size());
			int i = 1;
			for(WebElement a: l1){
                //if (i++ == 0 )continue;
				log.debug("Data Element is "  + a.getTagName() );
				a.click();
				//WebElement data=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Data")));
				//log.debug("Try Status Summary find Data");
				//data.click();
				//Thread.sleep(500);

				//WebElement csv=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("CSV Format")));
				//log.debug("Try Status Summary find Data");
				//csv.click();
				Thread.sleep(500);

			}
			//WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Export")));
			//.debug("Try Status Summary find export");
			//element.click();
			//Thread.sleep(500);

			WebElement data=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Data")));
			log.debug("Try Status Summary find Data");
			data.click();
			Thread.sleep(500);

			WebElement csv=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("CSV Format")));
			log.debug("Try Status Summary find Data");
			csv.click();
			Thread.sleep(500);

			List<WebElement> l2 = driver.findElements(By.xpath("//*[text()[contains(.,'CSV')]]"))  ;
			log.debug("Data Element size "  + l2.size());
			for(WebElement a : l2){
				log.debug("CSV Element is "  + a.getTagName() );
				a.click();
				break;
			}

		} else {

			throw new SkipException("not running this report currently");

		}

	}

}
