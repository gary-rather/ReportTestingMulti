package obieeReportsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;

public class DebtManagementHistory extends TestBaseReports {

    @BeforeClass
    public void setTheTest() {
        log.debug("0 ====== Report DebtManagementHistory =======================================");
        super.setTheTest("DebtManagementHistory");
    }


    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void debtManagementHistory(String dmhOrganization) throws Exception {
        log.info("Try debtManagementHistory");
        this.setUp();

        if (this.getTheTest().equals("DebtManagementHistory")) {

            log.debug("Going into Debt Management section ");
            driver.findElement(By.xpath(OR.getProperty("debt_management"))).click();
            Thread.sleep(500);

            log.debug("Try DebtManagementHistory Report 0");
            driver.findElement(By.xpath(OR.getProperty("debt_management_history"))).click();
			Thread.sleep(1000);

            log.debug("Try DebtManagementHistory Report 1");

            click("dmh_reset_menu_xpath");
            Thread.sleep(1000);
            click("dmh_clear_all_data_xpath");
			Thread.sleep(1000);
            log.debug("Try DebtManagementHistory Report 2");
            type("dmh_organization_xpath", dmhOrganization);

            // Need to click somwhere to get the Apply to show
            driver.findElement(By.xpath("//body")).click();

			log.debug("Try DebtManagementHistory 8");
            //WebElement ex=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Apply")));
            click("dmh_run_report_xpath");
            Thread.sleep(3000);
            this.exportToCSV();

        } else {

            throw new SkipException("not running this report currently");

        }
		log.debug("Report DebtManagementHistory Complete ##########################");
    }

}
