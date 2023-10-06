Feature: Validating Inventory page
   

@Regression   @Inventory_1  @TC_001
  Scenario: verify the Vtiger Login Page
    Given I navigate to application open UrL
    When user Enter Username and Password by click on login Button
    Then login sucessfully
    And user is in VtigerCRM Home page
    And User has click on Inventory tab
    
@Regression   @Inventory2  @TC_002
 Scenario: verify the Vtiger Login Page
    Given I navigate to application open UrL
    When user Enter Username and Password by click on login Button
    Then login sucessfully
    And user is in VtigerCRM Home page
    And User has click on Inventory tab
    And User verify the Creating Products in Marketing by click on Save button
    