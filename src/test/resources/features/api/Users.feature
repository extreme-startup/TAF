Feature: Users

  @smoke @regression
  Scenario: Get All Users
    When Client calls All Users service
    Then response status code is 200
    And response contains list of Users