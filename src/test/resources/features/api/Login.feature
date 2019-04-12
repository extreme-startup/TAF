Feature: Login

  @smoke
  Scenario: User Login by API
    When Client calls Login service
    Then response status code is 200
    And response contains expected email