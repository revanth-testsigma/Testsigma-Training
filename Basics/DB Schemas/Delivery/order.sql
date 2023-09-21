CREATE TABLE order(
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id int NOT NULL,
    status_id INT NOT NULL,
    product_id int NOT NULL,
    quantity int NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (status_id) REFERENCES status(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);
