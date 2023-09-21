SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS Students, Teachers, Subjects, Classes, Attendance;
SET FOREIGN_KEY_CHECKS = 1;
create table Students(
    Student_Id int PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Dob DATE NOT NULL,
    Gender VARCHAR(1),
    Address VARCHAR(150),
    Phone BIGint,
    Email VARCHAR(50)
);

create table Subjects(
    Subject_Id int PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Desp VARCHAR(150) NOT NULL
);

create table Teachers(
    Teacher_Id int PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Dob DATE NOT NULL,
    Gender VARCHAR(1),
    Address VARCHAR(150),
    Phone BIGint,
    Email VARCHAR(50),
    Subject int,
    Joindate DATE,
    Salary BIGint,
    FOREIGN KEY (Subject) REFERENCES Subjects(Subject_Id)
);


create table Classes(
    Class_Id int PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    ClassTeacher_Id int,
    FOREIGN KEY (ClassTeacher_Id) REFERENCES Teachers(Teacher_Id)
);

create table Attendance(
    Attendance_Id int Primary Key,
    Student_Id int,
    Class_Id int,
    Attendance_date date,
    Status VARCHAR(10) NOT NULL,
    Foreign Key (Student_Id) References Students(Student_Id),
    Foreign Key (Class_Id) References Classes(Class_Id)
);

INSERT INTO Subjects VALUES(
     1,'Revant','hello'
);