drop database if exits stu_exam;
create database stu_exam default charset utf8mb4;

use stu_exam;

create table stu(
  id int primary key auto_increment,
  name varchar(20) unique
);

create table course(
  id int primary key auto_increment,
  name varchar(20) unique
);

create table score(
  id int primary key auto_increment,
  score decimal(4, 1), -- 0到150分 小数位1位
  stu_id int,
  course_id int,
  foreign key (stu_id) references stu(id),
  foreign key (course_id) references course(id)
);

insert into stu(name) values ("张三");
insert into course(name) values ("语文");
insert into score(score, stu_id, course_id) values (90, 1, 1);