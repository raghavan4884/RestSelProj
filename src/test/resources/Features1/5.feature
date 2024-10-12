Feature: Search Functionality

    
    Scenario Outline: Search Value    
    Given that the user enters the url and searchString and verify the title from "<sheetName>" in "<row>"      
    Then I close the browser         
    Examples:
    |sheetName|row|
    |search|1|
    |search|2|
    
    
    
    
   
   