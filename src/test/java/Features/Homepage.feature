Feature: Homepage and search functionalities

Background: User launches the application
Given Swiggy URL is working for the user

#This is location search - Positive TC
 @regression
Scenario Outline: User can able to enter valid delivery location
When user is able to enter location in delivery location
Then Check user is able to see restaurants lists

#This is the location search with "locate me" icon - negative TC
@regression
Scenario Outline: User can able to enter delivery location using "Locate me"Icon
When user clicks on "Locate me" icon in delivery location
Then Check user is able to see the error message if its outside India 

#This is the search function test case
 @smoke @regression
Scenario Outline: User can able to search food item 
When user is able to enter location in delivery location
Then Check user is able to see restaurants lists
And Search for the food Item
And Check user can able to see the search results

#This is the "Add item to the cart" test case
@regression 
Scenario Outline: User can able to add food item 
When user is able to enter location in delivery location
Then Check user is able to see restaurants lists
And Search for the food Item
And Check user can able to see the search results
Then user able to add food item
And Check added food item is in the cart






