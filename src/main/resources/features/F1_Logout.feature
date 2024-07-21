Feature: F1_Logout | company user could  logout successfully

  Scenario: company user could  logout successfully
    Given user enters "valid" "ibtsam.farouk12@gmail.com" and "P@ssw0rd"
    When user presses on the login button
    Then user logs in to the system successfully
    And user clicks on the logout button.
    Then the user is be navigated to the Login screen.