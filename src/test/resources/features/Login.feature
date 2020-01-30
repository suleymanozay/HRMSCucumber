@sprint1,login
Feature: Login
Background: 
 Given I open browser and  navigated to HRMS
  @smoke
  Scenario: Valid Login
    Login using valid credentials

   
    When I enter valid username and valid password
    And I click on login button
    Then I successfully logged in
    

  @regression
  Scenario: Invalid Login
   
    When I enter valid  username and invalid password
    And I click on login button
    Then I see error message
   
