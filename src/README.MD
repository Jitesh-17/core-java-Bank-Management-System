# Bank Management System

## Overview

The Bank Management System is a console-based Java application that simulates basic banking operations. It allows users to create bank accounts, perform deposits and withdrawals, check account balances, view transaction history, and persist data using file handling.

This project was built to strengthen Core Java concepts such as Object-Oriented Programming (OOP), Collections Framework, Exception Handling, File I/O, and layered application design.

---

## Features

* Create a new bank account
* Automatically generate unique account numbers
* Search account by account number
* Deposit money
* Withdraw money
* Check account balance
* View transaction history
* Custom exception handling
* Save accounts to file
* Load accounts on application startup
* Save transaction history
* Restore transaction history on restart

---

## Technologies Used

* Java
* Collections Framework (`HashMap`, `ArrayList`)
* Exception Handling
* File Handling (`FileReader`, `FileWriter`, `BufferedReader`)
* Object-Oriented Programming

---

## Project Structure

```text
src/
└── main/
    ├── Account.java
    ├── Transaction.java
    ├── AccountRepository.java
    ├── AccountService.java
    ├── FileService.java
    ├── InvalidAmountException.java
    ├── InsufficientBalanceException.java
    ├── BankMenu.java
    └── BankApplication.java
```

---

## Architecture

```text
User
  │
  ▼
BankMenu
  │
  ▼
AccountService
  ├─────────────► FileService
  │                   │
  │                   ▼
  │           accounts.txt
  │           transactions.txt
  │
  ▼
AccountRepository
  │
  ▼
HashMap<String, Account>
```

### Responsibilities

#### BankApplication

Application entry point. Initializes services and starts the menu.

#### BankMenu

Handles user interaction and menu navigation.

#### AccountService

Contains business logic for account operations.

#### AccountRepository

Stores and retrieves accounts using a HashMap.

#### FileService

Handles persistence by reading and writing account and transaction data to files.

#### Account

Represents a bank account with account details and transaction history.

#### Transaction

Represents a deposit or withdrawal operation.

---

## Core Java Concepts Demonstrated

### Object-Oriented Programming

* Classes and Objects
* Constructors
* Encapsulation
* Composition

### Collections Framework

* HashMap for account storage
* ArrayList for transaction history

### Exception Handling

* Custom Exceptions

  * InvalidAmountException
  * InsufficientBalanceException

### File Handling

* FileReader
* FileWriter
* BufferedReader

### Application Design

* Service Layer
* Repository Layer
* Separation of Concerns

---

## Example Workflow

### Create Account

```text
Enter Name: Jitesh
Enter Initial Balance: 10000

Account Created Successfully
Account Number: ACC1001
```

### Deposit

```text
Enter Account Number: ACC1001
Enter Amount: 5000

Amount Deposited Successfully
```

### Transaction History

```text
DEPOSIT : 5000.0
WITHDRAW : 2000.0
DEPOSIT : 1000.0
```

---

## Data Persistence

### accounts.txt

```text
ACC1001,Jitesh,10000.0
ACC1002,Rahul,5000.0
```

### transactions.txt

```text
ACC1001,DEPOSIT,5000.0
ACC1001,WITHDRAW,2000.0
```

All account and transaction data is restored when the application starts.

---

## Learning Outcomes

Through this project, I gained practical experience with:

* Java OOP principles
* Layered application architecture
* Collections Framework
* Custom exception handling
* File persistence
* Building a complete console-based application from scratch

---

## Future Enhancements

* JDBC and MySQL integration
* User authentication
* Interest calculation
* Fund transfer between accounts
* GUI using JavaFX or Swing
* Spring Boot REST API version

---

## Author

Jitesh Das

Core Java Learning Project
