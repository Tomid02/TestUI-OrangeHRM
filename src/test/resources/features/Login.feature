@LoginTest@testRegresion
Feature: Login

  @LoginOk
  Scenario: Successful login with valid credentials
    Given the user is on the login page of OrangeHRM
    When the user enters valid credentials: username "Admin" and password "admin123"
    And the user clicks the login button
    Then the user should be logged in

  @LoginFailed
  Scenario: Failed login with invalid credentials
    Given the user is on the login page of OrangeHRM
    When the user enter invalids credentials: username "invalidUsername" and password "invalidPassword"
    And the user clicks the login button
    Then the user should see the error message "Invalid credentials" indicating that the credentials are invalid

  @LoginFailed
  Scenario Outline: Failed login with null credentials
    Given the user is on the login page of OrangeHRM
    When the user enter invalids credentials: username <username> and password <password>
    And the user clicks the login button
    Then the user should see the error message "Required" indicating that a field is required
    Examples:
      | username | password   |
      | "Admin"  | ""         |
      | ""       | "admin123" |
      | ""       | ""         |
