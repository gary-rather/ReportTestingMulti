package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WhatsOutTransactionDetails extends TestBaseReports {

    @BeforeClass
    public void runBeforeClass(){
        System.out.println("Report WhatsOutTransactionDetails setTheTest: "  );
        super.setTheTest("TransactionDetails");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void whatsOutTransactionDetails(String wotdETLDate, String wotdLateFlag, String wotdIncludeUnknownLabel)
            throws InterruptedException {

        System.out.println("Report WhatsOutTransactionDetails setTheTest: "  );

        runBeforeClass();
        super.setUp();

        System.out.println("Try WhatsOutTransactionDetails");

        if (config.getProperty("reportRequested").equalsIgnoreCase("transaction details")
                || this.getTheTest().equals("TransactionDetails")) {

            Thread.sleep(1000);
            WebElement iframe = driver.findElement(By.xpath("//iframe"));
            driver.switchTo().frame(iframe);

            System.out.println("Try WhatsOutTransactionDetails 1");

            WebElement etlDateField = driver.findElement
                    (By.xpath(OR.getProperty("wo2_etl_date_xpath")));
            etlDateField.clear();

            Thread.sleep(1000);
            type("wo2_etl_date_xpath",wotdETLDate);

            Thread.sleep(1000);
            click("wo2_late_flag_field_xpath");
            if(wotdLateFlag.equalsIgnoreCase("All")) {
                click("wo2_late_flag_all_selection_xpath");
            } else if(wotdLateFlag.equalsIgnoreCase("Yes")) {
                click("wo2_late_flag_yes_selection_xpath");
            } else if(wotdLateFlag.equalsIgnoreCase("No")) {
                click("wo2_late_flag_no_selection_xpath");
            } else {
                throw new SkipException("invalid input - try again");
            }

            Thread.sleep(1000);
            click("wo2_transaction_label_field_xpath");
            click("wo2_transaction_label_all_selection_xpath");
            Thread.sleep(1000);
            click("wo2_transaction_label_all_selection_xpath");
            click("wo2_transaction_label_field_xpath");

            Thread.sleep(1000);
            click("wo2_include_unknown_label_field_xpath");
            if(wotdIncludeUnknownLabel.equalsIgnoreCase("Yes")) {
                click("wo2_include_unknown_label_yes_selection_xpath");
            } else if(wotdIncludeUnknownLabel.equalsIgnoreCase("No")) {
                click("wo2_include_unknown_label_no_selection_xpath");
            } else {
                throw new SkipException("invalid input - try again");
            }

            Thread.sleep(1000);
            click("wo2_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
