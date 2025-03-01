@smoke
Feature: F4_CreateServiceCenter | company user could create service center

  Scenario Outline: company user could create service center with valid data
    Given user enters "valid" "ibtsam.farouk12@gmail.com" and "P@ssw0rd"
    When user presses on the login button
    Then user logs in to the system successfully
    Then user is navigated to Create service center screen
    And user fill the create service center fields "<ServiceCenterArabicName>", "<ServiceCenterEnglishName>" ,"<ServiceCenterArabicAddress>" ,"<ServiceCenterEnglishAddress>", "<ServiceCenterCode>" and clicks on the Save button
    Then service center created successfully
    Then service center is displayed on the databale after creation with the entered "<ServiceCenterArabicName>","<ServiceCenterEnglishName>","<ServiceCenterCode>"

    Examples:
      |ServiceCenterArabicName||ServiceCenterEnglishName||ServiceCenterArabicAddress||ServiceCenterEnglishAddress||ServiceCenterCode|
      |اتوماتيد الاسم بالعربي||automated english name||اتوماتيد العنوان بالعربي||automated english address||x1code|
