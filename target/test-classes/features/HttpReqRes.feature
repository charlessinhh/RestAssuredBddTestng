
Feature: Http Get Feature

  Scenario: Verify Status Code
    Given I have a valid API endpoint
    When I send a GET request
    Then I should receive a valid status code