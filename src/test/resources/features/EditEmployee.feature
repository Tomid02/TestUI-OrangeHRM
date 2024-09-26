Feature: Edit Employee

  @beforeOpenPIM@EditEmployeeOk
  Scenario: Successful edit employee
    When the user clicks on an employee's card
    And the user enters the first name: "firstName", middle name: "middleName" and last name: "lastName"
    And the user selects the nationality "Argentinean" of the employee
    And the user selects the gender of the employee
    And the user clicks Save button
    Then the user should see an alert with the message "Successfully Updated" indicating that the update was successful

