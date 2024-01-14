# Product-Management-System-
The "Product Management System" is a Java-based application designed to manage product information in a SQL database.
 It is a versatile tool suitable for small to medium-sized businesses,
 providing functionalities to add, update, delete, and view product details.
 This system is compatible with SQL Workbench and phpMyAdmin, offering flexibility in database management.
 #### The project can be a component of a larger Customer Relationship Management (CRM) system, especially if integrated with customer data and sales processes.


## Features
Database Connectivity: Connects to a SQL database to perform operations.
CRUD Operations: Allows Create, Read, Update, and Delete operations on product data.
Image Handling: Supports adding and updating product images.
Data Validation: Checks for valid input before database operations.
User Interface: Provides a graphical user interface for easy interaction.

### Explain On The Files In The Project:
The class properly encapsulates its fields, adhering to the principles of Object-Oriented Programming. This encapsulation ensures that the state of each Product instance can only be altered through its methods, promoting data integrity.

The provided XML package content is a Maven Project Object Model (POM) file, which is central to a project's configuration in Maven. It's used to define the project's structure, manage dependencies, and configure the build process.
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
