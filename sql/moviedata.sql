//scripts to create database movie_cruiser
create database if not exists movie_cruiser;

//scripts to create table user
create table user(us_id int primary key,name varchar(25));

//scripts to create table movies
CREATE  TABLE `movie_cruiser`.`movies` (

  `movie_id` INT NOT NULL AUTO_INCREMENT ,

  `mv_title` VARCHAR(45) NULL ,

  `mv_box_office` BIGINT NULL ,

  `mv_active` VARCHAR(5) NULL ,

  `mv_date_of_launch` DATE NULL ,

  `mv_genre` VARCHAR(45) NULL ,

  `mv_has_teaser` VARCHAR(5) NULL ,

  PRIMARY KEY (`movie_id`) );

//scripts to insert datas for user and favourite
insert into user values(11,'madhu');
insert into favourite values(1,11,1);