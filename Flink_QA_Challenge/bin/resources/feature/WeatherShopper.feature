Feature: Automation test for Flink QA Challenge ( Weather Shopper)

  Scenario: Online shopping based on current temperature on Chrome Browser
    Given User navigates to Home page
    When User checks current temperature
    And User clicks for correct cream based on the temperature
    Then User updates the cart with correct products and makes payment

  Scenario: Online shopping based on current temperature on Firefox Browser
    Given User navigates to Home page
    When User checks current temperature
    And User clicks for correct cream based on the temperature
    Then User updates the cart with correct products and makes payment