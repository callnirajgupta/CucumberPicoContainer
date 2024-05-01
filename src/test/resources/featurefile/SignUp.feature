@Signup @Regression
Feature: Signup page functionality

  @Signup1
  Scenario Outline: verify mandatory field validation of signup page
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data for field "<First Name>" and "<Middle Name>" and "<Last Name>" and "<Programme Type>" and "<Gender>" and "<Nationality>" and "<HearAboutUs>" and "<Mobile Number>" and "<Email address>" and "<Password>" and "<Confirm Password>" and "<Captcha>"
    And user click start application button
    Then verify application display error message "<Message>"

    Examples:
      | First Name    | Middle Name    | Last Name    | Programme Type                         | Gender | Nationality | HearAboutUs | Mobile Number | Email address | Password | Confirm Password | Captcha | Message                                                                    |
      |               | TestMiddleName | TestLastName | Diploma in Jewellery Design Technology | M      | India       | TV          | +919241521992 | auto          | password | password         | yes     | Please fill in the required field(s): First Name                           |
      | TestFirstName | TestMiddleName |              | Diploma in Jewellery Design Technology | M      | India       | TV          | +919241521992 | auto          | password | password         | yes     | Please fill in the required field(s): Last Name                            |
      | TestFirstName | TestMiddleName | TestLastName |                                        | M      | India       | TV          | +919241521992 | auto          | password | password         | yes     | Please fill in the required field(s): Programme type                       |
      | TestFirstName | TestMiddleName | TestLastName | Diploma in Jewellery Design Technology | F      | India       | TV          | +919241521992 | auto          | password | password         | yes     | Please fill in the required field(s): Gender                               |
      | TestFirstName | TestMiddleName | TestLastName | Diploma in Jewellery Design Technology | M      | India       | TV          | +919241521992 | auto          | password | password         | yes     | Please fill in the required field(s): Nationality                          |
      | TestFirstName | TestMiddleName | TestLastName | Diploma in Jewellery Design Technology | M      | India       | TV          | +919241521992 | auto          | password | password         | yes     | Please fill in the required field(s): TVising, How did you hear about us?  |
      | TestFirstName | TestMiddleName | TestLastName | Diploma in Jewellery Design Technology | M      | India       | TV          |               | auto          | password | password         | yes     | Please fill in the required field(s): Mobile number, Invalid Mobile Number |
      | TestFirstName | TestMiddleName | TestLastName | Diploma in Jewellery Design Technology | M      | India       | TV          | +919241521992 |               | password | password         | yes     | Please fill in the required field(s): Email address                        |
      | TestFirstName | TestMiddleName | TestLastName | Diploma in Jewellery Design Technology | M      | India       | TV          | +919241521992 | auto          |          | password         | yes     | Please fill in the required field(s): Password, Reconfirm your password    |
      | TestFirstName | TestMiddleName | TestLastName | Diploma in Jewellery Design Technology | M      | India       | TV          | +919241521992 | auto          | password |                  | yes     | Please fill in the required field(s): Reconfirm your password              |
      | TestFirstName | TestMiddleName | TestLastName | Diploma in Jewellery Design Technology | M      | India       | TV          | +919241521992 | auto          |          |                  | yes     | Please fill in the required field(s): Password                             |
      | TestFirstName | TestMiddleName | TestLastName | Diploma in Jewellery Design Technology | M      | India       | TV          | +919241521992 | auto          | password | password         |         | Please confirm you are not a robot.                                        |

  #@Signup2
  #Scenario: Validate selection of country
  # Given user navigates to home page
  #When user click on start application button in home page
  #Then user select the all country one by one successfully

  @Signup3
  Scenario Outline: verify user is able to move to personal details page after filling mandatory fields
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data for field "<First Name>" and "<Middle Name>" and "<Last Name>" and "<Programme Type>" and "<Gender>" and "<Nationality>" and "<HearAboutUs>" and "<Mobile Number>" and "<Email address>" and "<Password>" and "<Confirm Password>" and "<Captcha>"
    And user click start application button
    Then user should navigate to personal details page

    Examples:
      | First Name    | Middle Name    | Last Name    | Programme Type                                                   | Gender | Nationality | HearAboutUs | Mobile Number | Email address | Password | Confirm Password | Captcha |
      | testFirstName | testMiddleName | TestLastName | Diploma in Jewellery Design Technology                           | M      | India       | TV          | +919241521992 | auto          | password | password         | yes     |
      | testFirstName | testMiddleName | TestLastName | Certificate in Product Design and Entrepreneurship               | F      | India       | TV          | +919241521992 | auto          | password | password         | yes     |
      | testFirstName | testMiddleName | TestLastName | Bachelor of Arts in Jewellery Design Technology                  | M      | India       | TV          | +919241521992 | auto          | password | password         | yes     |
      | testFirstName | testMiddleName | TestLastName | Diploma in Product Design and Entrepreneurship                   | F      | India       | TV          | +919241521992 | auto          | password | password         | yes     |
      | testFirstName | testMiddleName | TestLastName | Certificate in Jewellery Design Technology                       | M      | India       | TV          | +919241521992 | auto          | password | password         | yes     |
      | testFirstName | testMiddleName | TestLastName | Bachelor of Arts in Product Design and Entrepreneurship          | F      | India       | TV          | +919241521992 | auto          | password | password         | yes     |
      | testFirstName | testMiddleName | TestLastName | Bachelor of Technology in Fashion Design                         | F      | India       | TV          | +919241521992 | auto          | password | password         | yes     |
      | testFirstName | testMiddleName | TestLastName | Certificate in Fashion Design                                    | F      | India       | TV          | +919241521992 | auto          | password | password         | yes     |
      | testFirstName | testMiddleName | TestLastName | Bachelor of Technology in Digital Media and Communication Design | F      | India       | TV          | +919241521992 | auto          | password | password         | yes     |
      | testFirstName | testMiddleName | TestLastName | Diploma in Digital Media and Communication Design                | F      | India       | TV          | +919241521992 | auto          | password | password         | yes     |
      | testFirstName | testMiddleName | TestLastName | Certificate in Digital Media and Communication Design            | F      | India       | TV          | +919241521992 | auto          | password | password         | yes     |
      | testFirstName | testMiddleName | TestLastName | Bachelor of Technology in Fashion Design                         | F      | India       | TV          | +919241521992 | auto          | password | password         | yes     |


  @Signup4
  Scenario Outline: Verify the validation error message for email address.
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data for field "<First Name>" and "<Middle Name>" and "<Last Name>" and "<Programme Type>" and "<Gender>" and "<Nationality>" and "<HearAboutUs>" and "<Mobile Number>" and "<Email address>" and "<Password>" and "<Confirm Password>" and "<Captcha>"
    Then verify application display error message "<Message>"

    Examples:
      | First Name    | Middle Name    | Last Name    | Programme Type                         | Gender | Nationality | HearAboutUs | Mobile Number | Email address        | Password | Confirm Password | Captcha | Message                   |
      | TestFirstName | TestMiddleName | TestLastName | Diploma in Jewellery Design Technology | M      | India       | TV          | +919241521992 | callnirajgupta       | password | password         | yes     | Email format is not valid |
      | TestFirstName | TestMiddleName | TestLastName | Diploma in Jewellery Design Technology | M      | India       | TV          | +919241521992 | callnirajgupta@gmail | password | password         | yes     | Email format is not valid |
      | TestFirstName | TestMiddleName | TestLastName | Diploma in Jewellery Design Technology | M      | India       | TV          | +919241521992 | callnirajgupta.com   | password | password         | yes     | Email format is not valid |

  @Signup5
  Scenario: Verify that user should able to signup only once with same credential
    Given user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data field in signup page
      | FirstName     | LastName     | MiddleName     | ProgrammeType                          | Gender | CountryOfResidence | HearAboutUs | MobileNumber  | EmailAddress | Password | ConfirmPassword | Captcha |
      | TestFirstName | TestLastName | TestMiddleName | Diploma in Jewellery Design Technology | F      | Ghana              | TV          | +919241521992 | auto         | password | password        | yes     |
    Then user should navigate to personal details page
    And user close the browser
    Then user navigates to home page
    When user click on start application button in home page
    And user enter mandatory data field in signup page
      | FirstName     | LastName     | MiddleName     | ProgrammeType                          | Gender | CountryOfResidence | HearAboutUs | MobileNumber  | EmailAddress | Password | ConfirmPassword | Captcha |
      | TestFirstName | TestLastName | TestMiddleName | Diploma in Jewellery Design Technology | F      | Ghana              | TV          | +919241521992 | SignupUser   | password | password        | yes     |
    Then verify that application display error message for already existing applicant with same email ID


