Feature: Users

  @smoke @regression @type:sunny
  Scenario: Get All Users
    When Client calls All Users service
    Then response status code is 200
    And response contains list of Users

  @smoke @regression @type:sunny
  Scenario: Get User
    When Client calls User service
    Then response status code is 200
    And response contains expected user
