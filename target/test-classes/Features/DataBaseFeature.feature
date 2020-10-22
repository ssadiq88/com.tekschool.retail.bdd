Feature: Database SQL query feature
@sqlquery
Scenario: Execute all information from Actor Table
Given User connect to PostgresSQL
When User sends "select * from public.actor"
Then User should get all information from that table