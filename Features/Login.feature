Feature: Login

  Scenario: Successful Login with Valid Credential
    Given  User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Logout link
    Then Page Title should be "Your store. Login"
    And Close the browser

  Scenario Outline: Login Data Driven
    Given  User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Logout link
    Then Page Title should be "Your store. Login"
    And Close the browser

    Examples:
      | email               | password |
      | admin@123.com       | 12345    |
      | admin@yourstore.com | admin    |