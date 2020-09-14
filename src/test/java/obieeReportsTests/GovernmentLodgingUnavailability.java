package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GovernmentLodgingUnavailability extends TestBaseReports {

    @BeforeClass
    public void runBeforeClass(){
        System.out.println("Report GovernmentLodgingProgramsUnavailability setTheTest: "  );
        super.setTheTest("UnavailabilityOfGovernmentLodging");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void governmentLodgingUnavailability(String uglDprtDateStart,String uglDprtDateEnd)
            throws InterruptedException {

        System.out.println("Report GovernmentLodgingProgramsUnavailability setTheTest: "  );

        runBeforeClass();
        super.setUp();

        System.out.println("Try GovernmentLodgingProgramsUnavailability");

        if (config.getProperty("reportRequested").equalsIgnoreCase("unavailability of government lodging")
                || this.getTheTest().equals("UnavailabilityOfGovernmentLodging")) {

            Thread.sleep(1000);
            WebElement iframe = driver.findElement(By.xpath("//iframe"));
            driver.switchTo().frame(iframe);

            System.out.println("Try GovernmentLodgingProgramsUnavailability 1");

            click("ugl_organization_field_xpath");
            click("ugl_organization_all_selection_xpath");
            Thread.sleep(1000);
            click("ugl_organization_all_selection_xpath");
            click("ugl_organization_field_xpath");

            Thread.sleep(1000);
            click("ugl_doctype_field_xpath");
            click("ugl_doctype_all_selection_xpath");
            Thread.sleep(1000);
            click("ugl_doctype_all_selection_xpath");
            click("ugl_doctype_field_xpath");

            Thread.sleep(1000);
            type("ugl_dprt_date_start_xpath", uglDprtDateStart);
            type("ugl_dprt_date_end_xpath", uglDprtDateEnd);

            Thread.sleep(1000);
            click("ugl_tdy_state_field_xpath");
            click("ugl_tdy_state_all_selection_xpath");
            Thread.sleep(1000);
            click("ugl_tdy_state_all_selection_xpath");
            click("ugl_tdy_state_field_xpath");

            Thread.sleep(1000);
            click("ugl_tdy_location_field_xpath");
            click("ugl_tdy_location_all_selection_xpath");
            Thread.sleep(1000);
            click("ugl_tdy_location_all_selection_xpath");
            click("ugl_tdy_location_field_xpath");

            Thread.sleep(1000);
            click("ugl_booked_lodging_type_field_xpath");
            click("ugl_booked_lodging_type_all_selection_xpath");
            Thread.sleep(1000);
            click("ugl_booked_lodging_type_all_selection_xpath");
            click("ugl_booked_lodging_type_field_xpath");

            click("ugl_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
