@smoke
Feature: F3_SelectDifferentCategories |user can select any category under any side Menu.

  Scenario Outline:	user can select any category under Company Info Menu.
    Given user enters "valid" "ibtsam.farouk12@gmail.com" and "P@ssw0rd"
    When user presses on the login button
    Then user logs in to the system successfully
    Given user clicks on "<category>" on the side menu And user selects "<subcategory>" the user will be navigated to the subcaegory screen"

    Examples:
      |category||subcategory|
      |Company Info||Service Centers|
      |Company Info||Employees|
      |Company Info||Packages|
      |Company Info||Assembly Points|
      |Company Info||not valid category|


