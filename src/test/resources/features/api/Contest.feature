Feature: Contest

  @smoke @regression @type:sunny
  Scenario: Get All Contests
    When Client calls All Contests service
    Then response status code is 200

  @smoke @regression @type:sunny
  Scenario: Add Contest
    When Client calls Add Contest service
    Then response status code is 201
    And All Contests service response has added contest

