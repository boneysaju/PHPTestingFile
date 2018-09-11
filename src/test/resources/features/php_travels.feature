Feature: PHP Search
  As a PHP user
  I want to be able to complete the exercises
  So I can learn more about Java


  Background:
    Given I'm on the phptravel.net main page

  Scenario: Exercise One
    When I click on Sign up
    And I fill out the form
    Then I submit the form

  Scenario: Exercise Two
    When I click on Log in
    And I enter my log in details
    Then I will be on my account page

  Scenario: Exercise Three
    When I select book now on a featured tour
    And I select the number of people
    And I fill in my personal details
    Then I will be on the invoice page

  Scenario: Exercise Four
    When I click on the flights tab
    And Search for a flight
    And I book a flight
    And I fill in the booking form with valid details
    Then I will be on the invoice page

  @smoke
  Scenario: Exercise five
    When I click on the Hotels Tab
    And I fill out the search criteria
    And I fill out valid details
    Then I will be on the invoice page


  Scenario: Exercise six
    When I click on Log in
    And I enter the wrong details
    Then I will be shown an error message







