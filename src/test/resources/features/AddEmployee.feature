Feature: Add Employee
Scenario: Adding Employee
Given I open browser and  navigated to HRMS
When I enter valid username and valid password
And I click on login button
And I click Add Employee Link
And I fill out all form on add employee page
Then I successfully added employee

Scenario: Edit peronal details
Given I  navigated to Employee List
When I find  new employee
And I click on employee name
And I edit employe on personal detail page
And I fill out all form on personal detail page
Then I successfully saved

Scenario: Edit Contact details
Given I  navigated to Contact details
When I edit employe contact details
And I fill out all form on Contact details page
Then I successfully saved