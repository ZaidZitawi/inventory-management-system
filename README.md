# Inventory Management System

## Project Overview

This Inventory Management System is designed to streamline the process of tracking and managing inventory, suppliers, and transactions for businesses. By leveraging a structured relational database, the system aims to maintain high data integrity and provide a comprehensive overview of inventory operations.

## Entity-Relationship Diagram
![inventory managmetn system ](https://github.com/ZaidZitawi/inventory-management-system/assets/111902956/f8253072-0f72-4d37-954e-f45c08076f9a)


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

| HTTP request (method URI)           | Operation                | Description                                          | HTTP status codes                                       | Request sample                                                      | Response sample                                                 |
|-------------------------------------|--------------------------|------------------------------------------------------|---------------------------------------------------------|--------------------------------------------------------------------|------------------------------------------------------------------|
| POST /products                      | Add Product              | Add a new product                                    | 201 (Created), 400 (Bad Request)                        | `{ "productName": "Widget", "category": "Hardware", "price": 15.99 }` | `{ "productId": 1, "productName": "Widget", "category": "Hardware", "price": 15.99 }` |
| GET /products/{productId}           | Get Product              | Retrieve product details by ID                       | 200 (OK), 404 (Not Found)                               | N/A                                                                | `{ "productId": 1, "productName": "Widget", "category": "Hardware", "price": 15.99 }` |
| PUT /products/{productId}           | Update Product           | Update product information by ID                     | 200 (OK), 400 (Bad Request), 404 (Not Found)            | `{ "productName": "Widget", "category": "Electronics", "price": 16.99 }` | `{ "message": "Product updated successfully." }`                |
| DELETE /products/{productId}        | Delete Product           | Delete a product by ID                               | 200 (OK), 404 (Not Found)                               | N/A                                                                | `{ "message": "Product deleted successfully." }`                |
| GET /inventory                      | List Inventory           | List all inventory items                             | 200 (OK)                                                | N/A                                                                | `[{ "inventoryId": 1, "productId": 1, "quantity": 100, "warehouseLocation": "A1" }]` |
| PUT /inventory/{productId}          | Update Inventory         | Update inventory quantity for a product              | 200 (OK), 400 (Bad Request), 404 (Not Found)            | `{ "quantity": 150 }`                                             | `{ "message": "Inventory updated successfully." }`              |
| GET /suppliers                      | List Suppliers           | List all suppliers                                   | 200 (OK), 401 (Unauthorized), 500 (Internal Server Error) | N/A                                                                | `[{"supplierId": 1, "name": "Acme Corp", "contactInfo": "contact@example.com"}]` |
| POST /suppliers                     | Add Supplier             | Add a new supplier                                   | 201 (Created), 400 (Bad Request), 401 (Unauthorized), 500 (Internal Server Error) | `{ "name": "Acme Corp", "contactInfo": "contact@example.com" }` | `{ "supplierId": 1, "name": "Acme Corp", "contactInfo": "contact@example.com" }` |
| GET /suppliers/{supplierId}         | Get Supplier             | Retrieve supplier details by ID                      | 200 (OK), 404 (Not Found), 401 (Unauthorized), 500 (Internal Server Error) | N/A                                                                | `{ "supplierId": 1, "name": "Acme Corp", "contactInfo": "contact@example.com" }` |
| PUT /suppliers/{supplierId}         | Update Supplier          | Update supplier information by ID                    | 200 (OK), 400 (Bad Request), 404 (Not Found), 401 (Unauthorized), 500 (Internal Server Error) | `{ "name": "Acme Updated", "contactInfo": "updated_contact@example.com" }` | `{ "message": "Supplier updated successfully." }`              |
| DELETE /suppliers/{supplierId}      | Delete Supplier          | Delete a supplier by ID                              | 200 (OK), 404 (Not Found), 401 (Unauthorized), 500 (Internal Server Error) | N/A                                                                | `{ "message": "Supplier deleted successfully." }`                |
| GET /transactions                   | List Transactions        | List all transactions                                | 200 (OK), 401 (Unauthorized), 500 (Internal Server Error) | N/A                                                                | `[{"transactionId": 1, "type": "stock-in", "productId": 1, "quantity": 50, "timestamp": "2024-04-16T12:00:00Z"}]` |
| POST /transactions                  | Log Transaction          | Log a new transaction                                | 201 (Created), 400 (Bad Request), 401 (Unauthorized), 500 (Internal Server Error) | `{ "type": "stock-in", "productId": 1, "quantity": 50 }`          | `{ "transactionId": 1, "type": "stock-in", "productId": 1,


## Getting Started

To set up and run the application, follow these steps:

1. **Clone the Repository**
   - `git clone <repository-url>`
   
2. **Database Setup**
   - Ensure you have a SQL database system (e.g., MySQL) installed and running.
   - Execute the SQL scripts provided in the `SQL/` directory to create the database and tables.
