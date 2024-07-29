@smoke
Feature: F4_DeleteServiceCenter | company user could delete service center after creation

  Scenario Outline: company user could check service center details screen after creation
  company user could delete service center after creation

    Given user enters "valid" "ibtsam.farouk12@gmail.com" and "P@ssw0rd"
    When user presses on the login button
    Then user logs in to the system successfully
    Then user is navigated to Create service center screen
    And user fill the create service center fields "<ServiceCenterArabicName>", "<ServiceCenterEnglishName>" ,"<ServiceCenterArabicAddress>" ,"<ServiceCenterEnglishAddress>", "<ServiceCenterCode>" and clicks on the Save button
    Then service center created successfully
    Then user clicks on the Delete action on the datatable
    And User clicks on the delete button and successful delete dialog message is displayed
    Then verify that service center item is not displayed on the datatable

    Examples:
      |ServiceCenterArabicName||ServiceCenterEnglishName||ServiceCenterArabicAddress||ServiceCenterEnglishAddress||ServiceCenterCode|
      |اتوماتيد الاسم بالعربي||automated english name||اتوماتيد العنوان بالعربي||automated english address||x2code|
