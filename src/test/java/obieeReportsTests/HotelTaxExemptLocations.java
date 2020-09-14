package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HotelTaxExemptLocations extends TestBaseReports {

    @BeforeClass
    public void runBeforeClass(){
        System.out.println("Report HotelTaxExemptLocations setTheTest: "  );
        super.setTheTest("HotelTaxExemptLocations");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void hotelTaxExemptLocations(String htelOrganization,String htelTaxExemptLocation,
                                        String htelExpenseDateStart, String htelExpenseDateEnd)
            throws InterruptedException {

        System.out.println("Report HotelTaxExemptLocations setTheTest: "  );

        runBeforeClass();
        super.setUp();

        System.out.println("Try HotelTaxExemptLocations");

        if (config.getProperty("reportRequested").equalsIgnoreCase("hotel tax exempt locations")
                || this.getTheTest().equals("HotelTaxExemptLocations")) {

            click("htel_reset_menu_xpath");
            click("htel_clear_all_data_xpath");

            type("htel_organization_xpath", htelOrganization);
            type("htel_tax_exempt_location_xpath", htelTaxExemptLocation);
            type("htel_expense_date_start_xpath", htelExpenseDateStart);
            type("htel_expense_date_end_xpath", htelExpenseDateEnd);

            click("htel_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
