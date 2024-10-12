Feature: Open Search

  @smoke
  Scenario: Open Google Search
    Given that I open the "chrome" browser
    When I enter the "https://www.google.com"

  @regression
  Scenario Outline: Open search url
    Given that I open the "<browser>" browser
    When I enter the "<url>"

    Examples: 
      | browser | url                    |
      | chrome  | https://www.google.com |
      | chrome  | https://www.yahoo.com  |

 
  Scenario: Open Ggl Search
    Given that I open the "chrome" browser
    When I enter
      | url                    |
      | https://www.google.com |

  @tag
  Scenario: verify time
    Given that I get the time
    Then i display the time

 @VerifyExcel
 Scenario Outline:Verify Search Functionlaity in Google
Given that the user enter the url "https://www.google.com"
When the user enters the value in "<Sheet>" row "<row>" textbox

Examples:
| Sheet | row |
| search | 1 |
    
@VerifyExcelDataTable
   Scenario: Verify Ggl Search
Given that the user enter the url "https://www.google.com"
    When I enter the values
      | Sheet | row|
      | search |1|
    