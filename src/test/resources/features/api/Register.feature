Feature: Register

  @smoke
  Scenario: Registration by API
    When Client calls Register service
    Then response status code is 201