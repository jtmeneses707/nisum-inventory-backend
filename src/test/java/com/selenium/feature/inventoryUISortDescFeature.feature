Feature: Inventory UI Testing

#USERCASE1- DESCENDING CHROME
Scenario: Test Data Descending Alphanumeric Sorting Feature of Inventory UI USING CHROME
Given I navigate to the inventory page again with ChromeDriver
When I click on each respective product information categories twice
Then I should be able to see all items in its respective category in descending order