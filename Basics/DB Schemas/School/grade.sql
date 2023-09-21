CREATE TABLE Grade (
    id INT AUTO_INCREMENT PRIMARY KEY ,
    enrollment_id INT NOT NULL,
    assignment_id INT NOT NULL,
    score DECIMAL(5, 2) NOT NULL,
    remarks VARCHAR(200),
    FOREIGN KEY (enrollment_id) REFERENCES Enrollment(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (assignment_id) REFERENCES Assignment(id) ON DELETE CASCADE ON UPDATE CASCADE
);
