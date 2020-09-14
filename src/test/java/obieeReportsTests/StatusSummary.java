package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StatusSummary extends TestBaseReports {

    @BeforeClass
    public void runBeforeClass(){
        System.out.println("Report StatusSummary setTheTest: "  );
        super.setTheTest("StatusSummary");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void statusSummary (String ssumDoctype, String ssumDocstat) throws InterruptedException {

        System.out.println("Report StatusSummary setTheTest: "  );

        runBeforeClass();
        super.setUp();

        System.out.println("Try StatusSummary");

        System.out.println("StatusSummary");
        if (config.getProperty("reportRequested").equalsIgnoreCase("status summary")
                || this.getTheTest().equals("StatusSummary")) {

            System.out.println("Try StatusSummary 1");

            click("ssum_reset_menu_xpath");
            click("ssum_reset_to_default_xpath");

            click("ssum_organization_field_xpath");
            click("ssum_organization_all_selection_xpath");

            type("ssum_doctype_xpath", ssumDoctype);
            type("ssum_docstat_xpath", ssumDocstat);

            click("ssum_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
