
CREATE DATABASE shoppingdb;
USE shoppingdb;

CREATE TABLE users(
        id INT AUTO_INCREMENT PRIMARY KEY,
        username VARCHAR(50),
password VARCHAR(50)
);

INSERT INTO users(username,password) VALUES
("user1","123"),("admin","admin");

CREATE TABLE products(
        id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(100),
price DOUBLE
);

INSERT INTO products(name,price) VALUES
("Laptop",45000),("Headphones",1500),("Keyboard",700);

CREATE TABLE cart(
        id INT AUTO_INCREMENT PRIMARY KEY,
        user_id INT,
        product_id INT,
        quantity INT
);

CREATE TABLE orders(
        id INT AUTO_INCREMENT PRIMARY KEY,
        user_id INT,
        total DOUBLE,
        order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


