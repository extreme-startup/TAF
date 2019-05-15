Feature: Start Session

  Background:
    Given logged in User
    And User has added new training
    And has navigated to training page
    And has added new session

  @regression @type:sunny @admin
  Scenario: Start session
    When User starts session
    Then session status is in progress
    And Pause Session button is available
    And Stop Session button is available

  @regression @type:sunny @admin
  Scenario: Pause session
    Given User has started session
    When User pauses session
    Then session status is paused
    And Start Session button is available
    And Stop Session button is available

  @regression @type:sunny @admin
  Scenario: Resume session
    Given User has started session
    And User has paused session
    When User resumes session
    Then session status is in progress
    And Pause Session button is available
    And Stop Session button is available

  @regression @type:sunny @admin @t
  Scenario: Stop session
    Given User has started session
    When User stops session
    Then session status is completed