@RSS-01
  Feature: Registration feature

    Scenario: To test new registration

      Given As a new user i open the RSS component url in browser
      When application is loaded fully
      Then I need to see the mandatory attributes
      And I click on Registerlink
      Then I should see all the mandatory attributes of registration page



