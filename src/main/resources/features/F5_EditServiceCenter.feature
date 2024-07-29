@smoke
Feature: F4_EditServiceCenter | company user could edit service center

  Scenario Outline: company user could edit service center with valid data
    Given user enters "valid" "ibtsam.farouk12@gmail.com" and "P@ssw0rd"
    When user presses on the login button
    Then user logs in to the system successfully
    When user is navigated to service center List screen
    And user clicks on the edit action of the first item on the data table to edit it
    And user changes the service center fields with "<ServiceCenterArabicName>", "<ServiceCenterEnglishName>" ,"<ServiceCenterArabicAddress>" ,"<ServiceCenterEnglishAddress>", "<ServiceCenterCode>" and clicks on the Save button
    Then service center edited successfully
    Then service center is displayed on the datatabale after editing with the entered "<ServiceCenterArabicName>","<ServiceCenterEnglishName>","<ServiceCenterCode>"

    Examples:
      |ServiceCenterArabicName||ServiceCenterEnglishName||ServiceCenterArabicAddress||ServiceCenterEnglishAddress||ServiceCenterCode|
      |اتوماتيد الاسم بالعربي بعد التعديل||automated english name after editing||بعد التعديل اتوماتيد العنوان بالعربي||automated english address after editing||code after editing|
