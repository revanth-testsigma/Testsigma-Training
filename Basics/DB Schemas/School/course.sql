CREATE TABLE Course(
    id INT PRIMARY KEY AUTO_INCREMENT ,
    name VARCHAR(100) NOT NULL,
    credit INT NOT NULL,
    department VARCHAR(100),
    Createdby bigint not null,
    Createdon DATETIME DEFAULT CURRENT_TIMESTAMP
);