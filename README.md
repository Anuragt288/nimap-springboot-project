# Nimap Infotech - Machine Test Project

This project is developed using **Spring Boot** as part of the machine test for **Nimap Infotech**.

## ✅ Tech Stack
- Spring Boot
- REST API
- JPA & Hibernate
- MySQL
- Maven

## ✅ Requirements Implemented

### 1. Category CRUD
| Method | Endpoint                             | Description                 |
|--------|--------------------------------------|-----------------------------|
| GET    | `/api/categories?page=3`             | Get all categories (paginated) |
| POST   | `/api/categories`                    | Create a new category       |
| GET    | `/api/categories/{id}`               | Get category by ID          |
| PUT    | `/api/categories/{id}`               | Update category by ID       |
| DELETE | `/api/categories/{id}`               | Delete category by ID       |

### 2. Product CRUD
| Method | Endpoint                             | Description                 |
|--------|--------------------------------------|-----------------------------|
| GET    | `/api/products?page=2`               | Get all products (paginated) |
| POST   | `/api/products`                      | Create a new product        |
| GET    | `/api/products/{id}`                 | Get product by ID + category |
| PUT    | `/api/products/{id}`                 | Update product by ID        |
| DELETE | `/api/products/{id}`                 | Delete product by ID        |

### 3. Relation
- One-to-Many: One Category → Many Products

### 4. Pagination
- Server-side pagination implemented using `Pageable`

### 5. Product Details Include Category
- While fetching product by ID, related category details are included in the response.

---

## ✅ How to Run

1. Clone the repository
2. Import into Eclipse/IntelliJ as Maven project
3. Create MySQL DB  `nimap_db
4. Configure `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nimap_db
spring.datasource.username=root
spring.datasource.password=Anurag@1

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
