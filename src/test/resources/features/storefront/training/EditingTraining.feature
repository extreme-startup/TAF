Feature: Edit Training

  Background:
    Given logged in User
    And User has added new training

  @type:sunny @admin @WIP
  Scenario: Edit training
    When User edits the training
    Then updated training is displayed on Home Page in the Training section
