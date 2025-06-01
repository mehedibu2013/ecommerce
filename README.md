

# 🛒 Spring Boot E-Commerce REST API with Stripe Integration

A simple yet powerful E-commerce backend API built using Spring Boot, featuring:

- Product management
- Shopping cart system
- Payment processing via Stripe
- MySQL for persistent database storage
- Swagger UI for interactive API documentation

This project is ideal for beginners and intermediate developers learning how to build RESTful services in Java with real-world integrations like payment gateways.

---

## 🧾 Features

| Feature              | Description                                      |
|----------------------|--------------------------------------------------|
| ✅ RESTful APIs       | CRUD operations for products, cart, and payments |
| 💳 Stripe Integration | Generate checkout links using Stripe Checkout    |
| 🛍 Shopping Cart System | Add items to cart, manage cart state          |
| 🗄 MySQL Database     | Persistent database for development/testing      |
| 🧪 Swagger UI         | Interactive API documentation                    |
| 🧩 Maven Build        | Easy setup and dependency management             |

---

## 🧰 Technologies Used

| Technology       | Version     |
|------------------|-------------|
| Java             | 17+         |
| Spring Boot      | 3.5.x       |
| Maven            | 3.8+        |
| MySQL            | 8.0+        |
| Stripe SDK       | 20.120.0    |
| Lombok           | Optional    |
| Swagger UI       | SpringDoc OpenAPI |

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/mehedibu2013/ecommerce.git  
cd ecommerce
```

### 2. Install Dependencies

```bash
mvn clean install
```

### 3. Configure Application

Update `application.properties` with **MySQL** settings:

```properties
# Server port
server.port=8081

# MySQL Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/spring_ecommerce?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=mysql

# JPA Settings
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Stripe API Key (Get it from https://dashboard.stripe.com/test/apikeys)  
stripe.api.key=sk_test_XXXXXXXXXXXXXXXXXXXXXX
```

> 🔐 Make sure to replace `root` and `mysql` with your actual MySQL credentials if different.

### 4. Setup MySQL Database

Create a new database in MySQL:

```sql
CREATE DATABASE spring_ecommerce;
```

Ensure that the **MySQL server is running** before starting the application.

### 5. Run the App

```bash
mvn spring-boot:run
```

App will be available at:
🔗 http://localhost:8081

---

## 🧪 Test Endpoints

### 🔹 Products

- `GET /api/products` – Get all products
- `POST /api/products` – Add a new product

#### Example Product JSON:

```json
{
  "name": "Smartwatch",
  "description": "Fitness tracker with heart rate monitor",
  "price": 79.99
}
```

### 🔹 Cart

- `POST /api/cart` – Create a new cart
- `PUT /api/cart/{cartId}/add-item` – Add an item to the cart
- `GET /api/cart/{cartId}` – View cart contents

#### Example Cart Item:

```json
{
  "product": {
    "id": 1
  },
  "quantity": 2
}
```

### 🔹 Payments

- `GET /api/payments/checkout?productName=Smartwatch&amount=79.99&currency=usd` – Generate Stripe checkout link

Open returned URL → use test card:
💳 `4242 4242 4242 4242`

---

## 🧪 Access Tools

| Tool           | URL                                              |
|----------------|--------------------------------------------------|
| Swagger UI     | http://localhost:8081/swagger-ui/index.html      |
| MySQL DB       | localhost:3306, database: `spring_ecommerce`     |

---

## 🧱 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com.example.ecommerce/
│   │       ├── model/
│   │       │   ├── Product.java
│   │       │   ├── Cart.java
│   │       │   └── CartItem.java
│   │       ├── repository/
│   │       │   ├── ProductRepository.java
│   │       │   ├── CartRepository.java
│   │       │   └── CartItemRepository.java
│   │       ├── controller/
│   │       │   ├── ProductController.java
│   │       │   ├── CartController.java
│   │       │   └── PaymentController.java
│   │       ├── service/
│   │       │   └── StripeService.java
│   │       └── EcommerceApplication.java
│   └── resources/
│       ├── application.properties
│       └── data.sql
└── test/
    └── java/
        └── com.example.ecommerce/
            └── EcommerceApplicationTests.java
```

---

## 🧪 Sample Stripe Payment Flow

1. Add a product (e.g., Smartwatch)
2. Create a cart (`POST /api/cart`)
3. Add item to cart (`PUT /api/cart/1/add-item`)
4. Generate Stripe link (`GET /api/payments/checkout?productName=Smartwatch&amount=79.99&currency=usd`)
5. Use test card `4242 4242 4242 4242` to complete payment

---

## 📈 Future Enhancements (Suggested)

- JWT authentication for users
- Order history tracking
- Stripe webhook integration for payment confirmation
- MongoDB or PostgreSQL support
- Frontend (React/Angular/Vue) integration

---

## 🤝 Contributing

Contributions are welcome! If you'd like to improve this project, feel free to fork and submit a pull request.

---

## 📄 License

MIT License – see [LICENSE](LICENSE) for details.

---

