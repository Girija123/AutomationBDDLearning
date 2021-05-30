Feature: Language

  As a user
  I should choose language and be in appropriate country domain

  Background: reach language
    Given I'm on Home Page "http://www.next.co.uk"
    When I click on language Icon

  @language @regression
  Scenario: Validate language pop up has appropriate elements
    Then I should see "Location" dropdown and language button

  @language @smoke @regression
  Scenario Outline: Validate domain re-direction to appropriate country
    When I choose location as "<location>"
    And I choose language as "<language>"
    And I click shop now button
    Then I should be re-directed to appropriate domain as "<domain>"

    Examples:
      | location | language | domain                 |
      | UA       | ru       | https://www.next.ua/ru |
      | TW       | zh       | https://www.next.tw/zh |

