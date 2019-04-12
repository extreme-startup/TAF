Feature: Questions

  @smoke
  Scenario: Get All Questions by API
    When Client calls All Questions service
    Then response status code is 200
    And response contains questions with ids