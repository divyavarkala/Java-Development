BEGINNER LEVEL
📘 Enhanced Console-Based Calculator
📌 Project Overview

This project is a console-based calculator that supports not only basic arithmetic operations but also scientific functions and unit conversions. It was built to practice Java fundamentals such as loops, conditionals, methods, and exception handling.

The project demonstrates clean modular code and input validation to make the calculator user-friendly and robust.

✨ Features

✅ Basic Arithmetic – Addition, subtraction, multiplication, division
✅ Scientific Functions – Square root, power, trigonometric functions (sin, cos, tan, etc.)
✅ Unit Conversion – Temperature (Celsius ↔ Fahrenheit), Currency (USD ↔ INR)
✅ Error Handling – Prevents invalid input and division by zero
✅ Modular Methods – Each function organized for readability and maintainability

📂 Folder Structure
EnhancedCalculator/
│── EnhancedCalculator.java   # Calculator implementation
│── README.md                 # Project documentation

⚙️ Prerequisites

Java 17 or later (JDK 23 works fine ✅)

🚀 How to Compile and Run
Step 1: Compile
javac EnhancedCalculator.java

Step 2: Run
java EnhancedCalculator

📝 Example Usage
=== Welcome to Enhanced Console Calculator ===
1. Basic Arithmetic
2. Scientific Functions
3. Unit Conversion
4. Exit

Enter your choice: 1
Enter first number: 10
Enter second number: 5
Choose operation: +, -, *, /
Result: 15

📖 Learning Outcomes

Practiced Java basics (loops, conditionals, switch-case, methods)

Implemented exception handling for invalid inputs

Understood how to use Java Math library functions

Gained confidence in building console-based interactive applications

📇 Simple Contact Management System
📌 Project Overview

This project is a Contact Management System implemented in Java using ArrayLists. It demonstrates CRUD operations (Create, Read, Update, Delete) on contact data such as name, phone number, and email.

The system also supports duplicate validation and keyword search.

✨ Features

✅ Add Contacts – Store name, phone, and email
✅ View All Contacts – Display stored contacts
✅ Update & Delete – Modify or remove contacts easily
✅ Duplicate Validation – Prevents duplicate entries by phone/email
✅ Keyword Search – Find contacts by partial name or number
✅ Optional File Export – Save contact list to a file (if enabled)

📂 Folder Structure
ContactManager/
│── ContactManager.java       # Main application with CRUD logic
│── README.md                 # Project documentation

⚙️ Prerequisites

Java 17 or later (JDK 23 works fine ✅)

🚀 How to Compile and Run
Step 1: Compile
javac ContactManager.java

Step 2: Run
java ContactManager

📝 Example Usage
=== Contact Manager ===
1. Add Contact
2. View Contacts
3. Search Contact
4. Update Contact
5. Delete Contact
6. Exit

Enter choice: 1
Enter name: Divya
Enter phone: 9876543210
Enter email: divya@example.com
Contact added successfully!

📖 Learning Outcomes

Learned CRUD operations in Java

Implemented ArrayList for dynamic data storage

Practiced OOP concepts (encapsulation via Contact class)

Gained skills in search and validation logic

Prepared for building larger-scale data management systems

INTERMEDIATE LEVEL
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

📦 Inventory Management System with Basic GUI
📌 Project Overview

This project is a Java Swing-based GUI application to manage product inventory. It allows adding, updating, deleting, and viewing product details such as product name, price, quantity, and barcode.

The system also includes validation to prevent invalid inputs and a feature to calculate total stock value.

✨ Features

✅ Add Products – Store product name, price, quantity, and barcode
✅ Update & Delete – Modify or remove products easily from the list
✅ View Inventory – Products displayed in a table format for clarity
✅ Validation – Prevents invalid quantities, negative prices, or empty fields
✅ Total Stock Value – Calculates the total value of inventory dynamically
✅ User-Friendly GUI – Built with Java Swing (JTable, JTextFields, Buttons)

📂 Folder Structure
InventorySystem/
│── InventorySystem.java     # Main GUI application
│── README.md                # Project documentation

⚙️ Prerequisites

Java 17 or later (JDK 23 works fine ✅)

🚀 How to Compile and Run
Step 1: Compile
javac InventorySystem.java

Step 2: Run
java InventorySystem

📝 Example Usage

Start the app → GUI window opens

Enter:

Product Name: Pen
Quantity: 100
Price: 10
Barcode: P001


Click Add Product → Product appears in table

Use Update Product or Delete Product buttons to manage inventory

Click Calculate Stock Value → Displays total inventory worth

📖 Learning Outcomes

Gained hands-on experience with Java Swing components (JFrame, JTable, JButton, JTextField, etc.)

Learned event handling for interactive GUIs

Implemented form validation to improve user experience

Applied OOP principles to design a clean and maintainable system

Understood the importance of data representation in tables and forms
