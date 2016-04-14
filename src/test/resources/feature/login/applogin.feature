@screen
Feature: Customer I can login to web site

    
  Scenario: Successfully login
    Given I open url "file:///D:/Selenium%20training/Testy/src/test/functional/app-demo/login.html"
    When I login with credentials "eu@fast.com"/"eu.passLR"
    When I click on link with text "Logout"