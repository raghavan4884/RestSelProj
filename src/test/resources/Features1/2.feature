Feature: Rest Assured API
  
   
 
  Scenario Outline: Open search url1
    Given that I open the "<browser>" browser
    When I enter the "<url>"
   Examples: 
      | browser | url                    |
      | chrome  | https://www.google.com |
      | chrome  | https://www.yahoo.com  |
  