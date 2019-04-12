Feature: Login

  @smoke @regression @type:sunny
  Scenario: Login
    Given User has navigated to Home Page
    When User logs in
    Then they are logged in

  @regression @type:validation
  Scenario Outline: Login validation
    Given User has navigated to Home Page
    When User provides invalid email: <email>
    Then login error message is displayed
    And login field is highlighted

    Examples:
      | email              |
      | @invalid.email.com |
      | invalid.email.com@ |
      | invalid.email.com  |
      | .invalid@email.com |
      | invalid@email.com. |
      | invalid@email      |
      | invalid@email..com |