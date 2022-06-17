SqlCommands.Sql

 Introduction to SqlCommands

create database `test`;

drop database `test`;

use `test`;

create table `person`(
`id` int not null auto_increment,`name` varchar(50),`age` int(3),primary key (`id`));

insert into `person` (`name`,`age`) values ('Pmk',21);

select * from `person`;

update `person` set `name`='Lu Pyae' where id=3;

delete from person; //danger, delete all rows

delete from person where `name`='Patric';

truncate `person`; //reset table
--------------------------------------------
Sql Quaries

show tables;

drop table `person`;

select * from `person` order by `country`; //ascending

select * from `person` order by `country` desc; //descending

select distinct(country) from person; //remove duplication

select * from `person` where `age`>=16 and `age`<=21;

select * from `person` where age between 16 and 21; //same as above

select `name` from `person` where `country`='Thailand' or country = 'Japan';

select `name` from `person` where `country` in ('Myanmar','Japan'); 

select * from `person` where `name` like 'p%';//pmk

select * from `person` where `name` like '%u%'; //SuSu,AungAung
-----------------------------------------------
Modifying Columns in the table

alter table `person` add column `gender` varchar(6) after `age`; 

update `person` set `gender`='female' where `id` in (4,6);

update `person` set `gender`='male' where `gender` is null;//cant use `gender`=null

describe `person`;// check the sizes (defination)

alter table `person` modify column `gender` varchar(10);

alter table `person` drop column `gender`;
---------------------------------------------
SqlQuaries(Aggregate Function)

alter table `person` add column `money` decimal after `country`; 

alter table `person` modify column `money` decimal(4,2);

update `person` set `money`='50.55' where id=1;

alter table `person` modify column `money` decimal(5,2);

select sum(`money`) from `person`;

select avg(`money`) from `person`;

select min(`money`) from `person`;

select max(`money`) from `person`;

select count(`name`) from `person`;

select count(`name`) as total_person from `person`;

select count(distinct `country`) from `person`;

select count(distinct `country`) as `total_countries` from `person`;
--------------------------------------------
Joining tables

select p.name, l.brand from `person` p join `laptop` l on l.owner=p.name;

select p.name, l.brand from `person` p join `laptop` l on l.owner=p.name where p.name='Pmk';
---------------------------------------------
Subquaries

select max(age) from `person`;

select * from `person` where age=(select max(age) from `person`);

select * from `person` where age=(select min(age) from `person`);

Select * from `person` where `name` in (select `owner` from `laptop`);

Select * from `person` where `name` not in (select `owner` from `laptop`);
----------------------------------------------
One to One RS

create table `person`(
`id` int not null auto_increment,
`name` varchar(50),
`age` int(3),
`laptop_id` int,
 primary key (`id`),
foreign key(`laptop_id`) references laptop(`id`) on delete set null
);

insert into `laptop` (`brand`) values ('Dell'),('Lenovo'),('HP');

insert into `person` (`name`,`age`,`laptop_id`) values ('Pmk',21,6),('Hsu',25,7),('ZawAung',22,8),('LuPyae',21,7),('Acat',26,6);

--------------------------------------------------
One to Many RS

create table `person`(
`id` int not null auto_increment,
`name` varchar(50),
 primary key (`id`));

create table `laptop`(
`id` int auto_increment not null,
`brand` varchar(30),
`person_id` int,
primary key(`id`),
foreign key(`person_id`) references person(id) on delete cascade);
----------------------------------------------

Many to Many RS

create table `student`(
`id` int not null auto_increment,
`name` varchar(50),
 primary key (`id`));

create table `major`(
`id` int auto_increment not null,
`major` varchar(50),
primary key (`id`));

create table student_major(
`id` int auto_increment not null,
`student_id` int,
`major_id` int,
primary key (`id`),
foreign key (`student_id`) references `student`(`id`) on delete cascade,
foreign key (`major_id`) references `major`(`id`) on delete set null
);

select s.`name`,m.`major` from `student` s join `student_major` sm join `major` m on s.`id`=sm.`student_id` and m.`id`=sm.`major_id`;

-------------------------------------------------

