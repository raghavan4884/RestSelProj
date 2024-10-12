Feature: Open Search

  
  Scenario: Open Google Search
    Given that I open the "chrome" browser
    When I enter the "https://www.google.com"

  
   Scenario Outline: Open search url2
    Given that I open the "<browser>" browser
    When I enter the "<url>"
   Examples: 
      | browser | url                    |
      | chrome  | https://www.google.com |
      | chrome  | https://www.yahoo.com  |
 