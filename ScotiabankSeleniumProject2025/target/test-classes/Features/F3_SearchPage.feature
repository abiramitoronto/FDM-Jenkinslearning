Feature: Test that the user is able to signin into the signinpage

  Scenario Outline: Test that the user is able to verify the Title and other windows
    Given User launches the application
    Then User search for the "<field>" in the search bar
    Then User is able to click on the search button
    And User click on the exchang currency link

    Examples: 
      | field         |
      | Exchange rate |

  Scenario Outline: Test that the user is able to signin and view the error message for invalied credentails
    Given User Verify the foreign exchange rate header
    Then the User is able to view the table
    #And the User is able to get the rates for country "<Country>"
    Then User is able to navigate to the home page

    Examples: 
      | Country |
      | Japan   |
