@DeleteEmployeeTest@testRegresion
Feature: Delete employee

  @DeleteEmployeeOk@OpenPiM
  Scenario: Successfully Deleted
    When the user clicks the delete button in the employee list
    And the user clicks the confirm delete button
    Then the user should see an alert with the message "Successfully Deleted" indicating that the deletion was successful