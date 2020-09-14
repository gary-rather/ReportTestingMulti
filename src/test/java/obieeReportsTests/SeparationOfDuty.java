package obieeReportsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

import java.util.List;

public class SeparationOfDuty extends TestBaseReports {

	@BeforeClass
	public void runBeforeClass(){
		log.debug("2 ====== Report SeparationOfDuty ======================================="  );
		super.setTheTest("SeparationOfDuty");
		log.debug("this.getTheTest(): "  +  this.getTheTest());
	}

	@Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
	public void separationOfDuty(String sodOrganization, String sodApproveDateStart,
								 String sodApproveDateEnd) throws InterruptedException {

		System.out.println("Report SeparationOfDuty: " + this.getTheTest() );

		runBeforeClass();
		super.setUp();

		log.debug("Going into Traveler & User Information section");

		if (config.getProperty("reportRequested").equalsIgnoreCase("separation of duty")
				|| this.getTheTest().equals("SeparationOfDuty")) {

			log.debug("Try SeparationOfDuty 0");

			click("sod_reset_menu_xpath");
			click("sod_clear_all_data_xpath");
			
			type("sod_organization_xpath", sodOrganization);
			type("sod_approve_date_start_xpath", sodApproveDateStart);
			type("sod_approve_date_end_xpath", sodApproveDateEnd);

			log.debug("Try SeparationOfDuty 4");
			click("sod_run_report_xpath");
			   log.debug("Try SeparationOfDuty 5");
			WebDriverWait wait=new WebDriverWait(driver,60);

			//WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()[contains(.,'Export')]]")));
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Export")));
			  log.debug("Try SeparationOfDuty 6");
			element.click();
			log.debug("Try SeparationOfDuty 7");

			//Actions action = new Actions(driver);
			//WebElement we = driver.findElements(By.xpath("//*[text()[contains(.,'Data')]]\""));

			//action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[text()[contains(.,'CSV')]]"))).click().build().perform();
            List<WebElement> l1 = driver.findElements(By.xpath("//td[text()[contains(.,'Data')]]"))  ;
			log.debug("Data Element size "  + l1.size());
			for(WebElement a : l1){
				log.debug("Data Element is "  + a.getTagName() );
				a.click();
			}
			List<WebElement> l2 = driver.findElements(By.xpath("//*[text()[contains(.,'CSV')]]"))  ;
			log.debug("Data Element size "  + l2.size());
			for(WebElement a : l2){
				log.debug("CSV Element is "  + a.getTagName() );
				a.click();
			}

		log.debug("Try SeparationOfDuty 8");
			//csv.click();

			log.debug("SeparationOfDuty Report Finished " + element.getAttribute("Name"));
		} else {
			
			throw new SkipException("not running this report currently");
			
		}
		log.debug("##### Report SeparationOfDuty ##################"  );
	}

}
