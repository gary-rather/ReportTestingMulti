package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CBA_TO extends TestBaseReports {

    @BeforeClass
    public void setTheTest(){
        System.out.println("Report CBA_TO setTheTest: "  );
        super.setTheTest("CBA_TO");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void cbaTo (String cbaOrganization, String cbaDprtDateStart, String cbaDprtDateEnd,
                       String cbaExceptionsOnly) {

        System.out.println("Try CBA_TO");
        if (config.getProperty("reportRequested").equalsIgnoreCase("cba to")
                || this.getTheTest().equals("CBA_TO")) {

            System.out.println("Try CBA_TO 1");

            click("cba_reset_menu_xpath");
            click("cba_clear_all_data_xpath");

            type("cba_organization_xpath", cbaOrganization);

            type("cba_dprt_date_start_xpath", cbaDprtDateStart);
            type("cba_dprt_date_end_xpath", cbaDprtDateEnd);

            click("cba_exceptions_only_dropdown_xpath");
            if(cbaExceptionsOnly.equalsIgnoreCase("Y")) {
                click("cba_exceptions_only_yes_xpath");
            } else if(cbaExceptionsOnly.equalsIgnoreCase("N")) {
                click("cba_exceptions_only_no_xpath");
            } else {
                throw new SkipException("invalid input - try again");
            }

            click("cba_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
