package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LodgingNonUseReasonJustification extends TestBaseReports {

    @BeforeClass
    public void setTheTest(){
        System.out.println("Report LodgingNonUseReasonJustification setTheTest: "  );
        super.setTheTest("LodgingNonUseReasonJustification");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void lodgingNonUseReasonJustification(String lnuApproveDateStart,String lnuApproveDateEnd) {

        if (config.getProperty("reportRequested").equalsIgnoreCase("lodging non use reason")
                || this.getTheTest().equals("LodgingNonUseReasonJustification")) {

            System.out.println("Try LodgingNonUseReasonJustification 1");

            click("lnu_organization_field_xpath");
            click("lnu_organization_all_selection_xpath");

            click("lnu_doctype_field_xpath");
            click("lnu_doctype_all_selection_xpath");

            type("lnu_approve_date_start_xpath", lnuApproveDateStart);
            type("lnu_approve_date_end_xpath", lnuApproveDateEnd);

            click("lnu_tdy_state_field_xpath");
            click("lnu_tdy_state_field_all_selection_xpath");

            click("lnu_tdy_location_field_xpath");
            click("lnu_tdy_location_field_all_selection_xpath");

            click("lnu_metro_area_field_xpath");
            click("lnu_metro_area_all_selection_xpath");

            click("lnu_reason_code_field_xpath");
            click("lnu_reason_code_all_selection_xpath");

            click("lnu_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
