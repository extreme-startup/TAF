Feature: Logout

  @smoke @regression @type:sunny @admin
  Scenario: Logout
    Given Client has called Login service
    When Client calls Logout service
    Then response status code is 200