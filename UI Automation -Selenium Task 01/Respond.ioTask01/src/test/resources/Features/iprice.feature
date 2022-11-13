Feature: Test the iprice functionality

  Scenario Outline: Test the functionalty of iprice
    Given browser is open
    And user is on iprice home page and validate it
    When user navigate to laptops page and validate it
    And user select the brand value to be Dell
    Then validate result based on selected filter
    
    # Scenario Users are able to sort results Properly
    Then user navigate to dresses page
    And user click on Price sorting until the indicator indicates
    Then Validate that the results are sorted in descending order of Price
    
    # Scenario Users are able to search for an item
    Then user navigate to home page
    And user Search for <item>
    And user click on Search button
    Then Validate that the result matches the search criteria

    Examples: 
      | item      |
      | iphone 14 |
