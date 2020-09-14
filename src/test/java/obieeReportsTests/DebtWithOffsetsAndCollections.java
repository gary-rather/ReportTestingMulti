package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DebtWithOffsetsAndCollections extends TestBaseReports {

    @BeforeClass
    public void runBeforeClass(){
        System.out.println("Report DebtWithOffsetsAndCollections setTheTest: "  );
        super.setTheTest("DebtWithOffsetsAndCollections");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void debtWithOffsetsAndCollections(String docDebtIncurredDateStart, String docDebtIncurredDateEnd)
            throws InterruptedException {

        System.out.println("Report DebtWithOffsetsAndCollections setTheTest: "  );

        runBeforeClass();
        super.setUp();

        System.out.println("Try DebtWithOffsetsAndCollections");

        if (config.getProperty("reportRequested").equalsIgnoreCase("debt with offsets and collections")
                || this.getTheTest().equals("DebtWithOffsetsAndCollections")) {

            Thread.sleep(1000);
            WebElement iframe = driver.findElement(By.xpath("//iframe"));
            driver.switchTo().frame(iframe);

            System.out.println("Try DebtWithOffsetsAndCollections 1");

            //erase default
            click("doc_organization_field_xpath");
            click("doc_organization_all_selection_xpath");

            //sleep, then reselect for testing
            Thread.sleep(3000);
            click("doc_organization_all_selection_xpath");
            click("doc_organization_field_xpath");

            //date insertions from data driver
            type("doc_debt_incurred_date_start_xpath", docDebtIncurredDateStart);
            type("doc_debt_incurred_date_end_xpath", docDebtIncurredDateEnd);
            click("doc_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
