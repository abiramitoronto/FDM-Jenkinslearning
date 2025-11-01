Feature: Test that the user is able to signin into the signinpage

 Scenario: Test that the user is able to verify the Title and other windows
    Given User launches the application
    Then User is able to view the Scotiabank logo
    Then User is able to click on the canadapost link
    Then User verify the header "Information on Canada Post service disruption"
    Then User is able to navigate to the home page
    
    
  Scenario Outline: Test that the user is able to signin and view the error message for invalied credentails
    
    Given User click on the SignIn button
    Then the user clicks on the Registerpage signin button
    And User is able to see the error message
    When User enter the invalid "<username>" and "<password>"
    Then the user clicks on the remember checkbox
    Then User is able to navigate to the home page
    
    Examples: 
      | username | password |
      | aaa      |      222 |
      
   
