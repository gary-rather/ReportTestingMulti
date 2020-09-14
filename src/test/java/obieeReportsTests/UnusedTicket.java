package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UnusedTicket extends TestBaseReports {

    @BeforeClass
    public void runBeforeClass(){
        System.out.println("Report UnusedTicket setTheTest: "  );
        super.setTheTest("UnusedTicket");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void unusedTicket(String utOrganization, String utTicketNumber, String utTripRtrnDateStart,
                             String utTripRtrnDateEnd, String utTravelerLastName, String utTravelerFirstName,
                             String utTravelerPartialSSN) throws InterruptedException {

        System.out.println("Report UnusedTicket setTheTest: "  );

        runBeforeClass();
        super.setUp();

        System.out.println("Try UnusedTicket");

        if (config.getProperty("reportRequested").equalsIgnoreCase("unused ticket")
                || this.getTheTest().equals("UnusedTicket")) {

            System.out.println("Try UnusedTicket 1");

            click("ut_reset_menu_xpath");
            click("ut_clear_all_data_xpath");

            type("ut_organization_xpath", utOrganization);

            type("ut_ticket_number_xpath", utTicketNumber);
            type("ut_trip_rtrn_date_start_xpath", utTripRtrnDateStart);
            type("ut_trip_rtrn_date_end_xpath", utTripRtrnDateEnd);

            type("ut_traveler_last_name_xpath", utTravelerLastName);
            type("ut_traveler_first_name_xpath", utTravelerFirstName);
            type("ut_traveler_ssn_prtl_xpath", utTravelerPartialSSN);

            click("ut_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
