Feature: Add Session

  Background:
    Given logged in User
    And User has added new training
    And has navigated to training page

  @regression @type:sunny @admin
  Scenario: Add new session
    When User adds new session
    Then session status is created
    Then Start Session button is available
    And link for training session is displayed