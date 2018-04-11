Feature: the message can be retrieved


  @Integration
    @Componenet
  Scenario: client makes call to get
    When the client calls /
    Then the client receives status code of 200
    And the client receives server version hello


  @Integration
  @Component
  Scenario: client makes call to POST /endpoint2
    When the client calls /endpoint2
    Then the client receives status code of 400
    And the client receives server version hello


