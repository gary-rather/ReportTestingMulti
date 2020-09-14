package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LodgingNonUseReason extends TestBaseReports {

    @BeforeClass
    public void runBeforeClass(){
        System.out.println("Report LodgingNonUseReasonJustification setTheTest: "  );
        super.setTheTest("LodgingNonUseReason");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void lodgingNonUseReasonJustification(String lnuApproveDateStart, String lnuApproveDateEnd)
            throws InterruptedException {

        System.out.println("Report LodgingNonUseReasonJustification setTheTest: "  );

        runBeforeClass();
        super.setUp();

        System.out.println("Try LodgingNonUseReasonJustification");

        if (config.getProperty("reportRequested").equalsIgnoreCase("lodging non use reason")
                || this.getTheTest().equals("LodgingNonUseReason")) {

            Thread.sleep(1000);
            WebElement iframe = driver.findElement(By.xpath("//iframe"));
            driver.switchTo().frame(iframe);

            click("lnu_organization_field_xpath");
            click("lnu_organization_all_selection_xpath");
            Thread.sleep(1000);
            click("lnu_organization_all_selection_xpath");
            click("lnu_organization_field_xpath");

            Thread.sleep(1000);
            click("lnu_doctype_field_xpath");
            click("lnu_doctype_all_selection_xpath");
            Thread.sleep(1000);
            click("lnu_doctype_all_selection_xpath");
            click("lnu_doctype_field_xpath");

            Thread.sleep(1000);
            type("lnu_approve_date_start_xpath", lnuApproveDateStart);
            type("lnu_approve_date_end_xpath", lnuApproveDateEnd);

            Thread.sleep(1000);
            click("lnu_tdy_state_field_xpath");
            click("lnu_tdy_state_field_all_selection_xpath");
            Thread.sleep(1000);
            click("lnu_tdy_state_field_all_selection_xpath");
            click("lnu_tdy_state_field_xpath");

            Thread.sleep(1000);
            click("lnu_tdy_location_field_xpath");
            click("lnu_tdy_location_field_all_selection_xpath");
            Thread.sleep(1000);
            click("lnu_tdy_location_field_all_selection_xpath");
            click("lnu_tdy_location_field_xpath");

            Thread.sleep(1000);
            click("lnu_metro_area_field_xpath");
            click("lnu_metro_area_all_selection_xpath");
            Thread.sleep(1000);
            click("lnu_metro_area_all_selection_xpath");
            click("lnu_metro_area_field_xpath");

            Thread.sleep(1000);
            click("lnu_reason_code_field_xpath");
            click("lnu_reason_code_all_selection_xpath");
            Thread.sleep(1000);
            click("lnu_reason_code_all_selection_xpath");
            click("lnu_reason_code_field_xpath");

            Thread.sleep(1000);
            click("lnu_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
