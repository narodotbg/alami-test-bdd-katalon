Feature: Register Feature

  Scenario: Register as funders with valid credential
    Given 	User navigate to alami login page
    When 		User input valid email
    And 		User input valid password
    And 		User click login button
    Then 		User should directed to dashboard page