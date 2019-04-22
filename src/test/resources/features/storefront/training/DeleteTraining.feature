Feature: Delete Training

  Background:
    Given logged in User
    And User has added new training

  @regression @type:sunny @admin
  Scenario: Delete training
    When User deletes the training
    Then training is not displayed on Home Page in the Training section

  @regression @type:sunny @admin
  Scenario: Cancel training creation
    When User cancels deletion of the training
    Then added training is displayed on Home Page in the Training section
