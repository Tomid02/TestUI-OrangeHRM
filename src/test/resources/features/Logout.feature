@LogoutTests@testRegresion
Feature: Logout

  @LogoutOk@BeforeLogin
  Scenario: Successful logout
    When the user displays the menu and clicks on the "Logout" option
    Then the user should be redirected to the login page