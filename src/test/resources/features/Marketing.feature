Feature: Validating Marketing page
   

@Regression   @Marketing  @TC_001
  Scenario: verify the Vtiger Login Page
    Given I navigate to application open URL
    When User Enter Username and Password by click on login Button
    Then Login sucessfully
    And User is in VtigerCRM Home page
    And User has click on Marketing tab
    