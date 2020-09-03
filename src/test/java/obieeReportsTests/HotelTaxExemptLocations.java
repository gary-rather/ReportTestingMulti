package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HotelTaxExemptLocations extends TestBaseReports {

    @BeforeClass
    public void setTheTest(){
        System.out.println("Report HotelTaxExemptLocations setTheTest: "  );
        super.setTheTest("HotelTaxExemptLocations");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void hotelTaxExemptLocations(String htelOrganization,String htelTaxExemptLocation,
                                        String htelExpenseDateStart, String htelExpenseDateEnd) {

        if (config.getProperty("reportRequested").equalsIgnoreCase("hotel tax exempt locations")
                || this.getTheTest().equals("HotelTaxExemptLocations")) {

            System.out.println("Try HotelTaxExemptLocations 1");

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
