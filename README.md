# Spring Security with JWT  
A practical implementation of Spring Boot Security with JWT token generation and authentication.

---

## 🚀 Prerequisites

- **Java:** 17  
- **IDE:** VS Code / IntelliJ / Spring STS 
- **Database:** PostgreSQL  

---

## ⚙️ Configuration & Execution

### 🔧 Technologies Used

- **Java 17**
- **Spring Boot 3.4.4**
- **MySQL Workbench**

---

### 📥 Setup Instructions

1. **Clone the Repository**  
   Open your terminal and run:
   ```bash
   git clone https://github.com/NithinU2802/spring_security.git
   cd spring_security
   ```
2. Update Maven Dependencies
   Perform a Maven update to download all project dependencies. You can do this from your IDE or by running:
   ```
    mvn clean install
   ```
3. Set Up the Database
   Open MySQL Workbench or your preferred MySQL client and execute the SQL queries in [data.sql](https://github.com/NithinU2802/spring_security/blob/master/src/main/resources/data.sql).
4. Configure Environment Variables
   Create a .env file in the root directory of the project (/spring_security) and add the following content, updating the values to match your setup:
   ```
   SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/db_name
   SPRING_DATASOURCE_USERNAME={your_username}
   SPRING_DATASOURCE_PASSWORD={your_password}
   JWT_SECRET_KEY={your_256_bit_secret_key}
   ```
5. Run the Application
   Start the application from the main method in AppApplication.java (located in the root package). You can run it directly from your IDE or using the command:
  ```
   mvn spring-boot:run
  ```

---

### ✅ Features

1. User authentication with JWT
2. Secure endpoints with role-based access control
3. Environment-based configuration
4. PostgreSQL database integration

---

### 📂 Project Structure

```
├── src/
│ ├── main/
│ │ ├── java/com/security/app/
│ │ │ ├── config/
│ │ │ │ └── SecurityConfig.java
│ │ │ ├── controller/
│ │ │ │ ├── AuthController.java
│ │ │ │ ├── HomeController.java
│ │ │ │ ├── ProfileController.java
│ │ │ │ └── UserController.java
│ │ │ ├── dto/
│ │ │ │ ├── LoginDTO.java
│ │ │ │ ├── ProfileDTO.java
│ │ │ │ └── UserDTO.java
│ │ │ ├── model/
│ │ │ │ └── Profile.java
│ │ │ ├── repository/
│ │ │ │ └── ProfileRepository.java
│ │ │ ├── security/
│ │ │ │ ├── JwtFilter.java
│ │ │ │ └── JwtUtil.java
│ │ │ ├── service/
│ │ │ │ ├── impl/
| | | | | ├── ProfileServiceImpl.java
│ │ │ │ │── CustomUserDetailService.java
│ │ │ │ │── ProfileService.java
│ │ │ └── AppApplication.java
│ │ └── resources/
│ │ ├── application.properties
│ │ └── data.sql
│ └── test/java/com/security/app/
│ └── AppApplicationTests.java
├── .env
├── pom.xml
└── README.md
```

---

### 📬 Contact

For any queries or suggestions, feel free to reach out via [GitHub Issues](https://github.com/NithinU2802/spring_security/issues).
