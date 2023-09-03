Feature: Shopping on the SauceDemo website

  Scenario: Successful login
  	Given the browser is open
    When the user logs in with valid credentials
    Then the user should be on the products page
    And the user selects the price (Low to High) option
    And the user adds the product to the cart
    Then the user is on the cart page
    And the user proceeds to checkout
