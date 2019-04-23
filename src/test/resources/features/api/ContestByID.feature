Feature: Contest by ID

  @smoke @regression @type:sunny
  Scenario: Get Contest by ID
    When Client calls get Contest by ID service
    Then response status code is 200
    And response contains added contest

  @smoke @regression @type:sunny @issue:20618176
  Scenario: Update Contest by ID
    When Client calls update Contest by ID service
    Then response status code is 200
    And response contains updated contest

  @smoke @regression @type:sunny
  Scenario: Delete Contest by ID
    Given Client has called Add Contest service
    When Client calls delete Contest by ID service
    Then response status code is 200
    And All Contests service response doesn't have added contest
