Feature: Case Study for Selenium Track - I Batch

Scenario Outline: Add multiple items to cart
Given Login into App
When User Adds multiple "<item1>", "<item2>" to cart
Then Items must be added to cart

Examples:
 | item1 | item2 |
 | Samsung galaxy s6 | Nokia lumia 1520 |
 
 
Scenario: Delete unwanted Item from Cart # � Using DataTable
Given Login into App
When Items should be available in cart
Then Delete an item from Cart


Scenario: Place Order
Given Login into App
When Items should be available in Cart
  | Items |
  | Nokia lumia 1520 |
Then Place Order
And Purchase Items

