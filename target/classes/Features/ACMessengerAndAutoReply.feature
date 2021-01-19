#Author: buithikimanhvtath5@gmail.com
@tag
Feature: Messenger and Auto reply messenger
  I want to send a mesage for customer 
  If a Customer send a message Server send a auto message 

  @tag1
  Scenario: receive messages from customers
    When I use my personal account on facebook
    And I send a message to the page
    And I open the message I just received in the software 
    Then I check my messages
  Scenario: send messages to customers
	  Given I am on that conversation
	  When I enter the message content for the client
	  And I choose to send a message
	  Then I check my messages on facebook
  Scenario: create automatic response scripts for messages
	  Given I enter the tool automatically function
	  When I create an auto-response script for the message
	  And I enter the script name
	  And I choose the response time
	  And I choose the next step
	  And I enter the text to respond to the message
	  And I choose a response time
	  And I saved and scripted the script
		Then I check my script 
	Scenario: test applying automatic response scripts to messages
	  Given I use my personal account on facebook again
	  When I send a new message to the page
	  And I open new coversation 
	  And I check the messages I receive
	  Then I check the feedback messages for customers
	 
	  


