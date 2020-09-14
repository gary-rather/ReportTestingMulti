package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import obieeReportsUtilities.TestUtilReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WhatsOutTotalsBySystem extends TestBaseReports {

    @BeforeClass
    public void runBeforeClass(){
        System.out.println("Report WhatsOutTotalsBySystem setTheTest: "  );
        super.setTheTest("TotalsBySystem");
    }

    @Test(dataProviderClass = TestUtilReports.class, dataProvider = "dp")
    public void whatsOutTotalsBySystem(String wotsETLDate) throws InterruptedException {

        System.out.println("Report WhatsOutTotalsBySystem setTheTest: "  );

        runBeforeClass();
        super.setUp();

        System.out.println("Try WhatsOutTotalsBySystem");

        if (config.getProperty("reportRequested").equalsIgnoreCase("totals by system")
                || this.getTheTest().equals("TotalsBySystem")) {

            Thread.sleep(1000);
            WebElement iframe = driver.findElement(By.xpath("//iframe"));
            driver.switchTo().frame(iframe);

            System.out.println("Try WhatsOutTotalsBySystem 1");

            //clear default
            WebElement etlDateField = driver.findElement
                    (By.xpath(OR.getProperty("wo1_etl_date_xpath")));
            etlDateField.clear();

            //enter date from data driver
            type("wo1_etl_date_xpath",wotsETLDate);
            click("wo1_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
