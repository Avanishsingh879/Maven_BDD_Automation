Feature: Validating Marketing page
   

@Regression   @Marketing_1  @TC_001
  Scenario: verify the Vtiger Login Page
    Given I navigate to application open URL
    When User Enter Username and Password by click on login Button
    Then Login sucessfully
    And User is in VtigerCRM Home page
    And User has click on Marketing tab
    
@Regression   @Marketing_2  @TC_002
 Scenario: verify the Vtiger Login Page
    Given I navigate to application open URL
    When User Enter Username and Password by click on login Button
    Then Login sucessfully
    And User is in VtigerCRM Home page
    And User has click on Marketing tab
    And User verify the Creating New Campaign in Marketing by click on Save button
 
    