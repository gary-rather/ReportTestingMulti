package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CTOFee extends TestBaseReports {

    @BeforeClass
    public void setTheTest(){
        System.out.println("Report CTOFee setTheTest: "  );
        super.setTheTest("CTOFee");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void ctoFee(String ctoOrganization, String ctoTicketDateStart, String ctoTicketDateEnd) {

        System.out.println("Try CTOFee");
        if (config.getProperty("reportRequested").equalsIgnoreCase("cto fee")
                || this.getTheTest().equals("CTOFee")) {

            System.out.println("Try CTOFee 1");

            click("cto_reset_menu_xpath");
            click("cto_clear_all_data_xpath");

            type("cto_organization_xpath", ctoOrganization);

            type("cto_ticket_date_start_xpath", ctoTicketDateStart);
            type("cto_ticket_date_end_xpath", ctoTicketDateEnd);

            click("cto_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
