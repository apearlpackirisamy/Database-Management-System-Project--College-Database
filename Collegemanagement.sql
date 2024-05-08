create database universitymanagementsystem;

show databases;

use universitymanagementsystem;
create table login(username varchar(25), password varchar(25));
insert into login values('admin', '12345');


create table student(lname varchar(40), fname varchar(40), IDnum varchar(20), dob varchar(40), address varchar(100), phone varchar(20), email varchar(40), SSN varchar(9), major varchar(40));


create table teacher(lname varchar(40), fname varchar(40), empId varchar(20), dob varchar(40), address varchar(100), phone varchar(20), email varchar(40), SSN varchar(20), department varchar(40));



create table subject(IDnum varchar(20), semester varchar(20), subject1 varchar(50), subject2 varchar(50), subject3 varchar(50), subject4 varchar(50), subject5 varchar(50));


create table grades(IDnum varchar(20), semester varchar(20), grades1 varchar(50), grades2 varchar(50), grades3 varchar(50), grades4 varchar(50), grades5 varchar(50));


create table tuition(course varchar(20), semester1 varchar(20), semester2 varchar(20), semester3 varchar(20), semester4 varchar(20), semester5 varchar(20), semester6 varchar(20), semester7 varchar(20), semester8 varchar(20));


insert into tuition values("Computer Science", "$12000", "$12000","$12000","$12000","$12000","$12000","$12000","$12000");

insert into tuition values("Data Science", "$12500", "$12000","$12000","$11000","$12000","$11000","$12000","$12000");

insert into tuition values("Information Technology", "$11000", "$11000","$11000","$11000","$11000","$11000","$12000","$11000");

insert into tuition values("Cyber Security","$12000","$12000","$12000","$12000","$12000","$11000","$12000","$12000");

insert into tuition values("Graphic Design", "$12000", "$12000","$12000","$12000","$11500","$11500","$11500","$12000");

insert into tuition values("BioInformatics", "$12000", "$12000","$12000","$12000","$12000","$12000","$11000","$12000");

insert into tuition values("Computer Engineering", "$11000", "$12000","$12000","$11000","$12000","$11000","$12000","$12000");

insert into tuition values("Robotics", "$11000", "$12000","$12000","$11000","$12000","$11000","$12000","$12000");

create table collegetuition(IDnum varchar(20), major varchar(20), semester varchar(20), total varchar(20));

use universitymanagementsystem;
show tables;

alter table student
modify column ssn varchar(9);

delete from tuition 
where course = CompSci;

