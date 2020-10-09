@Wip4
Feature: User want to buy product with exchange

Scenario: User is click on the Product and check the Product Details and go ahead with exchange product
    Given User opened Browser
    And User navigated to the home application url
    And User Search for product "Redmi Note 9"
    When User click on any product
    Then Product Description is displayed in new tab
    And User clicked on with exchange button
    When User clicked on choose phone to exchange
    And User select brand of mobile and select model 
    Then fixed exchange value will appear
