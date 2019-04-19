Feature: Questions

  @smoke @regression @type:sunny
  Scenario: Get All Questions
    When Client calls All Questions service
    Then response status code is 200
    And response contains questions with ids

  @smoke @regression @type:sunny
  Scenario: Add Question
    When Client call Add Question service
    Then response status code is 201
    And question is added to the list

  @regression @type:sunny
  Scenario: Get Random Question
    When Client call Get Random Question service
    Then response status code is 200
    And response contains question

  @regression @type:sunny
  Scenario: Get Question
    When Client call Get Question service
    Then response status code is 200
    And response contains requested question

  @regression @type:sunny
  Scenario: Update Question
    When Client call Update Question service
    Then response status code is 200
    And question is updated

  @regression @type:sunny
  Scenario: Delete Question
    When Client call Delete Question service
    Then response status code is 200
    And question is deleted