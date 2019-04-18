Feature: Register

  @smoke @regression
  Scenario: Registration by API
    When Client calls Register service
    Then response status code is 201
    And Client is able to login