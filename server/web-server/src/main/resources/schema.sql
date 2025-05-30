CREATE TABLE Users (

                       name VARCHAR(255),
                       email VARCHAR(255),
                       password VARCHAR(255) UNIQUE,
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
