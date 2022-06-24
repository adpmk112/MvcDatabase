create table `user`(
`id` int not null auto_increment,`email` varchar(50),`password` varchar(30),primary key (`id`));

create table `student`(
`id` int not null 
auto_increment,
`name` varchar(50),
`birth` varchar(50),
`gender` varchar(30),
`phone` varchar(50),
`education` varchar(100),
primary key(`id`));

create table student_course(
`id` int auto_increment not null,
`student_id` int,
`course_id` int,
primary key (`id`),
foreign key (`student_id`)
references `student`(`id`) on delete cascade,
foreign key (`course_id`)
references `course`(`id`) on delete set null);

select
s.`id` AS `student_id`,s.`name` AS `student_name`,s.`birth`,s.`gender`,s.`phone`,s.`education`,
c.`id` AS `course_id`, c.`name` AS `course_name` from `student` s join `student_course` sc join `course` c on
s.`id`=sc.`student_id` and c.id=sc.`course_id`;

select
s.`id` AS `student_id`,s.`name` AS `student_name`,s.`birth`,s.`gender`,s.`phone`,s.`education`,c.`id` AS `course_id`,
c.`name` AS `course_name` from `student` s join `student_course` sc join `course` c on s.`id`=sc.`student_id` 
and c.id=sc.`course_id` where s.`id`=?;

