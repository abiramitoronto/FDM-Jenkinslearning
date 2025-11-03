
Feature: As a user, I want to be able to get create, delete, and uptade the comment
Background: 
  Given the base URL is "http://localhost"
 

Scenario: Test that the user is able to create a new comment with foodId
  When User sends a POSTcreate request for "6",7,"good",6 with the following details
  Then User receives a valid create response with status code 201
  

Scenario: Test that the user is able to Delete the comment based on comment id
  When User sends a DELETE request to delete using "6"
  Then User receives a valid  delete response with status code 200
  

Scenario: Test that the user Get comment information using userId and foodId 
  When the User sends 2, 1, "well done" to view the body 
  Then User receives a valid updated response with status code 200
  