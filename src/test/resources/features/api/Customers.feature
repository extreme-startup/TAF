Feature: Customers

  @smoke @regression @type:sunny
  Scenario: Get all Customers
    When Client calls Customers service
    Then response status code is 200
    And response contains expected Customer