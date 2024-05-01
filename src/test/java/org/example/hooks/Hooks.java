package org.example.hooks;


import com.relevantcodes.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.Util.SeleniumUtil;
import org.example.action.TestRunner;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Hooks {
	
	private static final Logger LOGGER = LogManager.getLogger(Hooks.class);
	public static Scenario scenario;
	private static String scenarioName;
	public static ExtentTest extenttest;
	public WebDriver driver;
	SeleniumUtil seleniumUtil;
	public Hooks(SeleniumUtil seleniumUtil){
		this.seleniumUtil=seleniumUtil;
	}

	@Before()
	public void Setup(Scenario scenario) {
		LOGGER.info("Inside Setup method");
		extenttest = TestRunner.getExtentReport().startTest(scenario.getName());
		Hooks.scenario=scenario;
		scenarioName=scenario.getName();
		seleniumUtil.getDriver();

	}

	
	
	@After()
	public void TearDown(Scenario scenario) {
		LOGGER.info("Inside Teardown method");

		if (scenario.isFailed()) {
			LOGGER.debug("################### i am inside screen shot after fail ####################");
			final byte[] screenshot = ((TakesScreenshot) seleniumUtil.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png","");
			seleniumUtil.failTestStep(seleniumUtil.getDriver(), Hooks.getExtentTest(), "The Step is failed");

		}
		if (seleniumUtil.getDriver() != null) {

			seleniumUtil.closeBrowser();
			seleniumUtil.setDriver(null);

		}

		
	}
	
	public static ExtentTest getExtentTest() {
		return extenttest;
	}
	
	 public static String getScenarioName() {
			return scenarioName;
		}
}
