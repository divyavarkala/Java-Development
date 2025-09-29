🏦 Bank Account Management System with Unit Testing
📌 Project Overview

This project is a Java-based Bank Account Management System that demonstrates core banking operations such as deposit, withdrawal, balance inquiry, interest calculation, and transaction tracking.

The system also includes JUnit 5 test cases to validate functionality, showcasing Test-Driven Development (TDD) in Java.

✨ Features

✅ Deposit & Withdraw – Add or withdraw money with overdraft protection
✅ Balance Tracking – Always know your current balance
✅ Interest Calculation – Apply percentage-based interest on the account
✅ Transaction History – Logs deposits, withdrawals, and interest events
✅ Overdraft Protection – Prevents withdrawals beyond set overdraft limit
✅ JUnit 5 Tests – Each method has at least 5+ automated test cases

📂 Folder Structure
BankApp/
│── src/
│   └── BankApp.java        # Contains BankAccount + JUnit Tests
│── libs/
│   └── junit-platform-console-standalone-6.0.0-RC3.jar
│── out/                    # Compiled class files
│── README.md               # Project documentation

⚙️ Prerequisites

Java 17 or later (since your compiler is JDK 23, that works fine ✅)

JUnit 5 Console Standalone JAR (already in libs/)

🚀 How to Compile and Run
Step 1: Compile the project
cd BankApp
javac -cp libs/junit-platform-console-standalone-6.0.0-RC3.jar -d out src/BankApp.java

Step 2: Run JUnit Tests
java -jar libs/junit-platform-console-standalone-6.0.0-RC3.jar execute --class-path out --scan-classpath


✅ Expected Output:
All 6 test cases should pass successfully.

+-- JUnit Jupiter [OK]
| '-- BankAccountTest [OK]
|   +-- testDepositNegativeAmountThrows() [OK]
|   +-- testTransactionHistoryTracks() [OK]
|   +-- testDepositIncreasesBalance() [OK]
|   +-- testWithdrawBeyondOverdraftThrows() [OK]
|   +-- testWithdrawDecreasesBalance() [OK]
|   '-- testAddInterestWorks() [OK]

📝 Example Business Rules Implemented

Deposit must be positive → negative amounts throw error

Withdrawal must not exceed balance + overdraft limit

Interest increases balance by a percentage

All transactions are recorded in history

System is validated with unit tests

📖 Learning Outcomes

OOP Principles: Encapsulation, validation, modular methods

Unit Testing: Writing JUnit tests for each method

TDD Approach: Develop rules → confirm via tests

Error Handling: Prevent invalid operations
