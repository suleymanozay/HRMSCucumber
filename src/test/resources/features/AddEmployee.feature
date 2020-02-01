@sprint2 @addemployee
Feature: Add Employee

  Background: 
    Given I am logged into HRMS
    And I navigated to Add Employe Page

  #@smoke
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

  @smoke
  Scenario: Add and Modify Employe Details
    When I enter employee details
      | FirstName | MiddleName | LastName |
      | Johann    | Sebastian  | Bach     |
    And I click Save
    And i click on Edit
    Then I am able to modify Employe Details
      | DriverLicense | ExpirationDate | SSN         | SIN      | Gender | MaritialStatus | Nationality | DOB        |
      | N78787766     | 2021-12-18     | 123-45-7896 | 78877655 | Male   | Other          | Colombian   | 1980-10-10 |
      | N78786766     | 2021-12-18     | 123-45-7696 | 78878655 | Female | Married        | Gambian     | 1980-10-10 |
