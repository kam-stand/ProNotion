CREATE TABLE IF NOT EXISTS Users (

                       name VARCHAR(255),
                       email VARCHAR(255) UNIQUE,
                       password VARCHAR(255) ,
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS Tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    user_id INT,
    due_date TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(id)
    );
