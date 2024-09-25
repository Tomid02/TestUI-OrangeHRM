@LogoutTests@testRegresion
Feature: Logout

  @LogoutOk
  Scenario: Successful logout
    When The user displays the menu and clicks on the "Logout" option.
    Then the user should be redirected to the login page