package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GovernmentLodgingUnavailability extends TestBaseReports {

    @BeforeClass
    public void setTheTest(){
        System.out.println("Report GovernmentLodgingProgramsUnavailability setTheTest: "  );
        super.setTheTest("GovernmentLodgingProgramsUnavailability");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void governmentLodgingUnavailability(String uglDprtDateStart,String uglDprtDateEnd) {

        if (config.getProperty("reportRequested").equalsIgnoreCase("unavailability of government lodging")
                || this.getTheTest().equals("GovernmentLodgingProgramsUnavailability")) {

            System.out.println("Try GovernmentLodgingProgramsUnavailability 1");

            click("ugl_organization_field_xpath");
            click("ugl_organization_all_selection_xpath");

            click("ugl_doctype_field_xpath");
            click("ugl_doctype_all_selection_xpath");

            type("ugl_dprt_date_start_xpath", uglDprtDateStart);
            type("ugl_dprt_date_end_xpath", uglDprtDateEnd);

            click("ugl_tdy_state_field_xpath");
            click("ugl_tdy_state_field_all_selection_xpath");

            click("ugl_tdy_location_field_xpath");
            click("ugl_tdy_location_field_all_selection_xpath");

            click("ugl_booked_lodging_type_field_xpath");
            click("ugl_booked_lodging_type_all_selection_xpath");

            click("ugl_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
