## Programming Foundations: Databases
#### Databases
- Provide structure for data
- Allow enforcement of rules for data
- Protect data from unauthorized access or changes

#### Types of Databases Relationships
- One-to-many
- Many-to-many
- One-to-one

#### SQL - Structured Query Language
- Relational Databases Management System (RDBMS) Tools:
    - Support American National Standards Institute (ANSI) SQL
- Many offer versions of the language that extends ANSI SQL to include features specific to that DBMS
    - Transact-SQL (T-SQL), used by Microsoft SQL Server
    - MySQL, an open-source DBMS
- Allows statements to be written for DBMS to interpret how to interact with data
    - SQL is called a data manipulation language (DML)
- Offers feature to manage the database itself, such as creating or modifying tables and controlling access to tables
    - SQL is called a data definition language (DDL) and a data control language (DCL)

**SQL Statement**

~~~~sql
SELECT FirstName, LastName FROM Customers
WHERE LastName = 'Augustine';
~~~~
`"Show me the first name and last name for every record in the Customers table, please."`

~~~~sql
SELECT FirstName, LastName FROM Customers
WHERE Birthday = '1992-08-12';
~~~~
`"Show me the first name and last name for every record in the Customers table with a specific birthday, please."`

