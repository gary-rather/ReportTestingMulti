package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReadOnlyAccess extends TestBaseReports {

    @BeforeClass
    public void setTheTest(){
        System.out.println("Report ReadOnlyAccess setTheTest: "  );
        super.setTheTest("ReadOnlyAccess");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void readOnlyAccess() {

        System.out.println("Try ReadOnlyAccess");
        if (config.getProperty("reportRequested").equalsIgnoreCase("roa access")
                || this.getTheTest().equals("ReadOnlyAccess")) {

            System.out.println("Try ReadOnlyAccess 1");

            click("roa_org_access_field_xpath");
            click("roa_org_access_all_selection_xpath");
            click("roa_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
