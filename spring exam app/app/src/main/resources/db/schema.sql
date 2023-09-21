SET FOREIGN_KEY_CHECKS = 0;
drop table if EXISTS Question, Exam, exam_questions;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE Question(
    id int PRIMARY KEY AUTO_INCREMENT,
    title Varchar(150) not null,
     opt1 Varchar(50) not null,
     opt2 Varchar(50) not null,
     opt3 Varchar(50) not null,
     opt4 Varchar(50) not null,
     answer Varchar(50) not null,
     level Varchar(50) not null,
     qsubject Varchar(50) not null
);

CREATE TABLE Exam(
    id int PRIMARY KEY AUTO_INCREMENT,
    title Varchar(50) not null,
    esubject Varchar(50) not null,
    etime int not null DEFAULT 60
);

CREATE TABLE exam_questions(
    exam_id int not null,
    questions_id int NOT NULL,
    FOREIGN KEY (exam_id) REFERENCES Exam(id),
    FOREIGN KEY (questions_id) REFERENCES Question(id)
);