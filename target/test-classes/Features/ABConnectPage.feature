#Author: buithikimanhvtath5@gmail.com

@tag
Feature: Connect Pages success
  I want to connect pages success to test function

  @tag1
  Scenario: Login Facebook
    When I close guideline login acount facebook
    And enter a valid username and password facebook
    And enter login 
    Then I see successful login
  Scenario: Connect a page
	  Given I login acount facebook sucessfully
	  When I connect a page
	  And I close popups noti
	  Then I see list conversation
	  


