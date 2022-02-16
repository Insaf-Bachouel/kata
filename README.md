
## Bank account Kata: Account managment
Bank account kata

Think of your personal bank account experience. When in doubt, go for the simplest solution

Requirements

Deposit and Withdrawal
Account statement (date, amount, balance)
Statement printing
The expected result is a service API, and its underlying implementation, that meets the expressed needs.
Nothing more, especially no UI, no persistence.

User Stories

US 1:

In order to save money
As a bank client
I want to make a deposit in my account

US 2:

In order to retrieve some or all of my savings
As a bank client
I want to make a withdrawal from my account

US 3:

In order to check my operations
As a bank client
I want to see the history (operation, date, amount, balance) of my operations

 ## Solution
 
 The Solution was developed using Spring Boot 2.6  OPEN API 3 + Swagger UI 
 
 ## Start
 - You can Clone the project on your Desktop
 - You can run the application on your favourite IDE Eclipse, STS, Intellij.. 


## REST API Documentation
When The application is running.
The REST API provided by the application are available on this link (we can try the APIs via this link) : 

http://localhost:8080/swagger-ui/index.html


Since there is no persistence we used one static acount on which the operations are made (it could be a list instead). 
The account is initialised with a balance = 1500.







