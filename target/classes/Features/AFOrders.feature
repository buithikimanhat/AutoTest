#Author: buithikimanhvtath5@gmail.com
@tag
Feature: Create order and manipulate orders
  I want to create orders for customer 

  @tag1
  Scenario: create orders for customers
    When I choose to create an order function
    And I choose the product to put in the order
    And I choose to add another service to the order
    And I add notes to the order
    And I add payment confirmation
    And I check to add the payment successfully
    Then I do create an order

  Scenario: check your order after it has been created
	  When I check the products in the order
	  And I check the total value of the order
	  And I do the second payment confirmation
	  And I check the payment confirmation of the application
	  And I choose packing and delivery for the order
	  Then I check the order in the system
	  
