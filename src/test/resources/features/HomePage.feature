Feature: Home Page

  @WIP
  Scenario: 7.2.1 Verify Home Page Button - Guest
    Given Guest is on Store Finder Page
    When Guest navigates to Home Page via Home Page Button
    Then browser is redirected to Home Page

  @WIP
  Scenario: How to work with Fragments
    Given Guest is on Store Finder Page
    When fill some fragment: London
    Then browser is redirected to Home Page