# Police Archive Management System

## Overview
This project is a simple **Police Archive Management System** that allows administrators to manage cases and regular users to add cases. The system supports user authentication and role-based access control.

## Features
- **User Authentication**: Users can log in or register as either a regular user or an admin.
- **Role-Based Access Control**:
  - Regular users can add new cases.
  - Admins can add and delete cases.
- **Database Integration**: Uses PostgreSQL to store users and cases.

## Technologies Used
- **Java**: Core programming language
- **JDBC**: Database connectivity
- **PostgreSQL**: Database management system
- **Scanner**: User input handling
- **IntelliJ IDEA**: Recommended IDE for development

## Main Classes
### 1. `Main`
   - Entry point of the application.
   - Handles user input and navigation.
   
### 2. `User`
   - Represents a general user.
   - Stores user credentials and personal details.
   
### 3. `Admin`
   - Extends `User`.
   - Has additional privileges like deleting cases.
   
### 4. `UserManager`
   - Handles user authentication and registration.
   
### 5. `Case`
   - Represents a police case.
   - Stores case details such as name, year, category, and victim.
   
### 6. `CaseManager`
   - Handles adding and deleting cases in the database.
   
### 7. `DatabaseHandler`
   - Manages database connection and queries.

## Installation and Setup
### Prerequisites
- Java Development Kit (JDK) installed
- IntelliJ IDEA installed
- PostgreSQL installed and running

### Database Configuration
1. Create a PostgreSQL database named `police_archive`.
2. Create the required tables using the following SQL commands:

```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE cases (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    year INT NOT NULL,
    category VARCHAR(255) NOT NULL,
    victim VARCHAR(255) NOT NULL
);
