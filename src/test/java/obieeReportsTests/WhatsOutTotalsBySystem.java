package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WhatsOutTotalsBySystem extends TestBaseReports {

    @BeforeClass
    public void setTheTest(){
        System.out.println("Report WhatsOutTotalsBySystem setTheTest: "  );
        super.setTheTest("WhatsOutTotalsBySystem");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void whatsOutTotalsBySystem(String wotsETLDate) {

        System.out.println("Try WhatsOutTotalsBySystem");
        if (config.getProperty("reportRequested").equalsIgnoreCase("totals by system")
                || this.getTheTest().equals("WhatsOutTotalsBySystem")) {

            System.out.println("Try WhatsOutTotalsBySystem 1");

            type("wo1_etl_date_xpath",wotsETLDate);
            click("wo1_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
