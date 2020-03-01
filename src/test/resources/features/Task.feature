@Task
Feature: Task  HRMS API

Background:
Given user generates token

Scenario: Retrieving all Employee  /getAllEmployees.php API
Given user calls getAllEmployees API to retrieve all employees
When User retrieves response for getAllEmployees API
Then status code is 200 for getAllEmployees API
Then user validates all employees are successfuly retrieving

Scenario: Retrieving all job title /jobTitle.php API
Given user calls jobTitle.php API to retrieve all jobs
When User retrieves response for jobTitle API
Then status code is 200 for jobTitle API
Then user validates all jobs are successfuly retrieving

Scenario: Retrieving allemployee status  /employeeStatus.php API
Given user calls employeeStatus.php  API to retrieve all employee status
When User retrieves response for employeeStatus API
Then status code is 200 for jobTitle API
Then user validates allemployee status are successfuly retrieving



