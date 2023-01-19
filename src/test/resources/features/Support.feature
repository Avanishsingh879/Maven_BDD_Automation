Feature: Validating the Support Page


@Regression   @Support_1  @TC_001
 Scenario: verify the Vtiger Login Page
    Given I navigate To Application open URl
    When user Enter Username and Password By click on Login button
    Then Login sucessfully
    And User is in VtigercRM home page
    And User has click on Support tab
    And User has click on Contacts tab
    And User verify the Creating Contacts in Support by click on Save button
 

