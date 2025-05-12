CREATE DATABASE jwt_auth_db;

USE jwt_auth_db;

CREATE TABLE credentials(
     id INT AUTO_INCREMENT PRIMARY KEY,
     username VARCHAR(50) UNIQUE NOT NULL,
     email VARCHAR(100) UNIQUE NOT NULL,
     password VARCHAR(255) NOT NULL
 );