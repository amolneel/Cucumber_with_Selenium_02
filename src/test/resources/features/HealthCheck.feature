@Wip1
Feature: E-commerce project web site health check

  Scenario: User is able to open the browser, navigate to the URL and Search for product
   Given User opened Browser
   And User navigated to the home application url
   When User Search for product "Redmi Note 9"
   Then Search Result page is displayed
   And product list should appear pertaining to the product search as "Redmi Note 9"