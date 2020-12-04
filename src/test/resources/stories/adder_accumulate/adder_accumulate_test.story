Meta:

Narrative:
As user
I want to accumulate a number
So that I can have the sum and save the accumulation on server

Scenario: A user can submit a number to adder, get current sum and save the value on server
Given a number
When I submit another number to adder for accumulation
Then I get a sum of the numbers and the accumulation is on server
