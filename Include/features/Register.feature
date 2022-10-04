Feature: Register Feature

  Scenario: Register as funders with valid credential
    Given User open browser
    And 	User navigate to alami login page
    Then 	User should directed to alami login page
    When 	User click daftar disini
    And 	User click Pemberi Dana
    Then 	User should directed to Registrasi Pemberi Dana page
    When 	User fill full name text field
    And 	User fill email text field
    And 	User fill phone number field
    And 	User fill password field
    And 	User choose account type individual
    And 	User fill referral code
    And 	User choose referral source instagram
    And 	User click continue button
    Then 	User should directed to privacy policy & term of use page
    When 	User scroll and read privacy policy & term
    And 	User check privacy policy agreement
    And 	User click privacy policy continue button
    Then 	User should directed to registration success page