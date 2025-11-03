Feature: As a user, I want to be able to get create and update the list of all the foods so that I can see the ID, Name, and Price of the foods

  Background: Given the base URL is "http://localhost"

  Scenario: Test that the user is able to get the list of all the foods so that I can see the ID, Name, and Price of the foods
    When User send the request to the URL ":3000/foods"
    Then User receives a valid response with status code 200
    And the response contains a list of foods with all the information

  Scenario: Test that the user is able to Creating a new food details in db
    When User sends a POST request for "5","Momos",6.99 following item
    Then User will get a valid response with status code 201
    And the new food item will be visible in the db

  Scenario: Update price of a food item
    Given User update the price of the food item using "5" and 8.99
    Then the food item price should be updated
