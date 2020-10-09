@Wip5
Feature: User chenge specification and then click on add to cart  

Scenario: User is click on the Product and check the Product Details then user want to change specification and then after click on add to cart
    Given User opened Browser
    And User navigated to the home application url
    And User Search for product "Redmi Note 9"
    When User click on any product
    Then Product Description is displayed in new tab
    And User chang the specification and click on One year total damage protection
    And User is click on Add to cart 
