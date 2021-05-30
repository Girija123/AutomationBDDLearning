Feature: Search
  As a user
  I should search

  @search @regression @smoke
  Scenario: Validate search retrieve relevant results

    Given I'm on Home Page "http://www.next.co.uk"
    When I enter searchTerm "T-Shirt"
    When I click search Icon
    Then I should get relevant results with name contains "T-Shirt"