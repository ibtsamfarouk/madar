@smoke
Feature: F4_CreateServiceCenter | company user could create service center

  Scenario: company user could create service center with valid data
    Given user enters "valid" "ibtsam.farouk12@gmail.com" and "P@ssw0rd"
    When user presses on the login button
    Then user logs in to the system successfully
    Then user is navigated to Create service center screen
    And user fill the create service center fields and click on the Save button
    Then service center created successfully
    Then service center is displayed on the databale after creation
