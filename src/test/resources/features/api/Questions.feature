Feature: Questions

  @smoke @regression
  Scenario: Get All Questions by API
    When Client calls All Questions service
    Then response status code is 200
    And response contains questions with ids

  @smoke @regression
  Scenario: Add Question
    When Client call Add Question service
    Then response status code is 201
    And response contains questions with ids