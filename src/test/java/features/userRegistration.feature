Feature: User Registration
  I want to check that user can register in our ecommerce-website
  Scenario: User Registration
    Given the user is in the home page
    When Clicking on register link
    And Entering the user data
    Then the registration page displayed successfully