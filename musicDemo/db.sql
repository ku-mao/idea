drop database if exists `musicDemo`;
create database if not exists `musicDemo` character set utf8;
-- 使用数据库
use `musicDemo`;
DROP TABLE IF EXISTS `music`;
CREATE TABLE `music` (
`id` int PRIMARY KEY AUTO_INCREMENT,
`title` varchar(50) NOT NULL,
`singer` varchar(30) NOT NULL,
`time` varchar(13) NOT NULL,
`url` varchar(100) NOT NULL,
`userId` int(11) NOT NULL
);

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` varchar(20) UNIQUE NOT NULL,
`password` varchar(32) NOT NULL
);

DROP TABLE IF EXISTS `lovemusic`;
CREATE TABLE `lovemusic` (
`id` int PRIMARY KEY AUTO_INCREMENT,
`userId` int(11) NOT NULL,
`musicId` int(11) NOT NULL
);
INSERT INTO user(username,password)
VALUES("drr","123");