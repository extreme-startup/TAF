Feature: Karate example

  Scenario: NBA Career Stats
    Given url 'https://api.nasa.gov'
    And path '/planetary/apod'
    And param api_key = 'CczxgRVC4BKeSEDoRFadfciJ6hF8d8tegw7mGBdK'
    When method get
    Then status 200
    And match response contains {date:'#notnull'}

