package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FPLP_FEMA extends TestBaseReports {

    @BeforeClass
    public void runBeforeClass(){
        System.out.println("Report FPLP/FEMA setTheTest: "  );
        super.setTheTest("FPLP_FEMA");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void FPLP_FEMA(String ffOrganization,String ffDprtDateStart, String ffDprtDateEnd)
            throws InterruptedException {

        System.out.println("Report FPLP/FEMA setTheTest: "  );

        runBeforeClass();
        super.setUp();

        System.out.println("Try FPLP/FEMA");

        if (config.getProperty("reportRequested").equalsIgnoreCase("fplp fema")
                || this.getTheTest().equals("FPLP_FEMA")) {

            click("ff_reset_menu_xpath");
            click("ff_clear_all_data_xpath");

            type("ff_organization_xpath", ffOrganization);
            type("ff_dprt_date_start_xpath", ffDprtDateStart);
            type("ff_dprt_date_end_xpath", ffDprtDateEnd);

            click("ff_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
