-- Insert multiple rows of sample data into Users table
INSERT INTO Users (user_id, username, first, middle, last, email, password, created_at)
VALUES
    (1, 'johnsmith', 'John', 'Robert', 'Smith', 'john@example.com', 'password123', CURRENT_TIMESTAMP),
    (2, 'janedoe', 'Jane', '', 'Doe', 'jane@example.com', 'pass456', CURRENT_TIMESTAMP),
    (3, 'mikesmith', 'Mike', 'James', 'Smith', 'mike@example.com', 'secret', CURRENT_TIMESTAMP);

-- Insert multiple rows of sample data into Products table
INSERT INTO Products (product_id, name, description, price, created_at)
VALUES
    (1, 'Product A', 'Description of Product A', 9.99, CURRENT_TIMESTAMP),
    (2, 'Product B', 'Description of Product B', 19.99, CURRENT_TIMESTAMP),
    (3, 'Product C', 'Description of Product C', 14.99, CURRENT_TIMESTAMP);

-- Insert multiple rows of sample data into Orders table
INSERT INTO Orders (order_id, user_id, order_date, total_amount)
VALUES
    (1, 1, '2023-06-11', 29.97),
    (2, 2, '2023-06-11', 19.99),
    (3, 3, '2023-06-10', 44.97);

-- Insert multiple rows of sample data into Order_Items table
INSERT INTO Order_Items (order_item_id, order_id, product_id, quantity, price_per_unit)
VALUES
    (1, 1, 1, 3, 9.99),
    (2, 1, 2, 1, 19.99),
    (3, 2, 3, 2, 14.99);

-- Insert multiple rows of sample data into Categories table
INSERT INTO Categories (category_id, name)
VALUES
    (1, 'Category A'),
    (2, 'Category B'),
    (3, 'Category C');

-- Insert multiple rows of sample data into Product_Categories table
INSERT INTO Product_Categories (product_id, category_id)
VALUES
    (1, 1),
    (2, 1),
    (2, 2),
    (3, 3);

-- Insert multiple rows of sample data into Reviews table
INSERT INTO Reviews (review_id, product_id, user_id, rating, comment, created_at)
VALUES
    (1, 1, 1, 4, 'Great product!', CURRENT_TIMESTAMP),
    (2, 2, 2, 5, 'Excellent product!', CURRENT_TIMESTAMP),
    (3, 3, 3, 3, 'Average product.', CURRENT_TIMESTAMP);

-- Insert multiple rows of sample data into Addresses table
INSERT INTO Addresses (address_id, user_id, street, city, state, postal_code, country)
VALUES
    (1, 1, '123 Street', 'City A', 'State A', '12345', 'Country A'),
    (2, 2, '456 Road', 'City B', 'State B', '67890', 'Country B'),
    (3, 3, '789 Avenue', 'City C', 'State C', '54321', 'Country C');
