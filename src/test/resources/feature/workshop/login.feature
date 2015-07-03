Feature: Login

  Scenario: Successful Login
    Given I access login page
    And I insert valid credentials
    When I click login button
    Then I check if user was logged in

  Scenario: Login wrong credentials
    Given I access login page
    And I insert invalid credentials
    When I click login button
    Then I expect invalid credentials message

  Scenario: Login no email entered
    Given I access login page
    And I insert only password
    When I click login button
    Then I expect no email message

  Scenario: Login no password entered
    Given I access login page
    And I insert only email
    When I click login button
    Then I expect no password message

  Scenario: Login no credentials inserted entered
    Given I access login page
    When I click login button
    Then I expect no email message

