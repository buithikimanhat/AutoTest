#Author: buithikimanhvtath5@gmail.com
@tag
Feature:  create an auto order script for the livestream post

  @tag1
  Scenario: create an auto order script
    When I enter the livestream sales function
    And I choose to add a new script for the livestream post
    And I choose to add a keyword template for the product
    And I choose a product
    And I add a new product
    And I save the content template just created
    And I check the newly added product
    And I choose the order creation condition for the scenario
    Then I choose to save the script
    
 	Scenario: delete the livestream script and delete the product
    When I delete the script just created
    And I open the site's product list
    And I check the product I just created
    Then I confirm deletion of the product
    


	  
