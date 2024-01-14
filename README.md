# Product-Management-System
The "Product Management System" is a Java-based application designed to manage product information in a SQL database.
 It is a versatile tool suitable for small to medium-sized businesses,
 providing functionalities to add, update, delete, and view product details.
 This system is compatible with SQL Workbench and phpMyAdmin, offering flexibility in database management.
 I used pictures of cars as a products but it can be any other products.
 (If you want to clone the project and use or to run it, Check the explanation in the Setup and Installation subsection).
 #### The project can be a component of a larger Customer Relationship Management (CRM) system, especially if integrated with customer data and sales processes.

## Key Highlights:

#### Effective Object-Oriented Design: 
The Product class, with its encapsulated fields and methods, exemplifies best practices in Java OOP, ensuring data integrity and system maintainability.
#### Secure Database Interaction: 
Utilization of PreparedStatement in ProductDAO for database operations, emphasizing my commitment to writing secure, SQL injection-proof code.
#### Efficient Resource Management: 
Demonstrated through the use of try-with-resources statements in ProductDAO, ensuring proper handling and release of database resources.

##### CRUD = Create, Read, Update, and Delete
#### CRUD Operations Mastery: 
Implementation of essential CRUD functionalities, underscoring my skills in creating comprehensive data management applications.


## Features
Database Connectivity: Connects to a SQL database to perform operations.
CRUD Operations: Allows Create, Read, Update, and Delete operations on product data.
Image Handling: Supports adding and updating product images.
Data Validation: Checks for valid input before database operations.
User Interface: Provides a graphical user interface for easy interaction.

### Explain On The Files In The Project:
##### Product entity
The class properly encapsulates its fields, adhering to the principles of Object-Oriented Programming. 
This encapsulation ensures that the state of each Product instance can only 
be altered through its methods, promoting data integrity.
[product entity 📂 ](https://github.com/Masanbat12/Product-Management-System-/blob/main/Product_Menagement/src/main/java/Product.java)

##### xml
The provided XML package content is a Maven Project Object Model (POM) file, 
which is central to a project's configuration in Maven. 
It's used to define the project's structure, manage dependencies, and configure the build process.
[xml 📂 ](https://github.com/Masanbat12/Product-Management-System-/blob/main/Product_Menagement/pom.xml)

##### P_DAO
The ProductDAO (Data Access Object) class you've shared is a concrete example of how to interact with a database in a Java application,
specifically for managing products. 
It's a fundamental piece in the architecture of applications following the DAO pattern, separating business logic from database interaction.
[P_DAO](https://github.com/Masanbat12/Product-Management-System-/blob/main/Product_Menagement/src/ProductDAO.java)

##### DatabaseTest
This is a Java class DatabaseTest that demonstrates how to establish a connection to
a MySQL database using JDBC (Java Database Connectivity).
The code is a basic template for connecting to a MySQL database using JDBC in Java. 
It's important to replace the username and password with valid credentials for your database, 
and ensure that the JDBC URL matches your database's configuration.
Also, it's crucial to handle database connections responsibly, ensuring they are closed after use to prevent resource leaks.
[DatabaseTest 📂](https://github.com/Masanbat12/Product-Management-System-/blob/main/Product_Menagement/src/main/java/DatabaseTest.java)

## Snippts Pictures Of Running The Code And Match With DB:
### In here you can see the Before and After of any action in the code and how it's custom with the Workbench of MySQL Database (DB).
[PICS 📂 ](https://github.com/Masanbat12/Product-Management-System-/tree/main/Product_Menagement/P_M_S%20Project%20Results%20Pics)
#### Here's the finalized Result, that ended with product id '1996' 
<img width="600" alt="Final_Results_that_can_be_seen_in_DB" src="https://github.com/Masanbat12/Product-Management-System-/assets/93978448/1d54015a-2529-4aa9-8a3a-d9115d274069">

### Pictures of Products and Icons:
[Products and Icons pic's 📂 ](https://github.com/Masanbat12/Product-Management-System-/tree/main/Product_Menagement/src/main/resources)
## Requirements
- Java Development Kit (JDK),
- SQL Workbench or phpMyAdmin,
- JDBC driver for SQL database,
- NetBeans environment, and knowledge how to use it.

## Setup and Installation
#### Database Configuration:
- Set up your SQL database and import the necessary schema.
- Adjust the database connection URL, username, and password in the getConnection() method in ProductForm.java.
#### JDBC Driver:
- Ensure that the JDBC driver for your database is installed and configured in your project.
#### Compile and Run:
- Compile the Java files.
- Run ProductForm.java to start the application.

## Usage
#### Start Application: 
- Launch ProductForm.java.
#### Connect to Database: 
- The application will automatically try to connect to the configured database.
#### Add Product: 
- Fill in the product details and click the 'Insert' button.
#### Update Product: 
- Select a product, modify details, and click 'Update'.
#### Delete Product: 
- Select a product and click 'Delete'.
#### Navigate Records: 
- Use navigation buttons to browse through product records.

## Customization
#### Database Settings:
- Adjust the database URL,
- username,
- and password in getConnection() to match your setup.
#### SQL Queries: 
- Modify the SQL queries in ProductForm.java as needed for your database schema.

#### Limitations
#### Database Dependency: 
- Requires an active connection to a SQL database.
#### Limited to Product Management: 
- Primarily focused on managing product data.
