Feature: User wants to update and delete staff informationn

  Background: 
    Given the base URL is "http://localhost"

  Scenario: User want to upadte the list of staff
    When User updates the staff information using Manager "1"
    Then User should see the updated staff informartion

  Scenario: Delete a specific staff under a manager and count remaining staff
    When User deletes the staff whose id is 1 under manager name "Bell Pepper"
    Then User should verify the updated list of staff count under that manager name "Bell Pepper"
