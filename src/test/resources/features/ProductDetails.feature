@Wip2
Feature: User is clicked on any product for more details

Scenario: User is click on the Product and check the Product Details
    Given User opened Browser
    And User navigated to the home application url
    And User Search for product "Redmi Note 9"
    When User click on any product
    Then Product Description is displayed in new tab
