create database order_system;

use order_system;

drop table if exists user;

create table user(
userId int primary key auto_increment,
name varchar(20) unique,
password varchar(50),
isAdmin int -- 1表示是管理员 0 表示不是管理员
);
drop table if exists menu;

create table menu (
dishId int primary key auto_increment,
dishName varchar(50) unique,
price int
);

drop table if exists order_user;

create table order_user (
orderId int primary key auto_increment,
userId int,
time date,
isDone int, -- 1 表示订单已经处理 0 表示订单没有处理
foreign key(userId) references user(userId)
);

drop table if exists order_dish;

create table order_dish (
orderId int,
dishId int,
foreign key(orderId) references order_user(orderId),
foreign key(dishId) references menu(dishId)
);


