# Inventory Management System

## Project Overview

This Inventory Management System is designed to streamline the process of tracking and managing inventory, suppliers, and transactions for businesses. By leveraging a structured relational database, the system aims to maintain high data integrity and provide a comprehensive overview of inventory operations.

## Entity-Relationship Diagram
![inventory managmetn system ](https://github.com/ZaidZitawi/-inventory-management-system/assets/111902956/3df252df-d013-4295-8190-6c73f13821c5)


## Features

- **Product Management**: Facilitates adding, updating, and removing products within the system.
- **Supplier Management**: Allows for detailed management of supplier information, including linking products to specific suppliers.
- **Inventory Tracking**: Provides capabilities to closely monitor stock levels, manage restocking processes, and oversee product distributions.
- **Transaction Logging**: Keeps a detailed record of all inventory transactions, including stock ins and outs, with precise timestamps.

## API Link on OpenAPI specification 3.1.0 "SwaggerHub".
https://app.swaggerhub.com/apis-docs/ZAIDZITAWI879/Inventory_Managment/1.0.0

## Database Schema

The system's database is structured around four core tables, each serving a critical function in the inventory management process:

1. **Suppliers**
   - Stores comprehensive information about the suppliers, including contact details.
   
2. **Products**
   - Contains detailed entries for each product, such as name, category, supplier ID, unit of measure, and price.

3. **Inventory**
   - Manages stock levels for each product, including the quantity available and the location within the warehouse.

4. **Transactions**
   - Logs every transaction involving inventory, detailing the type of transaction, the product affected, quantity, and the date/time of the event.

## Sample Data For DB Schema

### Suppliers Table

| supplierId | name    | contactInfo                                      |
|------------|---------|--------------------------------------------------|
| 1          | ABC Corp| Email: contact@abccorp.com \| Phone: 123-456-7890 |
| 2          | XYZ Inc | Email: info@xyzinc.com \| Phone: 987-654-3210     |

### Products Table

| productId | productName      | category     | supplierId | unit  | price |
|-----------|------------------|--------------|------------|-------|-------|
| 1         | Laptop           | Electronics  | 1          | Piece | 1200  |
| 2         | Desktop Computer | Electronics  | 1          | Piece | 800   |
| 3         | HDMI Cable       | Accessories  | 2          | Piece | 20    |
| 4         | Monitor          | Electronics  | 2          | Piece | 300   |

### Inventory Table

| inventoryId | productId | quantity | warehouseLocation  |
|-------------|-----------|----------|--------------------|
| 1           | 1         | 30       | Section B|
| 2           | 2         | 45       | Section C|
| 3           | 3         | 150      | Section D|
| 4           | 4         | 75       | Section E|

### Transactions Table

| transactionId | type      | productId | quantity | timestamp           |
|---------------|-----------|-----------|----------|---------------------|
| 1             | Stock-In  | 1         | 10       | 2024-04-15 10:00 |
| 2             | Stock-Out | 2         | 5        | 2024-04-15 11:00 |
| 3             | Stock-In  | 3         | 20       | 2024-04-16 09:30 |
| 4             | Stock-Out | 4         | 7        | 2024-04-16 10:00 |
 

## Documentation for each resource
## API Endpoints

Below are the API endpoints for managing users within the system:

| HTTP request (method URI) | Operation            | Description                                     | HTTP status codes                                 | Request sample                                                              | Response sample                                                      |
|---------------------------|----------------------|-------------------------------------------------|---------------------------------------------------|----------------------------------------------------------------------------|----------------------------------------------------------------------|
| POST /users               | Create               | Creates a new user                              | 201 (Created), 400 (Bad Request), 405 (Method Not Allowed), 409 (Conflict) | `{ "username": "zaid ziawti", "email": "zaid@example.com", "password": "secret" }` | `{ "userId": 1, "username": "zaid zitawi", "email": "zaid@example.com" }` |
| GET /users                | Read                 | Retrieves a list of users                       | 200 (OK), 204 (No Content), 400 (Bad Request)    | N/A                                                                          | `[{"userId": 1, "username": "zaid zitawi", "email": "zaid@example.com"}]` |
| PUT /users/{id}           | Update/Replace       | Updates an existing user's full information     | 200 (OK), 400 (Bad Request), 404 (Not Found), 409 (Conflict) | `{ "username": "zaid_updated", "email": "zaid_updated@example.com", "password": "new_secret" }` | `{ "userId": 1, "username": "zaid_updated", "email": "zaid_updated@example.com" }` |
| PATCH /users/{id}         | Partial Update/Modify | Partially updates an existing user's information | 200 (OK), 400 (Bad Request), 404 (Not Found)    | `{ "email": "zaid_new@example.com" }`                                     | `{ "userId": 1, "username": "zaid", "email": "zaid_new@example.com" }` |
| DELETE /users/{id}        | Delete               | Deletes a specified user                        | 200 (OK), 400 (Bad Request), 404 (Not Found)    | N/A                                                                          | `{ "message": "User deleted successfully." }`                          |
| GET /users/{id}           | Read user info       | Retrieves details for a specified user          | 200 (OK), 404 (Not Found)                        | N/A                                                                          | `{ "userId": 1, "username": "zaid", "email": "zaid@example.com" }` |

## Getting Started

To set up and run the application, follow these steps:

1. **Clone the Repository**
   - `git clone <repository-url>`
   
2. **Database Setup**
   - Ensure you have a SQL database system (e.g., MySQL) installed and running.
   - Execute the SQL scripts provided in the `sql/` directory to create the database and tables.

3. **Application Configuration**
   - Navigate to the application's root directory.
   - Update the `config.json` (or relevant configuration file) with your database connection details.

4. **Running the Application**
   - Run `npm start` or the equivalent command based on your application setup to start the server.
   - Access the application through the specified port on your local machine (e.g., `http://localhost:3000`).
