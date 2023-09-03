Feature: feature to test sauce demo

  Scenario Outline: Validate Sauce demo
    Given browser is open
    And user is on saucedemo page
    When user enters <username> and <password>
    And hits enter
    Then user going to the homepage

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |
      | locked_user   | secret_sauce |
