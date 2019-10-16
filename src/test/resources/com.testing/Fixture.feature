Feature: get fixture
  Reading feature from the endpoint /fixture/{fixtureId}

  Scenario: Get fixture
    Given I use the api endpoint '/fixture/'
    And I use a http Get method
    And the fixture id is '1'
    Then there is a response

  Scenario: Get all fixtures
    Given I use the api endpoint '/fixtures'
    And I use a http Get method
    Then 3 fixtures are returned in the response

  Scenario: Eah fixture has a fixture id
    Given I use the api endpoint '/fixtures'
    And I use a http Get method
    Then 3 fixtures are returned in the response
    And each fixture has a fixture id