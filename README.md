# PalindromeCount
A rest api, that gets a list of innovators and generates a count of all possible palindromes, using innovators first and last names


#Palindrome count/generation logic

Given a name "Nicolas Tesla",  

a) The project combines the first and the last names("NicolasTesla") 

b) We derive unique characters that make up the string

c) Since its a palindrome the first half the string contains the same characters as the second half. 
Using this to our advantage the code only generates the first half of all possible palindromes

d) We generate all the possible combinations of possible from the unique character list( from step 2)  of String-length/2.

e) We keep a cound of all such combinations of characters and return it as palindrome count.


We do the above process for all innovators

#API Reponse
The response from the api contains all the palindrome counts of the innovators and
also a referece to the url that was requested for developer purposes.


[
  {
    "RodgerDyson": 1000000
  },
  {
    "GeoffreyBruder": 4782969
  },
  {
    "PedroMedelius": 10000000
  },
  {
    "TracyGibson": 1771561
  },
  {
    "MarkLewis": 59049
  },
  {
    "DavidHoward": 531441
  },
  {
    "DennisSmith": 531441
  },
  {
    "DeanAlhorn": 59049
  },
  {
    "BinChen": 1296
  },
  {
    "MeyyaMeyyappan": 279936
  },
  <b>{
    "href": "http://localhost:8010/palicount/palindromes?search=electricity&limit=4"
  }</b>
]
