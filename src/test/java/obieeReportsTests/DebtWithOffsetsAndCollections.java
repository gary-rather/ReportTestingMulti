package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DebtWithOffsetsAndCollections extends TestBaseReports {

    @BeforeClass
    public void setTheTest(){
        System.out.println("Report DebtWithOffsetsAndCollections setTheTest: "  );
        super.setTheTest("DebtWithOffsetsAndCollections");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void debtWithOffsetsAndCollections(String docDebtIncurredDateStart, String docDebtIncurredDateEnd) {

        System.out.println("Try DebtWithOffsetsAndCollections");
        if (config.getProperty("reportRequested").equalsIgnoreCase("debt with offsets and collections")
                || this.getTheTest().equals("DebtWithOffsetsAndCollections")) {

            System.out.println("Try DebtWithOffsetsAndCollections 1");

            click("doc_organization_field_xpath");
            click("doc_organization_all_selection_xpath");
            type("doc_debt_incurred_date_start_xpath", docDebtIncurredDateStart);
            type("doc_debt_incurred_date_end_xpath", docDebtIncurredDateEnd);
            click("doc_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
