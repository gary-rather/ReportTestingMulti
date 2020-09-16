package obieeReportsTests;

import obieeReportsBase.TestBaseReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReadOnlyAccess extends TestBaseReports {

    @BeforeClass
    public void runBeforeClass(){
        System.out.println("Report ReadOnlyAccess setTheTest: "  );
        super.setTheTest("ReadOnlyAccess");
    }

    @Test
    public void readOnlyAccess() throws InterruptedException {

        System.out.println("Report ReadOnlyAccess setTheTest: "  );

        runBeforeClass();
        super.setUp();

        System.out.println("Try ReadOnlyAccess");

        if (config.getProperty("reportRequested").equalsIgnoreCase("read only access")
                || this.getTheTest().equals("ReadOnlyAccess")) {

            Thread.sleep(1000);
            WebElement iframe = driver.findElement(By.xpath("//iframe"));
            driver.switchTo().frame(iframe);

            click("roa_org_access_field_xpath");
            click("roa_org_access_all_selection_xpath");
            Thread.sleep(1000);
            click("roa_org_access_all_selection_xpath");
            click("roa_org_access_field_xpath");

            click("roa_run_report_xpath");

        } else {

            throw new SkipException("not running this report currently");

        }

    }

}
