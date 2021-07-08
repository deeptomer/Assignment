@Registration
Feature: User Registration Scenario
  Template for User Registration

  Scenario: New User Registration
    Given User Launch Site "Jabatalks"
    And Validate Language Selector
    | English |
    | Dutch |
    When User enter Registration Details
    | Deep |
    | Deep_org |
    | deep@test.com | 
    And Select Terms and Conditions
    And Click Get Started button
    Then Registration is Successfull
    Then User close Browser
    
