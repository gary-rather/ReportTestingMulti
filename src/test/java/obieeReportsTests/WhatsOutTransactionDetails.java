package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WhatsOutTransactionDetails extends TestBaseReports {

    @BeforeClass
    public void setTheTest(){
        System.out.println("Report WhatsOutTransactionDetails setTheTest: "  );
        super.setTheTest("WhatsOutTransactionDetails");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void whatsOutTransactionDetails(String wotdETLDate, String wo2IncludeUnknownLabel) {

        System.out.println("Try WhatsOutTransactionDetails");
        if (config.getProperty("reportRequested").equalsIgnoreCase("transaction details")
                || this.getTheTest().equals("WhatsOutTransactionDetails")) {

            System.out.println("Try WhatsOutTransactionDetails 1");

            type("wo2_etl_date_xpath",wotdETLDate);
            click("wo2_late_flag_field_xpath");
            click("wo2_late_flag_all_selection_xpath");
            click("wo2_transaction_label_field_xpath");
            click("wo2_transaction_label_all_selection_xpath");

            click("wo2_include_unknown_label_field_xpath");
            if(wo2IncludeUnknownLabel.equalsIgnoreCase("Y")) {
                click("wo2_include_unknown_label_yes_selection_xpath");
            } else if(wo2IncludeUnknownLabel.equalsIgnoreCase("N")) {
                click("wo2_include_unknown_label_no_selection_xpath");
            } else {
                throw new SkipException("invalid input - try again");
            }

            click("wo2_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
