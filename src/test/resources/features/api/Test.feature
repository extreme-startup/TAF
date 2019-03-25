Feature: Test

  @run
  Scenario: Nasa request test
    Given set query parameter
      | api_key | CczxgRVC4BKeSEDoRFadfciJ6hF8d8tegw7mGBdK |
    When Client makes GET request for /planetary/apod path
    Then response status code is 200
    And response body contains the following
      | media_type      | image |
      | service_version | v1    |


