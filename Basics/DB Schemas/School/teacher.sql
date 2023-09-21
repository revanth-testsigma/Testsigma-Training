CREATE TABLE Teacher (
    id INT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    dob DATE NOT NULL,
    gender ENUM('Male', 'Female', 'Other') NOT NULL,
    address VARCHAR(150) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20) UNIQUE NOT NULL,
    joinDate DATE NOT NULL,
    salary DECIMAL(10, 2) NOT NULL,
    Createdby bigint not null DEFAULT = "Admin",
    Createdon DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX TeacherId ON Teacher (id);