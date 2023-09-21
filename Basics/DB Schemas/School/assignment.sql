CREATE TABLE Assignment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(200),
    deadline DATE,
    max_score DECIMAL(5, 2),
    Createdby bigint not null,
    Createdon DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (course_id) REFERENCES Course(id) ON DELETE CASCADE ON UPDATE CASCADE
);