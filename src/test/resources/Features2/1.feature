Feature: Open Search

Scenario: Open Google Search
    Given that I open the "chrome" browser
    When I enter the "https://www.google.com"
    Then I enter the value in "searchtextbox" as "Java" in "google" page
		