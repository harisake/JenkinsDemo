Feature: user Reg

@space @regression
Scenario: 102341 - Verify space data
Given I launched broeser with this URL
When I entered valid us pwd and click on login button
Then I should navigate to home page

@hari1
Scenario: verify the API data
    Given I Give the End point URL
    

