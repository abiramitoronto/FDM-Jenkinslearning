Feature: Test that the user is able to test the Location page

  Scenario Outline: Test that the user is able to click the location icon and select the dropdown
    Given User launches the application
    #When User is able to view the Location icon
    Then User is able to click on the icon
    And User verify the header in location page "Find a Scotiabank near you"
    Then User clicks on the SearchBy dropdown "<Option>"

    Examples: 
      | Option         |
      | Transit number |
     

  Scenario: Test that the user is able to select Filters
    Given User click on the Filter button
    Then the user is able to view the header "Filter your results"
    And User selects ine of the checkbox
    Then User clicks on the Apply Filter button
    Then User is able to navigate to the home page

    