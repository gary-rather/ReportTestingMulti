package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PartnerSystemPosackDelinquency extends TestBaseReports {

    @BeforeClass
    public void setTheTest(){
        System.out.println("Report Partner System PosAckDelinquency setTheTest: "  );
        super.setTheTest("Partner System PosAckDelinquency");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void partnerSystemPosAckDelinquency(String pspadOrganization, String pspadNumHrsDelinquent,
                                               String pspadTransactionCategory, String pspadPartnerSystem) {

        System.out.println("Try Partner System PosAckDelinquency");
        if (config.getProperty("reportRequested").equalsIgnoreCase("ps posack delinquency")
                || this.getTheTest().equals("PartnerSystemPosAckDelinquency")) {

            System.out.println("Try Partner System PosAckDelinquency 1");
            //click("pspad_cont_to_report_id");

            System.out.println("Try Partner System PosAckDelinquency 2");
            click("pspad_reset_menu_xpath");

            System.out.println("Try Partner System PosAckDelinquency 3");
            click("pspad_clear_all_data_xpath");

            System.out.println("Try Partner System PosAckDelinquency 4");

            type("pspad_organization_xpath", pspadOrganization);

            Integer hrs = Float.valueOf(pspadNumHrsDelinquent).intValue();
            type("pspad_num_hrs_delinquent_xpath", hrs.toString());

            type("pspad_transaction_category_xpath", pspadTransactionCategory);
            type("pspad_partner_system_xpath", pspadPartnerSystem);

            System.out.println("Try Partner System PosAckDelinquency Go");
            click("pspad_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
