@AddEmployeeTest@testRegresion
Feature: Add Employee

  @AddEmployeeOk@OpenPiM
  Scenario: Add Employee Successfully
    When the user clicks Add Employee button
    And the user enters the first name: "Test", middle name: "Automation" and last name: "ICARO", of the new employee
    And The user clicks on the save new employee button
    Then the user should see an alert with the message "Successfully Saved" indicating that it was saved successfully