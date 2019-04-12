Feature: Question

  Background:
    Given logged in User

  @type:sunny @role=admin
  Scenario: Add question
    Given User has opened 'Training for Automation test' competition
    And has provided static question
    When User saves question
    Then added question is displayed on Training Page

  @type:rainy @role=admin
  Scenario: Add question with empty fields
    Given User has opened 'Training for Automation test' competition
    When User tries add question with empty fileds
    Then validation error messages for add question mandatory fields are displayed
    And add question mandatory fields are highlighted

  @type:rainy @role=admin
  Scenario: Discard question creation
    Given User has opened 'Training for Automation test' competition
    And has provided static question
    When User cancel question creation
    Then added question is missing on Training Page

  @type:sunny @role=admin
  Scenario: Delete question
    Given User has opened 'Training for Automation test' competition
    And has added question
    When User deletes previously added question
    Then deleted question is inactive on Training Page

  @type:rainy @role=admin
  Scenario: Discard question deletion
    Given User has opened 'Training for Automation test' competition
    And has added question
    When User cancels deletion of previously added question
    Then added question is displayed on Training Page

  @type:sunny @role=admin
  Scenario: Editing question
    Given User has opened 'Training for Automation test' competition
    And has added question
    When User editing previously added question
    Then question is saved according to the changes

  @type:sunny @role=admin
  Scenario: Cancel editing question
    Given User has opened 'Training for Automation test' competition
    And has added question
    When User canceling edition previously added question
    Then question is saved according to the changes