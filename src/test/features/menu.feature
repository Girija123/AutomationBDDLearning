Feature: Menu

  As a user
  I should navigate through menu options

  @menu
  Scenario Outline: Validate menu options

    Given I'm on Home Page "http://www.next.co.uk"
    When I mouseover menu "<menuOption>"
    When I click submenu "<sumMenuOption>"
    Then I should be on appropriate product page with Header as "<pageHeader>"

    Examples:

      | menuOption | sumMenuOption | pageHeader |
      | MEN        | Jeans         | Jeans      |
      | WOMEN      | Jeans         | Jeans      |
      | BOYS       | Joggers       | Joggers    |