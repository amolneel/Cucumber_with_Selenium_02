@Wip 
Feature: E-commerce project web site health check

  Scenario: User is able to open the browser, navigate to the URL and Search for product
   Given User opened Browser
   And User navigated to the home application url
   When User Search for product "Laptop"
   Then Search Result page is displayed