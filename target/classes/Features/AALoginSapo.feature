#Author: buithikimanhvtath5@gmail.com
Feature: Login
  I want to login success to test function

  Scenario: Login success
    Given I access Admin page and login sucessfully
    Then I see the Dashboard

    Scenario: Close popup survey by set cookie
    When Close survey