Feature: Login

  @role=admin @WIP
  Scenario: Login
    Given User has navigated to Landing Page
    When User logs in
    Then they are logged in