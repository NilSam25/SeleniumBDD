Feature: Amazon Login Functionality

  Scenario: Validate successful login

    Given User launches Amazon application
    When User clicks on sign in
    And User enters valid email
    And User clicks continue button
    And User enters valid password
    And User clicks login button
    Then User should be logged in successfully

