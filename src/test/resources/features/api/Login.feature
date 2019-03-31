Feature: Login

  @smoke @run
  Scenario: User Login
    When Client calls Login service
    Then response status code is 200
    And response contains expected email