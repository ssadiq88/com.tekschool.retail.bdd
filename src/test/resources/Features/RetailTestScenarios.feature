Feature: Retail Test Scenarios

Background:
Given User is on Retail website 

@RegisterForm
Scenario: Register Account for new Retail user

When User click on MyAccount
And User cilck on Register
And User fill out Register form with below information
|firstName|lastName|email|phone|password| 
|Saba1|Sadiq1|ssadiq@gmail.com|5552223344|sadiq123|
And User Select 'Yes' for Subscribe
And User click on privvacy and policy check box
And User click on Continue button
Then User Should see message 'Your Account Has Been Created!'