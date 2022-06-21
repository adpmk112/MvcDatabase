create table `student`(
`id` int not null auto_increment,
`name` varchar(50), `birth` varchar(50), `gender` varchar(50), `education` varchar (50),
primary key (`id`));

create table `course`(
`id` int not null auto_increment,
`name` varchar(50), primary key(`id`));

create table `student_course`(
`id` int not null auto_increment,
`student_id` int not null,
`course_id` int not null,
 primary key(`id`),
 foreign key (`student_id`) references `student`(`id`) on delete cascade,
 foreign key (`course_id`) references `course`(`id`) on delete cascade);