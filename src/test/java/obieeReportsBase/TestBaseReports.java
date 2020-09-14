package obieeReportsBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import obieeReportsUtilities.ExcelReader1;

public class TestBaseReports {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("TestBaseReports");
	public static String user_dir = System.getProperty("user.dir");
	public static ExcelReader1 excel = new ExcelReader1(
			user_dir + "\\src\\test\\resources\\obieeReportsExcel\\Test Data Reports.xlsx");
	public static WebDriverWait wait;

	public String theTest = null;

	@BeforeSuite
	public void resources() throws InterruptedException {
		log.debug("TestBaseReports resources() start " );

		try {
			fis = new FileInputStream(user_dir + "\\src\\test\\resources\\obieeReportsProperties\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fis = new FileInputStream(user_dir + "\\src\\test\\resources\\obieeReportsProperties\\OR.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			OR.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		log.debug("TestBaseReports resources() exit " );
	}

	public void setUp() throws InterruptedException {
        log.debug("TestBaseReports setup()  " + theTest);

        driver = null;
		if (driver == null) {
			if (config.getProperty("browser").equals("chrome")) {
              try {
				  System.setProperty("webdriver.chrome.driver", user_dir + "/src/test/resources/SeleniumWebDrivers/chromedriver.exe");

				  driver = new ChromeDriver();
				  driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
				  log.debug("Chrome browser launched");
			  } catch (Exception e){
              	System.out.println("Error caught");
              	log.error("Error ", e);
              	System.out.println("");
			  }

			} else if (config.getProperty("browser").equals("edge")) {
				System.setProperty("webdriver.chrome.driver", user_dir + "/src/test/resources/SeleniumWebDrivers/edgedriver.exe");

				driver = new EdgeDriver();
				log.debug("Edge browser launched");

			} else if (config.getProperty("browser").equals("firefox")) {

				System.setProperty("webdriver.chrome.driver", user_dir + "/src/test/resources/SeleniumWebDrivers/geckodriver.exe");

				driver = new FirefoxDriver();
				log.debug("Firefox browser launched");

			}

			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			driver.get(config.getProperty("testingurl"));

			log.debug("Navigated to " + config.getProperty("testingurl"));

			driver.manage().window().maximize();

			//driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id='idUser']")).sendKeys(config.getProperty("userID"));
			driver.findElement(By.xpath("//*[@id=\'idPassword\']")).sendKeys(config.getProperty("password"));
			driver.findElement(By.xpath("//*[@id=\'btn_login\']")).click();
            log.debug("Logging in OBIEE " + theTest);

			WebElement dashbd = driver.findElement(By.xpath("//*[@id='dashboard']"));
			dashbd.click();
			WebElement dtshome = driver.findElement(By.xpath("//*[text() = 'DTS Reports Home']"));
			dtshome.click();

			log.debug("Inside OBIEE");
            String repReq = config.getProperty("reportRequested");
			if (config.getProperty("reportRequested").equals("status summary")
					|| config.getProperty("reportRequested").equalsIgnoreCase("routing status")
					|| config.getProperty("reportRequested").equalsIgnoreCase("document status details")
					|| config.getProperty("reportRequested").equalsIgnoreCase("traveler status")
					|| config.getProperty("reportRequested").equalsIgnoreCase("unsubmitted voucher")
					|| theTest.equals("StatusSummary")
					|| theTest.equals("RoutingStatus")
					|| theTest.equals("DocumentStatusDetails")
					|| theTest.equals("TravelerStatus")
					|| theTest.equals("UnsubmittedVoucher")) {

				log.debug("Going into Document & Trip Status group");
				//dashbd.click();
				driver.findElement(By.xpath(OR.getProperty("document_and_trip_stat"))).click();

				if (config.getProperty("reportRequested").equalsIgnoreCase("status summary ")
						|| theTest.equals("StatusSummary")) {

					log.debug("Testing Status Summary Report");
					driver.findElement(By.xpath(OR.getProperty("status_summary"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("routing status")
						|| theTest.equals("RoutingStatus")) {

					log.debug("Testing Document Status Details Report");
					driver.findElement(By.xpath(OR.getProperty("routing_status"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("document status details")
						|| theTest.equals("DocumentStatusDetails")) {

					log.debug("Testing Document Status Details Report");
					driver.findElement(By.xpath(OR.getProperty("document_status_details"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("traveler status")
						|| theTest.equals("TravelerStatus")) {

					log.debug("Testing Traveler Status Report");
					driver.findElement(By.xpath(OR.getProperty("traveler_status"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("unsubmitted voucher")
						|| theTest.equals("UnsubmittedVoucher")) {

					log.debug("Testing Unsubmitted Voucher Report");
					driver.findElement(By.xpath(OR.getProperty("unsubmitted_voucher"))).click();

				}

			} else if (config.getProperty("reportRequested").equalsIgnoreCase("constructed travel")
					|| config.getProperty("reportRequested").equalsIgnoreCase("adjustments")
					|| theTest.equals("ConstructedTravel")
					|| theTest.equals("ReportAdjustments")) {

				log.debug("Going into Document Details group");
				//dashbd.click();
				driver.findElement(By.xpath(OR.getProperty("document_details"))).click();

				if (config.getProperty("reportRequested").equalsIgnoreCase("constructed travel")
						|| theTest.equals("ConstructedTravel")) {

					log.debug("Testing Constructed Travel Report");
					driver.findElement(By.xpath(OR.getProperty("constructed_travel"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("adjustments")
						|| theTest.equals("ReportAdjustments")) {

					log.debug("Testing Adjustments Report");
					driver.findElement(By.xpath(OR.getProperty("adjustments"))).click();

				}

			} else if (config.getProperty("reportRequested").equalsIgnoreCase("complete traveler info")
					|| config.getProperty("reportRequested").equalsIgnoreCase("separation of duty")
					|| config.getProperty("reportRequested").equalsIgnoreCase("audit trail govcc eft data")
					|| config.getProperty("reportRequested").equalsIgnoreCase("audit trail user data")
					|| config.getProperty("reportRequested").equalsIgnoreCase("audit trail person data")
					|| config.getProperty("reportRequested").equalsIgnoreCase("read only access")
					|| theTest.equals("CompleteTravelerInfo")
					|| theTest.equals("SeparationOfDuty")
					|| theTest.equals("AuditTrail_GOVCC_EFT_Data")
					|| theTest.equals("AuditTrailUserData")
					|| theTest.equals("AuditTrailPersonData")
					|| theTest.equals("ReadOnlyAccess")) {

				log.debug("Going into Traveler & User Information group");
				driver.findElement(By.xpath(OR.getProperty("traveler_and_user_info"))).click();

				if (config.getProperty("reportRequested").equalsIgnoreCase("complete traveler info")
						|| theTest.equals("CompleteTravelerInfo")) {

					log.debug("Testing Complete Traveler Information List");
					driver.findElement(By.xpath(OR.getProperty("complete_traveler_info"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("separation of duty")
						|| theTest.equals("SeparationOfDuty")) {

					log.debug("Testing Separation Of Duty Report");
					driver.findElement(By.xpath(OR.getProperty("separation_of_duty"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("audit trail govcc eft data")
						|| config.getProperty("reportRequested").equalsIgnoreCase("audit trail user data")
						|| config.getProperty("reportRequested").equalsIgnoreCase("audit trail person data")
						|| theTest.equals("AuditTrail_GOVCC_EFT_Data")
						|| theTest.equals("AuditTrailUserData")
						|| theTest.equals("AuditTrailPersonData")) {

					log.debug("Going into Audit Trail reports");
					driver.findElement(By.xpath(OR.getProperty("audit_trail_all_reports"))).click();

					if (config.getProperty("reportRequested").equalsIgnoreCase("audit trail govcc eft data")
							|| theTest.equals("AuditTrail_GOVCC_EFT_Data")) {

						log.debug("Testing Audit Trail GOVCC & EFT Data Report");
						driver.findElement(By.xpath(OR.getProperty("audit_trail_govcc_eft_data"))).click();

					} else if (config.getProperty("reportRequested").equalsIgnoreCase("audit trail user data")
							|| theTest.equals("AuditTrailUserData")) {

						log.debug("Testing Audit Trail User Data Report");
						driver.findElement(By.xpath(OR.getProperty("audit_trail_user_data"))).click();

					} else if (config.getProperty("reportRequested").equalsIgnoreCase("audit trail person data")
							|| theTest.equals("AuditTrailPersonData")) {

						log.debug("Testing Audit Trail Traveler Data Report");
						driver.findElement(By.xpath(OR.getProperty("audit_trail_person_data"))).click();

					}

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("read only access")
						|| theTest.equals("ReadOnlyAccess")) {

					log.debug("Testing ROA Access Report");
					driver.findElement(By.xpath(OR.getProperty("read_only_access"))).click();

				}

			} else if (config.getProperty("reportRequested").equalsIgnoreCase("unused ticket")
					|| config.getProperty("reportRequested").equalsIgnoreCase("ps unused ticket")
					|| config.getProperty("reportRequested").equalsIgnoreCase("cto fee")
					|| config.getProperty("reportRequested").equalsIgnoreCase("ps cto fee")
					|| config.getProperty("reportRequested").equalsIgnoreCase("cba to")
					|| config.getProperty("reportRequested").equalsIgnoreCase("pending airline cancellation")
					|| theTest.equals("UnusedTicket")
					|| theTest.equals("PartnerSystemUnusedTicket")
					|| theTest.equals("CTOFee")
					|| theTest.equals("PartnerSystemCTOFee")
					|| theTest.equals("CBATO")
					|| theTest.equals("PendingAirlineCancellation")) {

				log.debug("Going into Tickets group");
				//dashbd.click();
				driver.findElement(By.xpath(OR.getProperty("tickets"))).click();

				if (config.getProperty("reportRequested").equalsIgnoreCase("unused ticket")
						|| theTest.equals("UnusedTicket")) {

					log.debug("Testing Unused Ticket Report");
					driver.findElement(By.xpath(OR.getProperty("unused_ticket"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("ps unused ticket")
						|| theTest.equals("PartnerSystemUnusedTicket")) {

					log.debug("Testing Partner System Unused Ticket Report");
					driver.findElement(By.xpath(OR.getProperty("ps_unused_ticket"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("cto fee")
						|| theTest.equals("CTOFee")) {

					log.debug("Testing CTO Fee Report");
					driver.findElement(By.xpath(OR.getProperty("cto_fee"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("ps cto fee")
						|| theTest.equals("PartnerSystemCTOFee")) {

					log.debug("Testing Partner System CTO Fee Report");
					driver.findElement(By.xpath(OR.getProperty("ps_cto_fee"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("cba to")
						|| theTest.equals("CBATO")) {

					log.debug("Testing CBA TO Report");
					driver.findElement(By.xpath(OR.getProperty("cba_to"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("pending airline cancellation")
						|| theTest.equals("PendingAirlineCancellation")) {

					log.debug("Testing Pending Airline Cancellation Report");
					driver.findElement(By.xpath(OR.getProperty("pending_airline_cancel"))).click();

				}

			} else if (config.getProperty("reportRequested").equalsIgnoreCase("military leave")
					|| config.getProperty("reportRequested").equalsIgnoreCase("oconus")
					|| config.getProperty("reportRequested").equalsIgnoreCase("perstempo")
					|| config.getProperty("reportRequested").equalsIgnoreCase("special duty")
					|| config.getProperty("reportRequested").equalsIgnoreCase("fsa")
					|| config.getProperty("reportRequested").equalsIgnoreCase("enlisted bas")
					|| theTest.equals("MilitaryLeave")
					|| theTest.equals("ReportOCONUS")
					|| theTest.equals("ReportPERSTEMPO")
					|| theTest.equals("SpecialDuty")
					|| theTest.equals("ReportFSA")
					|| theTest.equals("EnlistedBAS")) {

				log.debug("Going into Miltary Information group");
				//dashbd.click();
				driver.findElement(By.xpath(OR.getProperty("military_info"))).click();

				if (config.getProperty("reportRequested").equalsIgnoreCase("military leave")
						|| theTest.equals("MilitaryLeave")) {

					log.debug("Testing Military Leave Report");
					driver.findElement(By.xpath(OR.getProperty("military_leave"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("oconus")
						|| theTest.equals("ReportOCONUS")) {

					log.debug("Testing OCONUS Report");
					driver.findElement(By.xpath(OR.getProperty("oconus"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("perstempo")
						|| theTest.equals("ReportPERSTEMPO")) {

					log.debug("Testing PERSTEMPO Report");
					driver.findElement(By.xpath(OR.getProperty("perstempo"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("special duty")
						|| theTest.equals("SpecialDuty")) {

					log.debug("Testing Special Duty Report");
					driver.findElement(By.xpath(OR.getProperty("special_duty"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("fsa")
						|| theTest.equals("ReportFSA")) {

					log.debug("Testing FSA Report");
					driver.findElement(By.xpath(OR.getProperty("fsa"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("enlisted bas")
						|| theTest.equals("EnlistedBAS")) {

					log.debug("Testing Enslited BAS Report");
					driver.findElement(By.xpath(OR.getProperty("enlisted_bas"))).click();

				}

			} else if (config.getProperty("reportRequested").equalsIgnoreCase("expense report by category")
					|| config.getProperty("reportRequested").equalsIgnoreCase("expense report by document name")
					|| config.getProperty("reportRequested").equalsIgnoreCase("expense without required receipt")
					|| config.getProperty("reportRequested").equalsIgnoreCase("hotel tax exempt locations")
					|| theTest.equals("ExpenseReportByCategory")
					|| theTest.equals("ExpenseReportByDocumentName")
					|| theTest.equals("ExpenseWithoutRequiredReceipt")
					|| theTest.equals("HotelTaxExemptLocations")) {

				log.debug("Going into Expenses group");
				//dashbd.click();
				driver.findElement(By.xpath(OR.getProperty("expenses"))).click();

				if (config.getProperty("reportRequested").equalsIgnoreCase("expense report by category")
						|| theTest.equals("ExpenseReportByCategory")) {

					log.debug("Testing Expense By Category Report");
					driver.findElement(By.xpath(OR.getProperty("expense_by_category"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("expense report by document name")
						|| theTest.equals("ExpenseReportByDocumentName")) {

					log.debug("Testing Expense By Document Name Report");
					driver.findElement(By.xpath(OR.getProperty("expense_by_document_name"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("expense without required receipt")
						|| theTest.equals("ExpenseWithoutRequiredReceipt")) {

					log.debug("Testing Expense Without Required Receipt Report");
					driver.findElement(By.xpath(OR.getProperty("expense_without_receipt"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("hotel tax exempt locations")
						|| theTest.equals("HotelTaxExemptLocations")) {

					log.debug("Testing Hotel Tax Exempt Locations Report");
					driver.findElement(By.xpath(OR.getProperty("hotel_tax_exempt_locations"))).click();

				}

			} else if (config.getProperty("reportRequested").equalsIgnoreCase("fplp fema")
					|| config.getProperty("reportRequested").equalsIgnoreCase("lodging non use reason")
					|| config.getProperty("reportRequested").equalsIgnoreCase("unavailability of gov lodging")
					|| theTest.equals("FPLP_FEMA")
					|| theTest.equals("LodgingNonUseReason")
					|| theTest.equals("UnavailabilityOfGovernmentLodging")) {

				log.debug("Going into Lodging group");
				//dashbd.click();
				driver.findElement(By.xpath(OR.getProperty("lodging"))).click();

				if (config.getProperty("reportRequested").equalsIgnoreCase("fplp fema")
						|| theTest.equals("FPLP_FEMA")) {

					log.debug("Testing FPLP/FEMA Report");
					driver.findElement(By.xpath(OR.getProperty("fplp_fema"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("lodging non use reason")
						|| theTest.equals("LodgingNonUseReason")) {

					log.debug("Testing Lodging Non Use Reason Justification Report");
					driver.findElement(By.xpath(OR.getProperty("lodging_non_use_reason"))).click();

				} else if (config.getProperty("reportRequested").
								equalsIgnoreCase("unavailability of government lodging")
						|| theTest.equals("UnavailabilityOfGovernmentLodging")) {

					log.debug("Testing Unavailability Of Government Lodging Programs Report");
					driver.findElement(By.xpath(OR.getProperty("unavail_gov_lodging"))).click();

				}

			} else if (config.getProperty("reportRequested").equalsIgnoreCase("debt management summary")
					|| config.getProperty("reportRequested").equalsIgnoreCase("debt management details")
					|| config.getProperty("reportRequested").equalsIgnoreCase("debt summary by month")
					|| config.getProperty("reportRequested").
							equalsIgnoreCase("debt with offsets and collections")
					|| theTest.equals("DebtManagementSummary")
					|| theTest.equals("DebtManagementDetails")
					|| theTest.equals("DebtSummaryByMonth")
					|| theTest.equals("DebtWithOffsetsAndCollections")) {

				log.debug("Going into Debt Management group");
				//dashbd.click();
				driver.findElement(By.xpath(OR.getProperty("debt_management"))).click();

				if (config.getProperty("reportRequested").equalsIgnoreCase("debt management summary")
						|| theTest.equals("DebtManagementSummary")) {

					log.debug("Testing Debt Management Summary Report");
					driver.findElement(By.xpath(OR.getProperty("debt_management_summary"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("debt management details")
						|| theTest.equals("DebtManagementDetails")) {

					log.debug("Testing Debt Management Details Report");
					driver.findElement(By.xpath(OR.getProperty("debt_management_details"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("debt summary by month")
						|| theTest.equals("DebtSummaryByMonth")) {

					log.debug("Testing Debt Summary By Month Report");
					driver.findElement(By.xpath(OR.getProperty("debt_summary_by_month"))).click();

				} else if (config.getProperty("reportRequested").
								equalsIgnoreCase("debt with offsets and collections")
						|| theTest.equals("DebtWithOffsetsAndCollections")) {

					log.debug("Testing Debt With Offsets And Collections Report");
					driver.findElement(By.xpath(OR.getProperty("offsets_and_collections"))).click();

				}

			} else if (config.getProperty("reportRequested").equalsIgnoreCase("totals by system")
					|| config.getProperty("reportRequested").equalsIgnoreCase("transaction details")
					|| config.getProperty("reportRequested").equalsIgnoreCase("posack delinquency")
					|| config.getProperty("reportRequested").equalsIgnoreCase("ps posack delinquency")
					|| theTest.equals("TotalsBySystem")
					|| theTest.equals("TransactionDetails")
					|| theTest.equals("PosackDelinquency")
					|| theTest.equals("PartnerSystemPosackDelinquency")) {

				log.debug("Going into Transaction Monitoring group");
				//dashbd.click();
				driver.findElement(By.xpath(OR.getProperty("transaction_monitoring"))).click();

				if (config.getProperty("reportRequested").equalsIgnoreCase("totals by system")
						|| theTest.equals("TotalsBySystem")) {

					log.debug("Testing What's Out Totals By System Report");
					driver.findElement(By.xpath(OR.getProperty("wo_totals_by_system"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("transaction details")
						|| theTest.equals("TransactionDetails")) {

					log.debug("Testing What's Out Transaction Details Report");
					driver.findElement(By.xpath(OR.getProperty("wo_transaction_details"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("posack delinquency")
						|| theTest.equals("PosackDelinquency")) {

					log.debug("Testing Pos Ack Delinquency Report");
					driver.findElement(By.xpath(OR.getProperty("posack_delinquency"))).click();

				} else if (config.getProperty("reportRequested").equalsIgnoreCase("ps posack delinquency")
						|| theTest.equals("PartnerSystemPosackDelinquency")) {

					log.debug("Testing Partner System Pos Ack Delinquency Report");
					driver.findElement(By.xpath(OR.getProperty("ps_posack_delinquency"))).click();

				}

			}

			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);

			wait = new WebDriverWait(driver, 20);
			log.debug("TestBaseReorts setup() start");

		}

	}

	public void click(String locator) {

		if (locator.endsWith("_css")) {

			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();

		} else if (locator.endsWith("_xpath")) {

			driver.findElement(By.xpath(OR.getProperty(locator))).click();

		} else if (locator.endsWith("_id")) {

			driver.findElement(By.id(OR.getProperty(locator))).click();

		}

		log.debug("Clicking on: " + locator);

	}

	public void type(String locator, String value) {

		if (locator.endsWith("_css")) {

			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);

		} else if (locator.endsWith("_xpath")) {

			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);

		} else if (locator.endsWith("_id")) {

			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);

		}

		log.debug("Typing in: " + locator + ". Entered value as " + value);

	}
	/*
	static WebElement dropdown;

	public void select(String locator, String value) {

		if (locator.endsWith("_css")) {

			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));

		} else if (locator.endsWith("_xpath")) {

			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));

		} else if (locator.endsWith("_id")) {

			dropdown = driver.findElement(By.id(OR.getProperty(locator)));

		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		log.debug("Selecting from dropdown: " + locator + " value as " + value);

	} */

	public boolean isElementPresent(By by) {

		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public String getTheTest() {
		return theTest;
	}

	public void setTheTest(String theTest) {
		this.theTest = theTest;
	}

}