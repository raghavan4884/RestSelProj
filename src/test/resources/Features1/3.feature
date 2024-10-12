Feature: Exap
@tag2
  Scenario:verify
    Given that the user enters the "D:\\2.html" 
    Then verify that the follwojg contrls are getting displayed
    |controlname|type|
     |cars|select|  
    Then verify that the follwing values
    |cars|
    |volvo|
    |Saab|
    |Audi|
    
@tag1    
Scenario Outline: verify search functionality
    Given that the user enters the "<url>"
    When the user enters the "<search>" string in the "<searchtextbox>"
    Then close the application
    Examples:
    |url|search|searchtextbox|
    |https://www.google.com|java|q|
		|https://www.yahoo.com|sql|p|
    
 
@tag
  Scenario:verify contorl
    Given that the user enters the "https://www.google.com" 
    Then verify that the follwojg contrls are getting displayed
    |controlname|type|
     |searchTextBox|textarea|
     |searchbutton|input|
      |IamfeelingLucky|input|
    Then verify that the follwing values
    |cars|
    |volvo|
    |Saab|
    |Audi|
    
   
   