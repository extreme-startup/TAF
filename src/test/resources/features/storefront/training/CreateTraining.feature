Feature: Create Training

  Background:
    Given logged in User

  @regression @type:sunny @admin
  Scenario: Create training
    When User adds new training
    Then added training is displayed on Home Page in the Training section

  @regression @type:sunny @admin
  Scenario: Cancel training creation
    Given User clicks on Add to Training
    When User cancels training creation
    Then add new training pop up is not displayed on Home Page

  @type:sunny @admin
  Scenario: Create training validation
    When User clicks on Add to Training
    Then save button is disabled
