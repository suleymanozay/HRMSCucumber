#Author:syntax team
@sprint2 @addemployee
Feature: Add Employee

  Background: 
    Given I am logged into HRMS
    And I navigated to Add Employe Page

  @smoke
  Scenario: Add new Employee
    When I add "John", "Jr"  and "Test"
    And I click Save
    Then I verify Employee has been succesfully added

  @regression
  Scenario Outline: Add new Employee
    When I add "<FirstName>", "<MiddleName>"  and "<LastName>"
    And I click Save
    Then I verify Employee with "<FirstName>", "<MiddleName>" and "<LastName>" is displayed
  

    Examples: 
      | FirstName | MiddleName | LastName |
      | Salamon   | Jr         | Salamon  |
      | Salamo    | Jr         | Salamo   |
      | Salam     | Jr         | Salam    |
      | Sala      | Jr         | Sala     |

  Scenario: Add  Employee without employee id
    WhenWhen I add "<FirstName>", "<MiddleName>"  and "<LastName>"
    And I delete employee id
    And I click Save
    Then I see verify Employee witout id is being added
   

  Scenario: Add  Employee negative scenario
    When I click Save
    Then I see required error message next to the first and last name


  Scenario: Add  Employee and Login Credential
    When I add firstName, middleName and last name
    And I click on create login checkbox
    And I enter username, password and confirm password
    When I click save
    Then I verify Employee has been succesfully added
 
