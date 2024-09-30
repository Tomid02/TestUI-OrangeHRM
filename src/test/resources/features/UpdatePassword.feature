@UpdatePassword@testRegresion
Feature: UpdatePassword
  
  @UpdatePwdOk@BeforeLogin
  Scenario: Update password successfully
    When the user displays the menu and clicks on the Update Password option
    And the user enters the current password: "admin123", new password: "PasswordTest24" and confirm password: "PasswordTest24"
    And the user clicks save button for the update password
    Then the user should see an alert with the message "Successfully Saved" indicating that the password was saved successfully