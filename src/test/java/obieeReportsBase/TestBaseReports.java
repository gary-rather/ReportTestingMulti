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
			user_dir + "\\src\\test\\resources\\obieeReportsExcel\\Test Data Reports-1.xls");
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

			WebElement dashbd = driver.findElement(By.xpath("//*[text() = 'Dashboards']"));
			dashbd.click();
			WebElement dtshome = driver.findElement(By.xpath("//*[text() = 'DTS Reports Home']"));

			driver.findElement(By.xpath("//*[text() = 'DTS Reports Home']")).click();

			log.debug("Inside OBIEE");
            String repReq = config.getProperty("reportRequested");
			if (config.getProperty("reportRequested").equals("status summary")
					|| config.getProperty("reportRequested").equals("routing status")
					|| config.getProperty("reportRequested").equals("document status details")
					|| config.getProperty("reportRequested").equals("traveler status")
					|| config.getProperty("reportRequested").equals("unsubmitted voucher")
					|| config.getProperty("reportRequested").equals("pending airline cancellation")
					|| config.getProperty("reportRequested").equals("RoutingStatus")
					|| theTest.equals("StatusSummary")
					|| theTest.equals("DocumentStatusDetail")
					|| theTest.equals("UnsubmittedVoucher")
					|| theTest.equals("PendingAirlineCancellation")) {

				log.debug("Going into Document & Trip Status section");
				log.debug("Going into Document & Trip Status section");
				driver.findElement(By.xpath("//*[text() = 'Document & Trip Status Dashboard']")).click();

				if (config.getProperty("reportRequested").equals("status summary")
						|| theTest.equals("StatusSummary")) {

					log.debug("Testing Status Summary Report");
					driver.findElement(By.xpath(OR.getProperty("status_summary"))).click();

				} else if (config.getProperty("reportRequested").equals("routing status")) {

					log.debug("Testing Document Status Details Report");
					driver.findElement(By.xpath(OR.getProperty("routing_status"))).click();

				} else if (config.getProperty("reportRequested").equals("document status details")) {

					log.debug("Testing Document Status Details Report");
					driver.findElement(By.xpath(OR.getProperty("document_status_details"))).click();

				} else if (config.getProperty("reportRequested").equals("traveler status")) {

					log.debug("Testing Trip Status Details Report");
					driver.findElement(By.xpath(OR.getProperty("traveler_status"))).click();

				} else if (config.getProperty("reportRequested").equals("unsubmitted voucher")) {

					log.debug("Testing Unsubmitted Voucher Report");
					driver.findElement(By.xpath(OR.getProperty("unsubmitted_voucher"))).click();

				} else if (config.getProperty("reportRequested").equals("pending airline cancellation")) {

					log.debug("Testing Pending Airline Cancellation Report");
					driver.findElement(By.xpath(OR.getProperty("pending_airline_cancellation"))).click();

				}

			} else if (config.getProperty("reportRequested").equals("constructed travel")
					|| config.getProperty("reportRequested").equals("adjustments")
					|| config.getProperty("reportRequested").equals("trip details")) {

				log.debug("Going into Document & Trip Details section");
				driver.findElement(By.xpath(OR.getProperty("document_and_trip_details"))).click();

				if (config.getProperty("reportRequested").equals("constructed travel")) {

					log.debug("Testing Constructed Travel Report");
					driver.findElement(By.xpath(OR.getProperty("constructed_travel"))).click();

				} else if (config.getProperty("reportRequested").equals("adjustments")) {

					log.debug("Testing Adjustments Report");
					driver.findElement(By.xpath(OR.getProperty("adjustments"))).click();

				} else if (config.getProperty("reportRequested").equals("trip details")) {

					log.debug("Testing Trip Details Report");
					driver.findElement(By.xpath(OR.getProperty("trip_details"))).click();

				}

			} else if (config.getProperty("reportRequested").equals("military leave")
					|| config.getProperty("reportRequested").equals("oconus")
					|| config.getProperty("reportRequested").equals("perstempo")
					|| config.getProperty("reportRequested").equals("special duty")
					|| config.getProperty("reportRequested").equals("fsa")
					|| config.getProperty("reportRequested").equals("enlisted bas")) {

				log.debug("Going into Miltary Information section");
				driver.findElement(By.xpath(OR.getProperty("military_reports"))).click();

				if (config.getProperty("reportRequested").equals("military leave")) {

					log.debug("Testing Military Leave Report");
					driver.findElement(By.xpath(OR.getProperty("military_leave"))).click();

				} else if (config.getProperty("reportRequested").equals("oconus")) {

					log.debug("Testing OCONUS Report");
					driver.findElement(By.xpath(OR.getProperty("oconus"))).click();

				} else if (config.getProperty("reportRequested").equals("perstempo")) {

					log.debug("Testing PERSTEMPO Report");
					driver.findElement(By.xpath(OR.getProperty("perstempo"))).click();

				} else if (config.getProperty("reportRequested").equals("special duty")) {

					log.debug("Testing Special Duty Report");
					driver.findElement(By.xpath(OR.getProperty("special_duty"))).click();

				} else if (config.getProperty("reportRequested").equals("fsa")) {

					log.debug("Testing FSA Report");
					driver.findElement(By.xpath(OR.getProperty("fsa"))).click();

				} else if (config.getProperty("reportRequested").equals("enlisted bas")) {

					log.debug("Testing Enslited BAS Report");
					driver.findElement(By.xpath(OR.getProperty("enlisted_bas"))).click();

				}

			} else if (config.getProperty("reportRequested").equals("debt management summary")
					|| config.getProperty("reportRequested").equals("debt management history")
					|| config.getProperty("reportRequested").equals("debt summary by month")) {

				log.debug("Going into Debt Management section");
				driver.findElement(By.xpath(OR.getProperty("debt_management"))).click();

				if (config.getProperty("reportRequested").equals("debt management summary")) {

					log.debug("Testing Debt Management Summary Report");
					driver.findElement(By.xpath(OR.getProperty("debt_management_summary"))).click();

				} else if (config.getProperty("reportRequested").equals("debt management history")) {

					log.debug("Testing Debt Summary By Month Report");
					driver.findElement(By.xpath(OR.getProperty("debt_management_history"))).click();

				} else if (config.getProperty("reportRequested").equals("debt summary by month")) {

					log.debug("Testing Debt Summary By Month Report");
					driver.findElement(By.xpath(OR.getProperty("debt_summary_by_month"))).click();

				}

			} else if (config.getProperty("reportRequested").equals("posack delinquency")
					|| config.getProperty("reportRequested").equals("expense report by category")
					|| config.getProperty("reportRequested").equals("expense report by document name")
					|| config.getProperty("reportRequested").equals("expense without required receipt")) {

				log.debug("Going into Trip Expenses & Transactions section");
				driver.findElement(By.xpath(OR.getProperty("trip_expenses_and_transactions"))).click();

				if (config.getProperty("reportRequested").equals("posack delinquency")) {

					log.debug("Testing Pos Ack Delinquency Report");
					driver.findElement(By.xpath(OR.getProperty("pos_ack_delinquency"))).click();

				} else if (config.getProperty("reportRequested").equals("expense report by category")) {

					log.debug("Testing Expense By Category Report");
					driver.findElement(By.xpath(OR.getProperty("expense_by_category"))).click();

				} else if (config.getProperty("reportRequested").equals("expense report by document name")) {

					log.debug("Testing Expense By Document Name Report");
					driver.findElement(By.xpath(OR.getProperty("expense_by_document_name"))).click();

				} else if (config.getProperty("reportRequested").equals("expense without required receipt")) {

					log.debug("Testing Expense Without Required Receipt Report");
					driver.findElement(By.xpath(OR.getProperty("expense_without_receipt"))).click();

				}

			} else if (config.getProperty("reportRequested").equals("cti traveler details")
					|| config.getProperty("reportRequested").equals("cti user details")
					|| config.getProperty("reportRequested").equals("cti personal details")
					|| config.getProperty("reportRequested").equals("cti account details")
					|| config.getProperty("reportRequested").equals("separation of duty")
					|| config.getProperty("reportRequested").equals("audit trail govcc eft data")
					|| config.getProperty("reportRequested").equals("audit trail user data")
					|| config.getProperty("reportRequested").equals("audit trail person data")
					|| config.getProperty("reportRequested").equals("roa access")
			        || theTest.equals("CompleteTravelerInfo")
					|| theTest.equals("SeparationOfDuty")) {
				log.info("Report TestBaseReports: " + config.getProperty("reportRequested"));
				log.debug("Report TestBaseReports: " + config.getProperty("reportRequested"));
				log.debug("TestBaseReports Going into Traveler & User Information section");
				Thread.sleep(2000);
				WebElement ti = driver.findElement(By.xpath("//span[text()[contains(.,'Traveler & User Information Dashboard')]]"));
				ti.click();
				//driver.findElement(By.xpath(OR.getProperty("traveler_and_user_info"))).click();

				if (config.getProperty("reportRequested").equals("cti traveler details")
						|| config.getProperty("reportRequested").equals("cti user details")
						|| config.getProperty("reportRequested").equals("cti personal details")
						|| config.getProperty("reportRequested").equals("cti account details")
						|| theTest.equals("CompleteTravelerInfo")) {


					log.debug("Accessing Complete Traveler Information Reports");

					if (config.getProperty("reportRequested").equals("cti traveler details")) {

						log.debug("Testing Traveler Details Report");

					} else if (config.getProperty("reportRequested").equals("cti user details")) {

						log.debug("Testing User Details Report");

					} else if (config.getProperty("reportRequested").equals("cti personal details")) {

						log.debug("Testing Personal Details Report");

					} else if (config.getProperty("reportRequested").equals("cti account details")) {

						log.debug("Testing Traveler Details Report");

					}
                    log.debug("Try complete_traveler_info click");
					driver.findElement(By.xpath(OR.getProperty("complete_traveler_info"))).click();

				} else if (config.getProperty("reportRequested").equals("separation of duty") || theTest.equals("SeparationOfDuty")) {

					log.debug("Testing Separation Of Duty Report");
					driver.findElement(By.xpath(OR.getProperty("separation_of_duty"))).click();

				} else if (config.getProperty("reportRequested").equals("audit trail govcc eft data")
						|| config.getProperty("reportRequested").equals("audit trail user data")
						|| config.getProperty("reportRequested").equals("audit trail person data")) {

					log.debug("Going into Audit Trail reports");
					driver.findElement(By.xpath(OR.getProperty("audit_trail_all_reports"))).click();

					if (config.getProperty("reportRequested").equals("audit trail govcc eft data")) {

						log.debug("Testing Audit Trail GOVCC & EFT Data Report");
						driver.findElement(By.xpath(OR.getProperty("audit_trail_govcc_eft_data"))).click();

					} else if (config.getProperty("reportRequested").equals("audit trail user data")) {

						log.debug("Testing Audit Trail User Data Report");
						driver.findElement(By.xpath(OR.getProperty("audit_trail_user_data"))).click();

					} else if (config.getProperty("reportRequested").equals("audit trail person data")) {

						log.debug("Testing Audit Trail Traveler Data Report");
						driver.findElement(By.xpath(OR.getProperty("audit_trail_person_data"))).click();

					}

				} else if (config.getProperty("reportRequested").equals("roa access")) {

					log.debug("Testing ROA Access Report");
					driver.findElement(By.xpath(OR.getProperty("roa_access"))).click();

				}

			}

			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);

			wait = new WebDriverWait(driver, 20);
			log.debug("TestBaseReorts setup() start");
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

	}

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