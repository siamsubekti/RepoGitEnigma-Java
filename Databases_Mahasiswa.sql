CREATE database mahasiswa;
use mahasiswa;

CREATE TABLE student (
id int not null,
nama varchar (45),
birth_place varchar (51),
birth_date date,
gender enum('L','P'),
PRIMARY KEY(id)
);

CREATE TABLE subject(
id int (11),
nama varchar (100),
primary key (id)
);

insert into gender values (1, 'Laki-Laki');
insert into gender values (2, 'Perempuan');

insert into student values (1, 'Beb', 'JackerCity', '1998-06-03', '1', '2');
insert into student values (2, 'Bob', 'JokerCity', '1997-09-01', '1', '1');
insert into student values (3, 'Nesh', 'NowerCity', '1997-07-04', '3', '2');
insert into student values (4, 'KLom', 'CherryCity', '1996-02-01', '1', null);
insert into student values (5, 'Hack', 'BlackCity', '1990-08-07', '1', null);
insert into student values (6, 'Kvock', 'NorshiaCity', '1996-09-21', '2', null);
insert into student values (7, 'Heck', 'CioerCity', '1995-08-24', null, 2);
insert into student values (8, 'Chears', 'NemCity', '1994-09-09', '3', '1');
insert into student values (9, 'Loum', 'JikoCity', '1998-08-17', '1', '1');
insert into student values (10, 'Fersh', 'HobCity', '1997-12-27', '5', '2');

select * from `student`;
select * from `subject`;
select * from `gender`;

alter table `student` drop `gender`;

insert into `subject` values (1, `Algorithm`);
insert into `subject` values (2, `Databases`);
insert into `subject` values (3, `Mathematic`);
insert into `subject` values (4, `Comercial Law`);
insert into `subject` values (5, `Philosophy`);

alter table student add subject_id int;
alter table student add gender_id int;

alter table `student` add foreign key (subject_id) references `subject`(id);
alter table `student` add foreign key (gender_id) references `gender`(id);

select * from student;

update student set gender_id = "2" where id = 1;
update student set gender_id = "1" where id = 2;
update student set gender_id = "2" where id = 3;
update student set gender_id = null where id = 4;
update student set gender_id = null where id = 5;
update student set gender_id = null where id = 6;
update student set gender_id = "2" where id = 7;
update student set gender_id = "1" where id = 8;
update student set gender_id = "1" where id = 9;
update student set gender_id = "2" where id = 10;

select * from `student` inner join `subject` on `student`.`subject_id` = `subject`.`id` inner join `gender` on `student`.gender_id = `gender`.`id`; 
select * from `student` left join `subject` on `student`.`subject_id` = `subject`.`id` left join `gender` on `student`.gender_id = `gender`.`id`;
select * from `student` right join `subject` on `student`.`subject_id` = `subject`.`id` right join `gender` on `student`.gender_id = `gender`.`id`;

select * from `student` left join `subject` on `student`.`subject_id` = `subject`.`id` left join `gender` on `student`.gender_id = `gender`.`id`
union
select * from `student` right join `subject` on `student`.`subject_id` = `subject`.`id` right join `gender` on `student`.gender_id = `gender`.`id`;

