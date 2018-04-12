Feature: the message can be retrieved


  @Integration
  @Component
  Scenario: client makes call to get home page
    When the client calls home page
    Then the client receives status code of 200
    And the client receives server version hello


  @Integration
  Scenario: client makes call soap test
    When the client calls soap test page
    Then the client receives status code of 200
    And the client receives server version hello


