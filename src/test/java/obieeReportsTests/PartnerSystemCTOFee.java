package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PartnerSystemCTOFee extends TestBaseReports {

    @BeforeClass
    public void setTheTest(){
        System.out.println("Report PartnerSystemCTOFee setTheTest: "  );
        super.setTheTest("PartnerSystemCTOFee");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void partnerSystemCTOFee(String psctoOrganization, String psctoTicketDateStart,
                                    String psctoTicketDateEnd, String psctoPartnerSystem) {

        System.out.println("Try PartnerSystemCTOFee");
        if (config.getProperty("reportRequested").equalsIgnoreCase("ps cto fee")
                || this.getTheTest().equals("PartnerSystemCTOFee")) {

            System.out.println("Try PartnerSystemCTOFee 1");

            click("pscto_reset_menu_xpath");
            click("pscto_clear_all_data_xpath");

            type("pscto_organization_xpath", psctoOrganization);

            type("pscto_ticket_date_start_xpath", psctoTicketDateStart);
            type("pscto_ticket_date_end_xpath", psctoTicketDateEnd);

            type("pscto_partner_system_xpath", psctoPartnerSystem);

            click("pscto_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
