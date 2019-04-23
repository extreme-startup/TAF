Feature: Contest Questions

  @smoke @regression @type:sunny
  Scenario: Get Contest Questions
    When Client calls get Contest Questions service
    Then response status code is 200