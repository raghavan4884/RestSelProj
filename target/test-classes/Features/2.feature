Feature: Rest Assured API
  
  Scenario: Verify Product API
 # Given that the users are displayed in the "page" 2
 Given that the Products are displayed with "id" 3 

    @smoke
  Scenario: Open Google Search1
    Given that I open the "chrome" browser
    When I enter the "https://www.google.com"

  @regression
  Scenario Outline: Open search url1
    Given that I open the "<browser>" browser
    When I enter the "<url>"
   Examples: 
      | browser | url                    |
      | chrome  | https://www.google.com |
      | chrome  | https://www.yahoo.com  |
  