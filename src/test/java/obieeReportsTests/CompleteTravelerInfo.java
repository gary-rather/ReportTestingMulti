package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CompleteTravelerInfo extends TestBaseReports {

    @BeforeClass
    public void runBeforeClass(){
        System.out.println("Report CompleteTravelerInfo setTheTest: "  );
        super.setTheTest("CompleteTravelerInfo");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void completeTravelerInfo(String ctitShowFullSSN, String ctitOnlyTDY, String ctitNextTravelDateStart,
                                     String ctitNextTravelDateEnd, String ctiuShowFullSSN, String ctiuOnlyTDY,
                                     String ctiuNextTravelDateStart, String ctiuNextTravelDateEnd,
                                     String ctiuProfileUpdatedSinceDate, String ctipShowFullSSN, String ctipOnlyTDY,
                                     String ctipNextTravelDateStart, String ctipNextTravelDateEnd,
                                     String ctiaShowFullSSN, String ctiaOnlyTDY, String ctiaNextTravelDateStart,
                                     String ctiaNextTravelDateEnd, String ctiaAccountActiveFlag,
                                     String ctiaExpDateOnAfter) throws InterruptedException {

        System.out.println("Report CompleteTravelerInfo setTheTest: "  );

        runBeforeClass();
        super.setUp();

        System.out.println("Try CompleteTravelerInfo");

        if (config.getProperty("reportRequested").equalsIgnoreCase("complete traveler info")
                || this.getTheTest().equals("CompleteTravelerInfo")) {

            Thread.sleep(1000);
            WebElement iframe = driver.findElement(By.xpath("//iframe"));
            driver.switchTo().frame(iframe);

            Thread.sleep(1000);
            click("ctit_organization_field_xpath");
            click("ctit_organization_all_selection_xpath");
            Thread.sleep(1000);
            click("ctit_organization_all_selection_xpath");
            click("ctit_organization_field_xpath");

            Thread.sleep(1000);
            click("ctit_show_full_ssn_field_xpath");
            if(ctitShowFullSSN.equalsIgnoreCase("Yes")) {
                click("ctit_show_full_ssn_yes_selection_xpath");
            } else if(ctitShowFullSSN.equalsIgnoreCase("No")) {
                click("ctit_show_full_ssn_no_selection_xpath");
            } else {
                throw new SkipException("invalid input - try again");
            }

            Thread.sleep(1000);
            click("ctit_only_tdy_field_xpath");
            if(ctitOnlyTDY.equalsIgnoreCase("Yes")) {
                click("ctit_only_tdy_yes_selection_xpath");
            } else if(ctitOnlyTDY.equalsIgnoreCase("No")) {
                click("ctit_only_tdy_no_selection_xpath");
            } else {
                throw new SkipException("invalid input - try again");
            }

            Thread.sleep(1000);
            type("ctit_next_travel_date_start_xpath", ctitNextTravelDateStart);
            type("ctit_next_travel_date_end_xpath", ctitNextTravelDateEnd);
            click("ctit_run_report_xpath");
            Thread.sleep(1000);

            // User Details
            System.out.println("Try CompleteTravelerInfo UserDetails");

            Thread.sleep(1000);
            click("ctiu_organization_field_xpath");
            click("ctiu_organization_all_selection_xpath ");
            Thread.sleep(1000);
            click("ctiu_organization_all_selection_xpath ");
            click("ctiu_organization_field_xpath");

            Thread.sleep(1000);
            click("ctiu_show_full_ssn_field_xpath");
            if(ctiuShowFullSSN.equalsIgnoreCase("Yes")) {
                click("ctiu_show_full_ssn_yes_selection_xpath");
            } else if(ctiuShowFullSSN.equalsIgnoreCase("No")) {
                click("ctiu_show_full_ssn_no_selection_xpath");
            } else {
                throw new SkipException("invalid input - try again");
            }

            Thread.sleep(1000);
            click("ctiu_only_tdy_field_xpath");
            if(ctiuOnlyTDY.equalsIgnoreCase("Yes")) {
                click("ctiu_only_tdy_yes_selection_xpath");
            } else if(ctiuOnlyTDY.equalsIgnoreCase("No")) {
                click("ctiu_only_tdy_no_selection_xpath");
            } else {
                throw new SkipException("invalid input - try again");
            }

            Thread.sleep(1000);
            type("ctiu_next_travel_date_start_xpath", ctiuNextTravelDateStart);
            type("ctiu_next_travel_date_end_xpath", ctiuNextTravelDateEnd);
            type("ctiu_profile_updated_since_date_xpath", ctiuProfileUpdatedSinceDate);
            click("ctiu_run_report_xpath");
            Thread.sleep(1000);

            // Person Details
            System.out.println("Try CompleteTravelerInfo PersonDetails");

            Thread.sleep(1000);
            click("ctip_organization_field_xpath");
            click("ctip_organization_all_selection_xpath");
            Thread.sleep(1000);
            click("ctip_organization_all_selection_xpath");
            click("ctip_organization_field_xpath");

            Thread.sleep(1000);
            click("ctip_show_full_ssn_field_xpath");
            if(ctipShowFullSSN.equalsIgnoreCase("Yes")) {
                click("ctip_show_full_ssn_yes_selection_xpath");
            } else if(ctipShowFullSSN.equalsIgnoreCase("No")) {
                click("ctip_show_full_ssn_no_selection_xpath");
            } else {
                throw new SkipException("invalid input - try again");
            }

            Thread.sleep(1000);
            click("ctip_only_tdy_field_xpath");
            if(ctipOnlyTDY.equalsIgnoreCase("Yes")) {
                click("ctip_only_tdy_yes_selection_xpath");
            } else if(ctipOnlyTDY.equalsIgnoreCase("No")) {
                click("ctip_only_tdy_no_selection_xpath");
            } else {
                throw new SkipException("invalid input - try again");
            }

            Thread.sleep(1000);
            type("ctip_next_travel_date_start_xpath", ctipNextTravelDateStart);
            type("ctip_next_travel_date_end_xpath", ctipNextTravelDateEnd);
            click("ctip_run_report_xpath");
            Thread.sleep(1000);

            // Account Details
            System.out.println("Try CompleteTravelerInfo AccountDetails");

            Thread.sleep(1000);
            click("ctia_organization_field_xpath");
            click("ctia_organization_all_selection_xpath ");
            Thread.sleep(1000);
            click("ctia_organization_all_selection_xpath ");
            click("ctia_organization_field_xpath");

            Thread.sleep(1000);
            click("ctia_show_full_ssn_field_xpath");
            if(ctiaShowFullSSN.equalsIgnoreCase("Yes")) {
                click("ctia_show_full_ssn_yes_selection_xpath");
            } else if(ctiaShowFullSSN.equalsIgnoreCase("No")) {
                click("ctia_show_full_ssn_no_selection_xpath");
            } else {
                throw new SkipException("invalid input - try again");
            }

            Thread.sleep(1000);
            click("ctia_only_tdy_field_xpath");
            if(ctiaOnlyTDY.equalsIgnoreCase("Yes")) {
                click("ctia_only_tdy_yes_selection_xpath");
            } else if(ctiaOnlyTDY.equalsIgnoreCase("No")) {
                click("ctia_only_tdy_no_selection_xpath");
            } else {
                throw new SkipException("invalid input - try again");
            }

            Thread.sleep(1000);
            type("ctia_next_travel_date_start_xpath", ctiaNextTravelDateStart);
            type("ctia_next_travel_date_end_xpath", ctiaNextTravelDateEnd);

            Thread.sleep(1000);
            click("ctia_account_active_flag_field_xpath");
            if(ctiaAccountActiveFlag.equalsIgnoreCase("All")) {
                click("ctia_account_active_flag_any_selection_xpath");
            } else if(ctiaAccountActiveFlag.equalsIgnoreCase("Yes")) {
                click("ctia_account_active_flag_yes_selection_xpath");
            } else if(ctiaAccountActiveFlag.equalsIgnoreCase("No")) {
                click("ctia_account_active_flag_no_selection_xpath");
            } else {
                throw new SkipException("invalid input - try again");
            }

            Thread.sleep(1000);
            type("ctia_exp_date_on_after_xpath", ctiaExpDateOnAfter);
            click("ctia_run_report_xpath");

        }

    }

}
