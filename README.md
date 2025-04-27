# E-Commerce Data Migration Tool

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue)
![MongoDB](https://img.shields.io/badge/MongoDB-6.0-green)

A Spring Boot application for migrating e-commerce data from PostgreSQL to MongoDB with business logic validations.

## Features

- **Data Migration**: Seamless transfer of product data from PostgreSQL to MongoDB
- **Business Validations**:
  - Stock availability checks
  - Product expiration validation (>20 days)
  - Automatic sales amount calculation
- **Reporting**:
  - Available products listing
  - Sales reports with vendor and product details
  

## Prerequisites

- Java 17
- PostgreSQL 15+
- MongoDB 6.0+
- Maven 3.8+

## Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/ecommerce-migration.git
```

2. Configure databases in `application.properties`:
```properties
# PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce
spring.datasource.username=postgres
spring.datasource.password=yourpassword

# MongoDB
spring.data.mongodb.uri=mongodb://localhost:27017/ecommerce
```

3. Build the project:
```bash
mvn clean install
```

## API Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/products` | POST | Create new product |
| `/api/products` | GET | List all products |
| `/api/products/available` | GET | List available products |
| `/api/sales` | POST | Process new sale |
| `/api/sales/report` | GET | Generate sales report |
| `/api/migrate/products` | POST | Migrate products to MongoDB |

## Usage Examples

**Create Product:**
```bash
curl -X POST -H "Content-Type: application/json" -H "Authorization: Basic YWRtaW46cGFzc3dvcmQ=" \
-d '{
  "description": "Premium Coffee",
  "price": 12.99,
  "entryDate": "2023-11-01",
  "stockQuantity": 50,
  "expirationDate": "2024-11-01"
}' \
http://localhost:8080/api/products
```

**Process Sale:**
```bash
curl -X POST -H "Content-Type: application/json" -H "Authorization: Basic YWRtaW46cGFzc3dvcmQ=" \
-d '{
  "productId": 1,
  "vendorId": 1,
  "quantity": 2
}' \
http://localhost:8080/api/sales
```

## Database Schema

### PostgreSQL Tables

**products**
```
id (SERIAL PK)
description (VARCHAR)
price (DECIMAL)
entry_date (DATE)
stock_quantity (INT)
expiration_date (DATE)
```

**sales**
```
id (SERIAL PK)
product_id (INT FK)
vendor_id (INT FK)
sales_datetime (TIMESTAMP)
quantity (INT)
sales_amount (DECIMAL)
```

### MongoDB Collections

**products**
```json
{
  "_id": ObjectId,
  "description": String,
  "price": NumberDecimal,
  "entryDate": ISODate,
  "stockQuantity": Int32,
  "expirationDate": ISODate
}
```

## Architecture

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── ecommerce/
│   │           └── migration/
│   │               ├── core/           # Domain layer
│   │               ├── application/    # Application services
│   │               ├── presentation/   # Controllers
│   │               └── infrastructure/ # DB implementations
│   └── resources/
└── test/                              # Test cases
```

## License

MIT License

