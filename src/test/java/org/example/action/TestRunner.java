
package org.example.action;

import com.relevantcodes.extentreports.ExtentReports;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/featurefile/",tags = "@Personal2", plugin = { "pretty",
				"json:target/cucumber.json", "junit:target/cucumber.xml","html:target/cucumber.html"
		}, glue = { "org.example" })

public class TestRunner {
	public static ExtentReports report;
	public static String reportName;

	@BeforeClass
	public static void beforeClass() {
		reportName = System.getProperty("user.dir") + "/target/test-report.html";
		report = new ExtentReports(reportName);

		//File ScreenShotDir = new File(System.getProperty("user.dir") + "/src/test/resources/ExtendReportSnap/");
		File ScreenShotDir = new File(System.getProperty("user.dir") + "/target/ExtendReportSnap/");
		if (!ScreenShotDir.exists()){
			ScreenShotDir.mkdirs();
		}
		/*for (File file : ScreenShotDir.listFiles()) {
			file.delete();
		}*/

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		System.setProperty("currentdate", dateFormat.format(new Date()));
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

	}

	@AfterClass
	public static void afterClass() {
		report.flush();
		/*
		 * if (seleniumUtil.getDriver() != null) {
		 * 
		 * seleniumUtil.closeBrowser();
		 * seleniumUtil.setDriver(null);
		 * seleniumUtil.driverStatus=false;
		 * }
		 */

	}

	public static ExtentReports getExtentReport() {
		return report;
	}

}
