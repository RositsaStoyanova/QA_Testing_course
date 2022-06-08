Feature: Login page
  In order to use the website
  As a client
  I want to log in


  Scenario: Login successfully
    Given a user is on the login page
    When the client enters <credentials> and press Login button
    Then the client is successfully redirected to shop page

  Scenario Outline: Login with invalid credentials
    Given a user is on the login page
    When the client enters invalid <credentials> credentials and press Login button
    Then the alert "<message>" message should displayed on the screen

    Examples:
      | credentials                 | message                                                                   |
      | standard_user, fakePassword | Epic sadface: Username and password do not match any user in this service |
      | fakeUsername, secret_sauce  | Epic sadface: Username and password do not match any user in this service |
