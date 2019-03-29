Feature: Competition

  Background:
    Given logged in User
    And User has navigated to Landing Page

  @type:sunny @role=admin @WIP
  Scenario: Create competition
    When User adds new competition with Javascript title, Mentoring description and Education category
    Then competition is present on the Landing page in the Training section

  @type:sunny @role=admin @WIP
  Scenario: Discard competition creation
    Given User provides details for competition creation with JavaScript title, Mentoring description and Education category
    When User discards Competition creation
    Then User is on the Landing page

  @type:sunny @role=admin @WIP
  Scenario: Create competition validation
    When User submits Competition creation with empty fields
    Then title, description and category fields are highlighted in red
    And Notification is shown to the user below the field asking for input
