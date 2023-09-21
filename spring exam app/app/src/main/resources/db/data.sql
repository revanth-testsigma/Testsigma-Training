insert into Question(title,opt1,opt2,opt3,opt4,answer,level,qsubject) values("Biggest Animal ?","Elephant","Camel","Ant","Man","Elephant","Easy","GK");
insert into Question(title,opt1,opt2,opt3,opt4,answer,level,qsubject) values("Fastest Animal ?","Chetah","Camel","Ant","Man","Chetah","Easy","GK");
insert into Question(title,opt1,opt2,opt3,opt4,answer,level,qsubject) values("Is human an Animal ?","Yes","No","Don't know","I am not human !","Yes","Medium","GK");

insert into Question(title,opt1,opt2,opt3,opt4,answer,level,qsubject) values("2+3*5","25","17","10","15","25","Easy","Math");
insert into Question(title,opt1,opt2,opt3,opt4,answer,level,qsubject) values("4*4+8-7","17","10","25","18","17","Medium","Math");
insert into Question(title,opt1,opt2,opt3,opt4,answer,level,qsubject) values("345*23-45/3","7920","1234","7930","45/3","7920","Hard","Math");

insert into Exam(title, esubject, etime) values("GK Exam", "GK", 30);
insert into Exam(title, esubject, etime) values("Math Exam", "Math", 60);

insert into exam_questions(exam_id,questions_id) values(1,1);
insert into exam_questions(exam_id,questions_id) values(1,2);

insert into exam_questions(exam_id,questions_id) values(2,4);
insert into exam_questions(exam_id,questions_id) values(2,5);