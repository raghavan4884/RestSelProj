Feature: Search Functionality

    
    Scenario Outline: Search Value    
    Given that the user enters the url "<url>"
    When the user enters the searchString "<searchstring>"   
    Then verify that the title "<title>"
    Then I close the browser         
    Examples:
    |url|searchstring|title|
    |https://www.google.com|java|java - Google Search|
    |https://www.google.com|sql|sql - Google Search|
    
    
    
   
   