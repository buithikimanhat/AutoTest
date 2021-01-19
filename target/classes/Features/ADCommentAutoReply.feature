#Author: buithikimanhvtath5@gmail.com
@tag
Feature: Comment and Auto reply comment
  I want to send a comment for customer 
  If a Customer send a comment Server send a auto comment 

  @tag1
  Scenario: create a post on facebook
    When I open the homepage of the facebook page
    And I create a post for the facebook page
    And I comment on that article on my personal facebook account
    Then I check the comment at the software interface

  Scenario: reply comment to customers
	  Given I open that conversation
	  When I enter the comment content for the client
	  And I choose to send a comment
	  Then I check my comment on facebook 
	  
  Scenario: create automatic response scripts for comments
	  Given I enter the tool automatically function for comment 
	  When I create an auto-response script for the comment 
	  And I enter the script name for the response scenario
	  And I choose the response time for the response scenario
	  And I choose the next step for the response scenario
	  And I enter the text to respond to the comment
	  And I choose a response time for the response scenario
	  And I saved and scripted the script for the response scenario
		Then I check my script on the list
		
	Scenario: test applying automatic response scripts to comment
	  Given I use my personal account on facebook to comment the post
	  When I send a new comment 
	  And I open new coversation comment
	  And I check the comment I receive
	  Then I check the feedback comment for customers