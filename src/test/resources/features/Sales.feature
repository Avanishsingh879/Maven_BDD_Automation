Feature: Validating Sales page
   

@Regression   @Sales_2  @TC_001
 Scenario: verify the Vtiger Login Page
    Given I navigate to application open URl
    When User Enter Username and Password By click on Login button
    Then Login sucessfullY
    And User is in VtigerCRM home page
    And User has click on Sales tab
    And User has click on Leads tab
    And User verify the Creating Leads in Sales by click on Save button