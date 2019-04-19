Feature: Question

  Background:
    Given logged in User

  @regression @type:sunny @admin
  Scenario: Add question
    Given User has opened 'Training for Automation test' training
    And has provided static question
    When User saves question
    Then added question is displayed on Training Page

  @regression @type:rainy @admin
  Scenario: Add question with empty fields
    Given User has opened 'Training for Automation test' training
    When User tries add question with empty fileds
    Then validation error messages for add question mandatory fields are displayed
    And add question mandatory fields are highlighted

  @regression @type:rainy @admin
  Scenario: Discard question creation
    Given User has opened 'Training for Automation test' training
    And has provided static question
    When User cancel question creation
    Then question is not present on Training Page

  @regression @type:sunny @admin
  Scenario: Delete question
    Given User has opened 'Training for Automation test' training
    And has added question
    When User deletes previously added question
    Then question is not present on Training Page

  @regression @type:rainy @admin
  Scenario: Discard question deletion
    Given User has opened 'Training for Automation test' training
    And has added question
    When User cancels deletion of previously added question
    Then added question is displayed on Training Page

  @regression @type:sunny @admin
  Scenario: Editing question
    Given User has opened 'Training for Automation test' training
    And has added question
    When User editing previously added question
    Then question is saved according to the changes

  @regression @type:sunny @admin
  Scenario: Cancel editing question
    Given User has opened 'Training for Automation test' training
    And has added question
    When User canceling edition previously added question
    Then question is saved according to the changes