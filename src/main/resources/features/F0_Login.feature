@smoke
Feature: F0_Login | company user could use login successfully with valid username and password

  Scenario: user could login with valid email and password
    Given user enters "valid" "ibtsam.farouk12@gmail.com" and "P@ssw0rd"
    When user presses on the login button
    Then user logs in to the system successfully


  Scenario: user can't login with invalid email and password

    Given user enters "invalid" "test@example.com" and "P@ssw0rd"
    When user presses on the login button
    Then user can not login to the system