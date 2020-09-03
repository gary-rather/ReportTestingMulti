package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StatusSummary extends TestBaseReports {

    @BeforeClass
    public void setTheTest(){
        System.out.println("Report StatusSummary setTheTest: "  );
        super.setTheTest("StatusSummary");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void statusSummary1 (String ssumOrganization, String ssumDoctype, String ssumDocstat) {

        System.out.println("StatusSummary");
        if (config.getProperty("reportRequested").equalsIgnoreCase("status summary")
                || this.getTheTest().equals("StatusSummary")) {

            System.out.println("Try StatusSummary 1");

            click("ssum_reset_menu_xpath");
            click("ssum_clear_all_data_xpath");

            type("ssum_organization_xpath", ssumOrganization);

            type("ssum_doctype_xpath", ssumDoctype);
            type("ssum_docstat_xpath", ssumDocstat);

            click("cba_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
