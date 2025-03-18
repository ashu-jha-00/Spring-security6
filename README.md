# Spring Boot Security Project

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.3-brightgreen) ![Java](https://img.shields.io/badge/Java-21-blue) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17.4-lightblue) ![Spring Security](https://img.shields.io/badge/Spring%20Security-Active-orange) ![HikariCP](https://img.shields.io/badge/HikariCP-Enabled-yellow)

## 🚀 Project Overview
This is a **Spring Boot Security** project implementing **JWT authentication** and **role-based access control** to secure RESTful APIs. It uses **Spring Security**, **JPA (Hibernate)**, and **PostgreSQL** as the database.

## 🔒 Security Features
- **JWT Authentication** for secure login and API access.
- **Role-Based Access Control (RBAC)** with `USER` and `ADMIN` roles.
- **BCrypt Password Encoding** for securely storing passwords.
- **Spring Security Filters** for request validation.
- **Stateless Authentication** using `SessionCreationPolicy.STATELESS`.
- **CSRF Protection Disabled** (since it's a stateless API using JWT).

## 🛠️ Tech Stack
- **Backend:** Spring Boot (3.4.3), Spring Security, Java 21
- **Database:** PostgreSQL 17.4, JPA (Hibernate), HikariCP
- **Authentication:** JSON Web Tokens (JWT), Spring Security
- **Build Tool:** Maven

## 📌 API Endpoints
### 🔑 **Authentication APIs**
| Method | Endpoint       | Description |
|--------|--------------|-------------|
| `POST` | `/register`  | Register a new user |
| `POST` | `/login`     | Authenticate and get JWT token |

### 👥 **User APIs** (Requires Authentication)
| Method | Endpoint      | Description |
|--------|-------------|-------------|
| `GET`  | `/students`  | Get all students (Authenticated Users) |
| `POST` | `/students`  | Add a new student (Authenticated Users) |

### 🛡️ **Security Middleware**
- **JWT Token Filter** to validate and process requests.
- **Custom Authentication Provider** using `DaoAuthenticationProvider`.
- **Password Encoding** using `BCryptPasswordEncoder`.

## 🔧 Setup Instructions
### 1️⃣ **Clone the Repository**
```sh
 git clone https://github.com/yourusername/spring-security-project.git
 cd spring-security-project
```

### 2️⃣ **Set Up PostgreSQL Database**
Ensure PostgreSQL is running and update `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/security_db
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
spring.datasource.driver-class-name=org.postgresql.Driver
```

### 3️⃣ **Run the Application**
```sh
mvn spring-boot:run
```

### 4️⃣ **Test APIs**
Use **Postman** or **cURL** to test API endpoints. Example login request:
```sh
curl -X POST http://localhost:8080/login -H "Content-Type: application/json" -d '{"username":"testuser", "password":"password"}'
```

## 🛡️ JWT Authentication Workflow
1. **User logs in** using `/login` with valid credentials.
2. **JWT token** is returned and stored in the client.
3. **Client sends JWT** in `Authorization: Bearer <token>` for protected endpoints.
4. **Spring Security validates** the token before processing the request.

---
### 🎯 **Contribute & Support**
Want to contribute? Feel free to **fork**, create a **pull request**, or **star ⭐ the repository**!

