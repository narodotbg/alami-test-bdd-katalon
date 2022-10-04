Feature: Email Verification

  Scenario: User verify email after register
    Given User already login to mail account
    And 	Verification link is sent to user mail
    When 	User click email activation button
    Then 	User should directed to email activation success page
