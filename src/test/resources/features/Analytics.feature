Feature: Validating Analytics page
   

@Regression   @Analytics_1  @TC_001
  Scenario: verify the Analytics Page
    Given I navigate to APPlication open UrL
    When user Enter UsernamE and PassworD by clicK on login Button
    Then login sucessfully
    And user is in VtigerCRM HOme page
    And User has click on Analytics tab