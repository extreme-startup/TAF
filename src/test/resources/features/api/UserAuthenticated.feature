Feature: User Authenticated

  @smoke @regression @type:sunny @admin
  Scenario: Get User Authenticated
    Given Client has called Login service
    When Client calls Get User Authenticated service
    Then user is authenticated