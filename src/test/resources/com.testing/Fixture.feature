Feature: get fixture
  Reading feature from the endpoint /fixture/{fixtureId}

  Scenario: Get fixture
    Given I use the api endpoint '/fixture/'
    And I use a http Get method
    And the fixture id is '1'
    Then there is a response
