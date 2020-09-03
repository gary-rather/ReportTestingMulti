package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PartnerSystemUnusedTicket extends TestBaseReports {

    @BeforeClass
    public void setTheTest(){
        System.out.println("Report PartnerSystemUnusedTicket setTheTest: "  );
        super.setTheTest("PartnerSystemUnusedTicket");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void partnerSystemUnusedTicket(String psutOrganization, String psutTicketNumber, String psutTripRtrnDateStart,
                             String psutTripRtrnDateEnd, String psutTravelerLastName, String psutTravelerFirstName,
                             String psutTravelerPartialSSN, String psutPartnerSystemCode) {

        System.out.println("Try PartnerSystemUnusedTicket");
        if (config.getProperty("reportRequested").equalsIgnoreCase("ps unused ticket")
                || this.getTheTest().equals("PartnerSystemUnusedTicket")) {

            System.out.println("Try PartnerSystemUnusedTicket 1");

            click("psut_reset_menu_xpath");
            click("psut_clear_all_data_xpath");

            type("psut_organization_xpath", psutOrganization);

            type("psut_ticket_number_xpath", psutTicketNumber);
            type("psut_trip_rtrn_date_start_xpath", psutTripRtrnDateStart);
            type("psut_trip_rtrn_date_end_xpath", psutTripRtrnDateEnd);

            type("psut_traveler_last_name_xpath", psutTravelerLastName);
            type("psut_traveler_first_name_xpath", psutTravelerFirstName);
            type("psut_traveler_ssn_prtl_xpath", psutTravelerPartialSSN);

            type("psut_partner_system_code_xpath", psutPartnerSystemCode);

            click("psut_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
