create database StudentPortal;
use StudentPortal;

create table Register (
id int not null auto_increment,
student_name varchar(255),
student_address varchar(255),
student_email varchar(255),
student_password varchar(255),
course_name varchar(255),
primary key (id)
);

create table Student (
student_id int not null auto_increment,
student_name varchar(255),
student_address varchar(255),
student_email varchar(255),
student_password varchar(255),
primary key (student_id)
);

create table Administrator(
id int not null auto_increment,
admin_name varchar(255),
admin_password varchar(255),
admin_email varchar(255),
contact varchar(255),
primary key (id)
);

-- Default data for testing

INSERT INTO Student(student_name, student_address, student_email, student_password)
VALUES("Michael False", "185 Princeton drive", "mf@student.belgiumcampus.ac.za", "123MF_Princeton"),
("Sarah Georgina", "23 Morrow Ave", "sg@student.belgiumcampus.ac.za","1likech33s3"),
("Steven Gwenio", "23 Sandton Dr", "sgw@student.belgiumcampus.ac.za","Sandsweightaton"),
("Lethabo Mongwale", "24 Sandton Dr", "lm@student.belgiumcampus.ac.za","IT_is_THE_best"),
("Mika Haikennen", "11 Oswald St", "mh@student.belgiumcampus.ac.za","f1_legends_123");

INSERT INTO Register(student_name, student_address, student_email, student_password, course_name)
VALUES("Michael False", "185 Princeton drive", "mf@student.belgiumcampus.ac.za", "123MF_Princeton", "BIT"),
("Sarah Georgina", "23 Morrow Ave", "sg@student.belgiumcampus.ac.za", "1likech33s3","Diploma"),
("Steven Gwenio", "23 Sandton Dr", "sgw@student.belgiumcampus.ac.za", "Sandsweightaton", "BComp"),
("Lethabo Mongwale", "24 Sandton Dr", "lm@student.belgiumcampus.ac.za", "IT_is_THE_best", "BComp"),
("Mika Haikennen", "11 Oswald St", "mh@student.belgiumcampus.ac.za", "f1_legends_123", "Diploma - Deaf");

INSERT INTO Administrator(admin_name, admin_password, admin_email, contact)
VALUES ("Angela Prost", "ProstyFr0sty", "a.prost@belgiumcampus.ac.za", "0734452123"),
("Paballo Dzidzai", "pd_whoop_wh00p", "p.dzidzai@belgiumcampus.ac.za", "0823341321")




