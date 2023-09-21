CREATE TABLE Student (
    id Bigint PRIMARY KEY AUTO_INCREMENT = 1,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    dob DATE NOT NULL,
    gender ENUM('Male', 'Female', 'Other') NOT NULL,
    address VARCHAR(150),
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20) UNIQUE,
    parent_name VARCHAR(100),
    parent_phone VARCHAR(20) UNIQUE NOT NULL,
    Createdby bigint not null,
    Createdon DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX StudentId ON Student (id);
