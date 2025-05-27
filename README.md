## 🛒 Spring Boot E-Commerce REST API with Stripe Integration

A simple yet powerful **E-commerce backend API** built using **Spring Boot**, featuring:
- Product management
- Cart system
- Payment processing via **Stripe**
- In-memory database (H2) for development
- Swagger UI for API documentation

This project is ideal for beginners and intermediate developers learning how to build RESTful services in Java with real-world integrations like payment gateways.

---

### 🧾 Features

| Feature | Description |
|--------|-------------|
| ✅ RESTful APIs | CRUD operations for products, cart, and payments |
| 💳 Stripe Integration | Generate checkout links using Stripe Checkout Session |
| 🛒 Shopping Cart System | Add items to cart, manage cart state |
| 📦 H2 Database | Lightweight in-memory DB for development/testing |
| 🧪 Swagger UI | Interactive API documentation at `/swagger-ui/index.html` |
| 🧩 Maven Build | Easy setup and dependency management |

---

### 🧰 Technologies Used

| Technology | Version |
|------------|---------|
| Java | 17+ |
| Spring Boot | 3.5.x |
| Maven | 3.8+ |
| H2 Database | In-memory |
| Stripe SDK | 20.120.0 |
| Lombok | Optional |
| Swagger UI | SpringDoc OpenAPI |

---

### 🚀 Getting Started

#### 1. Clone the Repository

```bash
git clone https://github.com/mehedibu2013/ecommerce.git
cd ecommerce
```

#### 2. Install Dependencies

```bash
mvn clean install
```

#### 3. Configure Application

Edit `application.properties`:

```properties
# Server port
server.port=8081

# H2 Database
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA Settings
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

# Stripe API Key (Get it from https://dashboard.stripe.com/test/apikeys)
stripe.api.key=sk_test_XXXXXXXXXXXXXXXXXXXXXX
```

#### 4. Run the App

```bash
mvn spring-boot:run
```

App will be available at:  
🔗 [http://localhost:8081](http://localhost:8081)

---

### 🧪 Test Endpoints

#### 🔹 Products
- `GET /api/products` – Get all products
- `POST /api/products` – Add a new product

Example Product JSON:
```json
{
  "name": "Smartwatch",
  "description": "Fitness tracker with heart rate monitor",
  "price": 79.99
}
```

#### 🔹 Cart
- `POST /api/cart` – Create a new cart
- `PUT /api/cart/{cartId}/add-item` – Add an item to the cart
- `GET /api/cart/{cartId}` – View cart contents

Example Cart Item:
```json
{
  "product": {
    "id": 1
  },
  "quantity": 2
}
```

#### 🔹 Payments
- `GET /api/payments/checkout?productName=Smartwatch&amount=79.99&currency=usd` – Generate Stripe checkout link

Open returned URL → use test card:  
💳 `4242 4242 4242 4242`

---

### 🧪 Access Tools

| Tool | URL |
|------|-----|
| Swagger UI | [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html) |
| H2 Console | [http://localhost:8081/h2-console](http://localhost:8081/h2-console) |
| JDBC URL | `jdbc:h2:mem:testdb` |
| H2 User | `sa` |
| H2 Password | `<empty>` |

---

### 🧪 Sample Stripe Payment Flow

1. Add a product (e.g., Smartwatch)
2. Create a cart (`POST /api/cart`)
3. Add item to cart (`PUT /api/cart/1/add-item`)
4. Generate Stripe link (`GET /api/payments/checkout?productName=Smartwatch&amount=79.99&currency=usd`)
5. Use test card `4242 4242 4242 4242` to complete payment

---

### 🧱 Project Structure

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

### 🧪 Future Enhancements (Suggested)

- JWT authentication for users
- Order history tracking
- Stripe webhook integration for payment confirmation
- MongoDB or PostgreSQL support
- Frontend (React/Angular/Vue) integration

---

### 🤝 Contributing

Contributions are welcome! If you'd like to improve this project, feel free to fork and submit a pull request.

---

### 📄 License

MIT License – see [`LICENSE`](LICENSE) for details.

---