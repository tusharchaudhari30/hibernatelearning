-- Drop tables if they exist
DROP TABLE IF EXISTS Addresses;
DROP TABLE IF EXISTS Reviews;
DROP TABLE IF EXISTS Product_Categories;
DROP TABLE IF EXISTS Categories;
DROP TABLE IF EXISTS Order_Items;
DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS Products;
DROP TABLE IF EXISTS Users;

-- Create Users table
CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    username VARCHAR(50),
    first VARCHAR(50),
    middle VARCHAR(50),
    last VARCHAR(50),
    email VARCHAR(100),
    password VARCHAR(100),
    created_at TIMESTAMP
);

-- Create Products table
CREATE TABLE Products (
    product_id INT PRIMARY KEY,
    name VARCHAR(100),
    description VARCHAR(255),
    price DECIMAL(10,2),
    created_at TIMESTAMP
);

-- Create Orders table
CREATE TABLE Orders (
    order_id INT PRIMARY KEY,
    user_id INT,
    order_date DATE,
    total_amount DECIMAL(10,2),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Create Order_Items table
CREATE TABLE Order_Items (
    order_item_id INT PRIMARY KEY,
    order_id INT,
    product_id INT,
    quantity INT,
    price_per_unit DECIMAL(10,2),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

-- Create Categories table
CREATE TABLE Categories (
    category_id INT PRIMARY KEY,
    name VARCHAR(50)
);

-- Create Product_Categories table
CREATE TABLE Product_Categories (
    product_id INT,
    category_id INT,
    FOREIGN KEY (product_id) REFERENCES Products(product_id),
    FOREIGN KEY (category_id) REFERENCES Categories(category_id)
);

-- Create Reviews table
CREATE TABLE Reviews (
    review_id INT PRIMARY KEY,
    product_id INT,
    user_id INT,
    rating INT,
    comment VARCHAR(255),
    created_at TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES Products(product_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Create Addresses table
CREATE TABLE Addresses (
    address_id INT PRIMARY KEY,
    user_id INT,
    street VARCHAR(100),
    city VARCHAR(50),
    state VARCHAR(50),
    postal_code VARCHAR(20),
    country VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);
