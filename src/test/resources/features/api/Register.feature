Feature: Register

  @smoke @regression @type:sunny
  Scenario: Registration by API
    When Client calls Register service
    Then response status code is 201
    And Client is able to login