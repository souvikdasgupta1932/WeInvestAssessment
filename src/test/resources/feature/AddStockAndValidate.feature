@Feature
Feature: Add Stock and Validate 

  Scenario: Add Stock BT Group plc and Validate
    Given I am on the "WeInvest | Simple, Smart, Transparent Investing" page
    Then the user clicks on "Explore Investment Ideas" under "All Weather Strategy"
    And the user verify "ALL WEATHER STRATEGY" page
    Then the user click on "Customize Portfolio" button
    And the user is on the "Portfolio Constituents" page
    And the user click on "Customise" button on Portfolio Page
    And verify "Customise" text changes to "Reset" button
    Then click on "Add Stock" under "US EQUITIES"
    And add "BT Group plc"
    Then click on "Done" button
    And the user is on the "Portfolio Constituents" page
    And verify "BT Group plc" added to "US EQUITIES"