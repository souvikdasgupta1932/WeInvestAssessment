@Feature
Feature: Text Validation on window resizing

  Scenario: Validate text resizing after the window has been re-sized
    Given I am on the "WeInvest | Simple, Smart, Transparent Investing" page
    And the user verify text "Portfolio recommendations based on your preferences" is present in the tab
    And the user verify text "other portfolio choices available" is present in the tab
    Then the user resize the window to "375" and "667"
    And the user verify text "Recommended" is present in the tab
    And the user verify text "Others" is present in the tab
    Then the user verify if the count displayed for "Portfolio recommendations based on your preferences" same as "Recommended" before resizing
    Then the user verify if the count displayed for "other portfolio choices available" same as "Others" before resizing