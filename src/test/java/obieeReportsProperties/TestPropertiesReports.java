package obieeReportsProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropertiesReports {

	public static void main(String[] args) throws IOException {

		System.out.println(System.getProperty("user.dir"));

		Properties config = new Properties();
		Properties OR = new Properties();

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\obieeReportsProperties\\config.properties");
		config.load(fis);

		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\obieeReportsProperties\\OR.properties");
		OR.load(fis);
 
		System.out.println("Browser in use: " + config.getProperty("browser"));

		System.out.println("Report requested: " + config.getProperty("reportRequested"));

	}

}