package org.example.stepdefinition;

import io.cucumber.java.en.Given;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.Util.SeleniumUtil;
import org.example.hooks.Hooks;

public class CommonStep {

    private static final Logger LOGGER = LogManager.getLogger(PersonalDetailsStepDefinition.class);
    SeleniumUtil seleniumUtil;
    public CommonStep(SeleniumUtil seleniumUtil){
        this.seleniumUtil=seleniumUtil;
    }
    @Given("^user navigates to home page$")
    public void user_navigates_to_Home_page() throws Throwable {
        LOGGER.info("user navigates to login page");
        if (Boolean.FALSE.equals(SeleniumUtil.driverStatus)) {
            SeleniumUtil.getDriver();
            SeleniumUtil.maximizeBrowser();
        }
        seleniumUtil.launchApplication(seleniumUtil.getConfigProperties().getProperty("HomePageUrl"));
        seleniumUtil.ImplicitWait();
        seleniumUtil.PassTestStep(seleniumUtil.getDriver(), Hooks.getExtentTest(), "Home Page loaded successfully");

    }

    @Given("^user close the browser$")
    public void user_close_the_browser() throws Throwable {
        LOGGER.info("user close the browser");
        if (SeleniumUtil.getDriver() != null) {

            SeleniumUtil.closeBrowser();
            SeleniumUtil.setDriver(null);
            SeleniumUtil.driverStatus=false;
        }

    }
}
