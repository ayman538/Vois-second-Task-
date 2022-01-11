Feature: Check Numviews

Scenario: Numviews are greater than "4000"


Given Get colourlovers 
Then  Verify Numviews greater than 4000
