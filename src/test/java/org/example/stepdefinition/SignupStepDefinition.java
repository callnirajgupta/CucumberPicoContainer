package org.example.stepdefinition;



import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.Util.SeleniumUtil;
import org.example.hooks.Hooks;
import org.example.pageobjectmodel.HomePage;
import org.example.pageobjectmodel.PersonalDetailsPage;
import org.example.pageobjectmodel.SignupPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SignupStepDefinition {
	private static final Logger LOGGER = LogManager.getLogger(SignupStepDefinition.class);
	public static List<Map<String,String>> signupDataTable= new ArrayList<Map<String,String>>();

	SeleniumUtil seleniumUtil;
	public SignupStepDefinition(SeleniumUtil seleniumUtil){
		this.seleniumUtil=seleniumUtil;
	}
	 @When("^user click on start application button in home page$")
	public void user_click_on_start_application_button() throws Throwable {
		LOGGER.info("user click on start application button in home page");
		HomePage.clickStartApplication();
		 seleniumUtil.PassTestStep(seleniumUtil.getDriver(), Hooks.getExtentTest(), "Signup loaded successfully");
	}

	@When("^user enter mandatory data for field \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_mandatory_data_for_field_and_and_and_and_and_and_and_and_and_and(String firstName, String middleName, String lastName, String programme, String gender, String country,String hearAboutus, String mobile, String email, String password, String confirmPassword, String captcha) throws Throwable {
		LOGGER.info("user enter mandatory data for field");
		SignupPage.validateSignupTitle();
		SignupPage.signup(firstName, middleName, lastName, programme, gender, country,hearAboutus, mobile, email, password, confirmPassword, captcha);
		//seleniumUtil.PassTestStep(seleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), "Signup mandatory field filled successfully");
	}
	
	@Then("^verify application display error message \"([^\"]*)\"$")
	public void verify_application_display_error_message(String message) throws Throwable {
	  LOGGER.info("verify application display error message");
	  SignupPage.ValidateErrorMessage(message);
	  //seleniumUtil.PassTestStep(seleniumUtil.getDriver(), GlobalStepDefinition.getExtentTest(), "Signup page Error message successfully");
	}
	
	@Then("verify that application display error message for already existing applicant with same email ID")
	public void verify_that_application_display_error_message_for_already_existing_applicant_with_same_email_ID(){
		LOGGER.info("verify application display error message");
		  SignupPage.ValidateErrorMessage("Applicant with "+SignupPage.emailAuto+" already exist");
		seleniumUtil.PassTestStep(seleniumUtil.getDriver(), Hooks.getExtentTest(), "Signup page Error message successfully");
	}
	
	@Then("^user select the all country one by one successfully$")
	public void user_select_the_all_country_and_country_code_one_by_one_successfully() throws Throwable {
	 LOGGER.info("user select the all country and country code one by one successfully");
	

   Response response= RestAssured.given().contentType("application/json")
        .get(seleniumUtil.getConfigProperties().getProperty("API_Country_Ccode_Url"));
   
   JsonPath path= new JsonPath(response.asString());
   System.out.println("list size"+path.getList("").size());
   for(int i=1;i<path.getList("").size();i++){
   SignupPage.selectCountry(path.getString("["+i+"].country"));
	   seleniumUtil.refreshPage();
   }
	 
	}

	@Then("^user should navigate to personal details page$")
	public void user_should_navigate_to_personal_details_page() throws Throwable {
		PersonalDetailsPage.validatePersonalDetailsTitle();
		seleniumUtil.PassTestStep(seleniumUtil.getDriver(), Hooks.getExtentTest(), "Personal details page load successfully");
	  
	}
	
	@When("^user enter mandatory data field in signup page$")
	public void user_enter_mandatory_data_field_in_signup_page(List<Map<String,String>> dataTable) throws Throwable {
		LOGGER.info("user enter mandatory data field in signup page");
		signupDataTable=dataTable;
		SignupPage.validateSignupTitle();
		seleniumUtil.PassTestStep(seleniumUtil.getDriver(), Hooks.getExtentTest(), "Signup page load successfully");
		SignupPage.signup(dataTable.get(0).get("FirstName"), dataTable.get(0).get("MiddleName"), dataTable.get(0).get("LastName"), dataTable.get(0).get("ProgrammeType"), dataTable.get(0).get("Gender"),dataTable.get(0).get("CountryOfResidence"),dataTable.get(0).get("HearAboutUs"),dataTable.get(0).get("MobileNumber"), dataTable.get(0).get("EmailAddress"),dataTable.get(0).get("Password"), dataTable.get(0).get("ConfirmPassword"), dataTable.get(0).get("Captcha"));
		SignupPage.clickStartApplicationButton();
		seleniumUtil.PassTestStep(seleniumUtil.getDriver(), Hooks.getExtentTest(), "Personal details page load successfully");
	  
	}
	
	@When("^user click start application button$")
	public void userClickStartApplicationButton(){
		SignupPage.clickStartApplicationButton();
	}

}
